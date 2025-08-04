package com.gw.xmlcompare.comparators;

import com.gw.xmlcompare.comparators.utils.ComparatorUtilities;
import com.gw.xmlcompare.loader.XmlLoaderJaxb;
import com.gw.xmlcompare.model.XMLDiffResult;
import com.gw.xmlcompare.model.formpatterns.*;
import com.gw.xmlcompare.config.UniqueKeyConfig;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Field;
import java.util.*;

import static com.gw.xmlcompare.utils.ConstantUtils.*;

public class FormPatternComparator {

    public static List<XMLDiffResult> results = new ArrayList<>();
    public static final String FORM_PATTERNS_CONFIG_ROOT = "FormPatterns";
    public static FormPatterns oldFormPatternsConfig;
    public static FormPatterns newFormPatternsConfig;

    public static List<XMLDiffResult> compare(String code, FormPattern oldConfig, FormPattern newConfig) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();

        // Compare all fields within FormPattern except Lookups
        diffs.addAll(compareFormPatternFields(code, oldConfig, newConfig));

        // Compare FormPatternLookup lists
        List<XMLDiffResult> lookupDiffs = compareFormPatternLookupLists(code, oldConfig, newConfig);
        diffs.addAll(lookupDiffs);

        // If no diffs found, add a no-change result
        if (diffs.isEmpty()) {
            diffs.add(new XMLDiffResult("FORM_PATTERNS_CONFIG_XML", code, null, "-", "-", NO_CHANGE, "FORM_PATTERNS_CONFIG_XML"));
        }
        return diffs;
    }

    /*public static List<XMLDiffResult> compareFormPatterns() throws Exception {
        // Make necessary changes to the XML files before mapping to Java objects
        makeFileChangesAndLoad();

        Map<String, FormPattern> oldMap = toCodeMap(oldFormPatternsConfig.getFormPattern());
        Map<String, FormPattern> newMap = toCodeMap(newFormPatternsConfig.getFormPattern());

        Set<String> allCodes = new HashSet<>();
        allCodes.addAll(oldMap.keySet());
        allCodes.addAll(newMap.keySet());

        for (String code : allCodes) {
            FormPattern oldFormPattern = oldMap.get(code);
            FormPattern newFormPattern = newMap.get(code);

            if (oldFormPattern == null) {
                results.add(new XMLDiffResult("FORM_PATTERNS_CONFIG_XML", code, "", "N/A", newFormPattern.toString(), NEW, "New Form Patterns Config XML"));
            } else if (newFormPattern == null) {
                results.add(new XMLDiffResult("FORM_PATTERNS_CONFIG_XML", code, "", oldFormPattern.toString(), "N/A", REMOVED, "Removed Form Patterns Config XML"));
            } else {
                List<XMLDiffResult> diffs = compare(code, oldFormPattern, newFormPattern);
                results.addAll(diffs);
            }
        }
        return results;
    }*/

    public static List<XMLDiffResult> compareFormPatterns() throws Exception {
        makeFileChangesAndLoad();

        // Step 1: Detect duplicates in old and new
        List<XMLDiffResult> duplicateResults = new ArrayList<>();
        duplicateResults.addAll(findDuplicateCodes(oldFormPatternsConfig.getFormPattern(), "old"));
        duplicateResults.addAll(findDuplicateCodes(newFormPatternsConfig.getFormPattern(), "new"));

        // If duplicates found, return immediately (or you can continue with unique ones)
        if (!duplicateResults.isEmpty()) {
            results.addAll(duplicateResults);
            return results;
        }

        // Step 2: Proceed with standard comparison for unique codes
        Map<String, FormPattern> oldMap = toCodeMap(oldFormPatternsConfig.getFormPattern());
        Map<String, FormPattern> newMap = toCodeMap(newFormPatternsConfig.getFormPattern());

        Set<String> allCodes = new HashSet<>();
        allCodes.addAll(oldMap.keySet());
        allCodes.addAll(newMap.keySet());

        for (String code : allCodes) {
            FormPattern oldFormPattern = oldMap.get(code);
            FormPattern newFormPattern = newMap.get(code);

            if (oldFormPattern == null) {
                results.add(new XMLDiffResult("FORM_PATTERNS_CONFIG_XML", code, "", "N/A", newFormPattern.toString(), NEW, "New Form Patterns Config XML"));
            } else if (newFormPattern == null) {
                results.add(new XMLDiffResult("FORM_PATTERNS_CONFIG_XML", code, "", oldFormPattern.toString(), "N/A", REMOVED, "Removed Form Patterns Config XML"));
            } else {
                List<XMLDiffResult> diffs = compare(code, oldFormPattern, newFormPattern);
                results.addAll(diffs);
            }
        }
        return results;
    }

    private static List<XMLDiffResult> findDuplicateCodes(List<FormPattern> patterns, String xmlSource) {
        Map<String, List<FormPattern>> codeMap = new HashMap<>();
        for (FormPattern fp : patterns) {
            codeMap.computeIfAbsent(fp.getCode(), k -> new ArrayList<>()).add(fp);
        }
        List<XMLDiffResult> duplicates = new ArrayList<>();
        for (Map.Entry<String, List<FormPattern>> entry : codeMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                duplicates.add(new XMLDiffResult(
                        "FORM_PATTERNS_CONFIG_XML",
                        entry.getKey(),
                        "FormPattern",
                        "Duplicate Code found in " + xmlSource + " xml file : " + entry.getKey(),
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

        oldFormPatternsConfig = XmlLoaderJaxb.loadXml(oldDoc, FormPatterns.class);
        newFormPatternsConfig = XmlLoaderJaxb.loadXml(newDoc, FormPatterns.class);
    }

    private static Map<String, FormPattern> toCodeMap(List<FormPattern> formPatterns) {
        Map<String, FormPattern> map = new HashMap<>();
        for (FormPattern formPattern : formPatterns) {
            if (formPattern.getCode() != null) {
                map.put(formPattern.getCode(), formPattern);
            }
        }
        return map;
    }

    private static List<XMLDiffResult> compareFormPatternFields(String code, FormPattern oldFormPattern, FormPattern newFormPattern) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();

        // Create copies of the FormPattern objects without the Lookups field
        FormPattern oldFormPatternCopy = new FormPattern();
        FormPattern newFormPatternCopy = new FormPattern();

        // Copy all fields except Lookups
        for (Field field : FormPattern.class.getDeclaredFields()) {
            field.setAccessible(true);
            if (!field.getName().equals("lookups")) {
                field.set(oldFormPatternCopy, field.get(oldFormPattern));
                field.set(newFormPatternCopy, field.get(newFormPattern));
            }
        }

        // Compare the copied FormPattern objects
        diffs.addAll(ComparatorUtilities.compareObjectsRecursively(code, oldFormPatternCopy, newFormPatternCopy, "FormPattern", "FORM_PATTERNS_CONFIG_XML", Collections.emptyList()));

        return diffs;
    }

    /*private static List<XMLDiffResult> compareFormPatternLookupLists(String code, FormPattern oldFormPattern, FormPattern newFormPattern) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();
        List<FormPatternLookup> oldList = oldFormPattern.getLookups().getFormPatternLookup();
        List<FormPatternLookup> newList = newFormPattern.getLookups().getFormPatternLookup();

        List<String> uniqueKeys = UniqueKeyConfig.getUniqueKeys("FormPatternLookup");

        diffs.addAll(ComparatorUtilities.compareListsByUniqueKey(code, oldList, newList, "FormPattern", "FORM_PATTERNS_CONFIG_XML", uniqueKeys));
        return diffs;
    }*/

    private static List<XMLDiffResult> compareFormPatternLookupLists(String code, FormPattern oldFormPattern, FormPattern newFormPattern) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();
        List<FormPatternLookup> oldList = oldFormPattern.getLookups().getFormPatternLookup();
        List<FormPatternLookup> newList = newFormPattern.getLookups().getFormPatternLookup();

        List<String> uniqueKeys = UniqueKeyConfig.getUniqueKeys("FormPatternLookup");

        // Adjusted path to show hierarchy
        String path = "FormPattern[" + code + "].Lookups";
        diffs.addAll(ComparatorUtilities.compareListsByUniqueKey(code, oldList, newList, path, "FORM_PATTERNS_CONFIG_XML", uniqueKeys));
        return diffs;
    }
}