package com.gw.xmlcompare.comparators;

import com.gw.xmlcompare.comparators.utils.ComparatorUtilities;
import com.gw.xmlcompare.config.UniqueKeyConfig;
import com.gw.xmlcompare.loader.XmlLoaderJaxb;
import com.gw.xmlcompare.model.XMLDiffResult;
import com.gw.xmlcompare.model.forminference.FormInferenceConfig;
import com.gw.xmlcompare.model.forminference.FormInferenceType;
import com.gw.xmlcompare.model.forminference.VersionType;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

import static com.gw.xmlcompare.utils.ConstantUtils.*;

public class FormInferenceComparator {

    public static List<XMLDiffResult> results = new ArrayList<>();
    public static final String FORM_INFERENCE_CONFIG_ROOT = "FormInferenceConfig";
    public static FormInferenceConfig oldFormInferenceConfig;
    public static FormInferenceConfig newFormInferenceConfig;

    public static List<XMLDiffResult> compare(String code, FormInferenceType oldConfig, FormInferenceType newConfig) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();

        // Compare Version lists with hierarchical path
        List<XMLDiffResult> versionDiffs = compareVersionLists(code, oldConfig, newConfig);
        diffs.addAll(versionDiffs);

        // If no diffs found, add a no-change result
        if (diffs.isEmpty()) {
            diffs.add(new XMLDiffResult("FORM_INFERENCE_CONFIG_XML", code, null, "-", "-", NO_CHANGE, "FORM_INFERENCE_CONFIG_XML"));
        }
        return diffs;
    }

    public static List<XMLDiffResult> compareFormInferencePatterns() throws Exception {
        makeFileChangesAndLoad();

        // Step 1: Detect duplicates in old and new
        List<XMLDiffResult> duplicateResults = new ArrayList<>();
        duplicateResults.addAll(findDuplicateFormCodes(oldFormInferenceConfig.getFormInference(), "old"));
        duplicateResults.addAll(findDuplicateFormCodes(newFormInferenceConfig.getFormInference(), "new"));

        if (!duplicateResults.isEmpty()) {
            results.addAll(duplicateResults);
            return results;
        }

        // Step 2: Proceed with standard comparison for unique formCodes
        Map<String, FormInferenceType> oldMap = toFormCodeMap(oldFormInferenceConfig.getFormInference());
        Map<String, FormInferenceType> newMap = toFormCodeMap(newFormInferenceConfig.getFormInference());

        Set<String> allFormCodes = new HashSet<>();
        allFormCodes.addAll(oldMap.keySet());
        allFormCodes.addAll(newMap.keySet());

        for (String formCode : allFormCodes) {
            FormInferenceType oldFormInference = oldMap.get(formCode);
            FormInferenceType newFormInference = newMap.get(formCode);

            if (oldFormInference == null) {
                results.add(new XMLDiffResult("FORM_INFERENCE_CONFIG_XML", formCode, "", "N/A", newFormInference.toString(), NEW, "New FormInference"));
            } else if (newFormInference == null) {
                results.add(new XMLDiffResult("FORM_INFERENCE_CONFIG_XML", formCode, "", oldFormInference.toString(), "N/A", REMOVED, "Removed FormInference"));
            } else {
                results.addAll(compare(formCode, oldFormInference, newFormInference));
            }
        }
        return results;
    }

    private static List<XMLDiffResult> findDuplicateFormCodes(List<FormInferenceType> inferences, String xmlSource) {
        Map<String, List<FormInferenceType>> codeMap = new HashMap<>();
        for (FormInferenceType fi : inferences) {
            codeMap.computeIfAbsent(fi.getFormCode(), k -> new ArrayList<>()).add(fi);
        }
        List<XMLDiffResult> duplicates = new ArrayList<>();
        for (Map.Entry<String, List<FormInferenceType>> entry : codeMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                duplicates.add(new XMLDiffResult(
                        "FORM_INFERENCE_CONFIG_XML",
                        entry.getKey(),
                        "FormInference",
                        "Duplicate formCode found in " + xmlSource + ": " + entry.getKey(),
                        "Human interference required",
                        CHANGED,
                        "Object"
                ));
            }
        }
        return duplicates;
    }

    private static void makeFileChangesAndLoad() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document oldDoc = builder.parse(new File(FORM_1_COMPARE));
        Document newDoc = builder.parse(new File(FORM_2_COMPARE));

        oldFormInferenceConfig = XmlLoaderJaxb.loadXml(oldDoc, FormInferenceConfig.class);
        newFormInferenceConfig = XmlLoaderJaxb.loadXml(newDoc, FormInferenceConfig.class);
    }

    private static Map<String, FormInferenceType> toFormCodeMap(List<FormInferenceType> formInferences) {
        Map<String, FormInferenceType> map = new HashMap<>();
        for (FormInferenceType formInference : formInferences) {
            if (formInference.getFormCode() != null) {
                map.put(formInference.getFormCode(), formInference);
            }
        }
        return map;
    }

    private static List<XMLDiffResult> compareVersionLists(String formCode, FormInferenceType oldFormInference, FormInferenceType newFormInference) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();
        List<VersionType> oldList = oldFormInference.getVersion();
        List<VersionType> newList = newFormInference.getVersion();

        List<String> uniqueKeys = UniqueKeyConfig.getUniqueKeys("VersionType");
        String formPath = "FormInference[" + formCode + "]";

        diffs.addAll(ComparatorUtilities.compareListsByUniqueKey(
                formCode, oldList, newList, formPath + ".Version", "FORM_INFERENCE_CONFIG_XML", uniqueKeys));
        return diffs;
    }
}