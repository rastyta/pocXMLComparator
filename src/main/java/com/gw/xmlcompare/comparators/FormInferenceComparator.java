package com.gw.xmlcompare.comparators;

import com.gw.xmlcompare.comparators.utils.ComparatorUtilities;
import com.gw.xmlcompare.loader.XmlLoaderJaxb;
import com.gw.xmlcompare.model.XMLDiffResult;
import com.gw.xmlcompare.model.forminference.FormInferenceConfig;
import com.gw.xmlcompare.model.forminference.FormInferenceType;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

import static com.gw.xmlcompare.RunComparator.FORM_1_COMPARE;
import static com.gw.xmlcompare.RunComparator.FORM_2_COMPARE;
import static com.gw.xmlcompare.comparators.utils.ComparatorUtilities.replaceRoot;

public class FormInferenceComparator {

    public static List<XMLDiffResult> results = new ArrayList<>();
    public static final String FORM_INFERENCE_ROOT = "FormInferenceConfig";
    public static FormInferenceConfig oldFormPatterns;
    public static FormInferenceConfig newFormPatterns;

    public static List<XMLDiffResult> compare(String code, FormInferenceType oldFP, FormInferenceType newFP) throws IllegalAccessException {
        List<XMLDiffResult> diffs = ComparatorUtilities.compareObjectsRecursively(code, oldFP, newFP, "FormInference");
        if(diffs.isEmpty()){
            diffs.add(new XMLDiffResult("FormInference XML",code, null,
                    "-",
                    "-",
                    "No Change", "FormInference XML"));
            return diffs;
        }
        return diffs;
    }

    public static List<XMLDiffResult> compareFormInferencePatterns() throws Exception {
        //Make necessary changes to the XML files before mapping to Java objects
        //And mapping to Java Object
        makeFileChangesAndLoad();

        Map<String, FormInferenceType> oldMap = toCodeMap(oldFormPatterns.getFormInference());
        Map<String, FormInferenceType> newMap = toCodeMap(newFormPatterns.getFormInference());

        Set<String> allCodes = new HashSet<>();
        allCodes.addAll(oldMap.keySet());
        allCodes.addAll(newMap.keySet());

        for (String code : allCodes) {
            FormInferenceType oldFP = oldMap.get(code);
            FormInferenceType newFP = newMap.get(code);

            if (oldFP == null) {
                //create method and return diff from there
                results.add(new XMLDiffResult("Forms Inference Config XML", code, "", "N/A", "N/A", "New","New Forms Inference Config XML"));
            } else if (newFP == null) {
                results.add(new XMLDiffResult("Forms Inference Config XML", code, "", "N/A", "N/A", "Removed", "Removed Forms Inference Config XML"));
            } else {
                List<XMLDiffResult> diffs = compare(code, oldFP, newFP);
                results.addAll(diffs);
            }
        }
        return results;
    }

    private static void makeFileChangesAndLoad() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document oldDoc = builder.parse(new File(FORM_1_COMPARE));
        Document newDoc = builder.parse(new File(FORM_2_COMPARE));

        oldFormPatterns = XmlLoaderJaxb.loadXml(oldDoc, FormInferenceConfig.class);
        newFormPatterns = XmlLoaderJaxb.loadXml(newDoc, FormInferenceConfig.class);
    }

    private static Map<String, FormInferenceType> toCodeMap(List<FormInferenceType> formInference) {
        Map<String, FormInferenceType> map = new HashMap<>();
        for (FormInferenceType fp : formInference) {
            if (fp.getFormCode()!= null) {
                map.put(fp.getFormCode(), fp);
            }
        }
        return map;
    }


}
