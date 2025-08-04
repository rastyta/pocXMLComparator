package com.gw.xmlcompare.comparators;

import com.gw.xmlcompare.comparators.utils.ComparatorUtilities;
import com.gw.xmlcompare.loader.XmlLoaderJaxb;
import com.gw.xmlcompare.model.XMLDiffResult;
import com.gw.xmlcompare.model.formschedule.AutoNumberPropertyInfoType;
import com.gw.xmlcompare.model.formschedule.ClauseType;
import com.gw.xmlcompare.model.formschedule.PropertyInfoType;
import com.gw.xmlcompare.model.formschedule.ScheduleConfigType;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

import static com.gw.xmlcompare.utils.ConstantUtils.*;

import com.gw.xmlcompare.model.formschedule.*;

public class FormScheduleComparator {

    public static List<XMLDiffResult> results = new ArrayList<>();
    public static final String SCHEDULE_CONFIG_ROOT = "ScheduleConfig";
    public static ScheduleConfigType oldScheduleConfig;
    public static ScheduleConfigType newScheduleConfig;

    public static List<XMLDiffResult> compare(String code, ClauseType oldConfig, ClauseType newConfig) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();

        // Compare AutoNumberPropertyInfo
        List<XMLDiffResult> autoNmbrPropInfoListsdiffs = compareAutoNumberPropertyInfo(code, oldConfig, newConfig);
        diffs.addAll(autoNmbrPropInfoListsdiffs);

        // Compare PropertyInfo lists
        List<XMLDiffResult> propertyInfodiffs = comparePropertyInfoLists(code, oldConfig, newConfig);
        diffs.addAll(propertyInfodiffs);

        // If no diffs found, add a no-change result
        if (diffs.isEmpty()) {
            diffs.add(new XMLDiffResult("SCHEDULE_CONFIG_XML", code, null, "-", "-", NO_CHANGE, "SCHEDULE_CONFIG_XML"));
        }
        return diffs;
    }

    /*public static List<XMLDiffResult> compareScheduleConfigPatterns() throws Exception {
        // Make necessary changes to the XML files before mapping to Java objects
        makeFileChangesAndLoad();

        Map<String, ClauseType> oldMap = toPatternMap(oldScheduleConfig.getClause());
        Map<String, ClauseType> newMap = toPatternMap(newScheduleConfig.getClause());

        Set<String> allPatterns = new HashSet<>();
        allPatterns.addAll(oldMap.keySet());
        allPatterns.addAll(newMap.keySet());

        for (String pattern : allPatterns) {
            ClauseType oldClause = oldMap.get(pattern);
            ClauseType newClause = newMap.get(pattern);

            if (oldClause == null) {
                results.add(new XMLDiffResult("SCHEDULE_CONFIG_XML", pattern, "", "N/A", newClause.toString(), NEW, "New Schedule Config XML"));
            } else if (newClause == null) {
                results.add(new XMLDiffResult("SCHEDULE_CONFIG_XML", pattern, "", oldClause.toString(), "N/A", REMOVED, "Removed Schedule Config XML"));
            } else {
                List<XMLDiffResult> diffs = compare(pattern, oldClause, newClause);
                results.addAll(diffs);
            }
        }
        return results;
    }*/

    public static List<XMLDiffResult> compareScheduleConfigPatterns() throws Exception {
        makeFileChangesAndLoad();

        // Step 1: Detect duplicates in old and new
        List<XMLDiffResult> duplicateResults = new ArrayList<>();
        duplicateResults.addAll(findDuplicatePatterns(oldScheduleConfig.getClause(), "old"));
        duplicateResults.addAll(findDuplicatePatterns(newScheduleConfig.getClause(), "new"));

        if (!duplicateResults.isEmpty()) {
            results.addAll(duplicateResults);
            return results;
        }

        // Step 2: Proceed with standard comparison for unique patterns
        Map<String, ClauseType> oldMap = toPatternMap(oldScheduleConfig.getClause());
        Map<String, ClauseType> newMap = toPatternMap(newScheduleConfig.getClause());

        Set<String> allPatterns = new HashSet<>();
        allPatterns.addAll(oldMap.keySet());
        allPatterns.addAll(newMap.keySet());

        for (String pattern : allPatterns) {
            ClauseType oldClause = oldMap.get(pattern);
            ClauseType newClause = newMap.get(pattern);

            if (oldClause == null) {
                results.add(new XMLDiffResult("SCHEDULE_CONFIG_XML", pattern, "", "N/A", newClause.toString(), NEW, "New Schedule Config XML"));
            } else if (newClause == null) {
                results.add(new XMLDiffResult("SCHEDULE_CONFIG_XML", pattern, "", oldClause.toString(), "N/A", REMOVED, "Removed Schedule Config XML"));
            } else {
                // Compare all fields of Clause, including nested elements
                results.addAll(compare(pattern, oldClause, newClause));
            }
        }
        return results;
    }

    private static List<XMLDiffResult> findDuplicatePatterns(List<ClauseType> clauses, String xmlSource) {
        Map<String, List<ClauseType>> patternMap = new HashMap<>();
        for (ClauseType clause : clauses) {
            patternMap.computeIfAbsent(clause.getPattern(), k -> new ArrayList<>()).add(clause);
        }
        List<XMLDiffResult> duplicates = new ArrayList<>();
        for (Map.Entry<String, List<ClauseType>> entry : patternMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                duplicates.add(new XMLDiffResult(
                        "SCHEDULE_CONFIG_XML",
                        entry.getKey(),
                        "Clause",
                        "Duplicate pattern found in " + xmlSource + ": " + entry.getKey(),
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

        oldScheduleConfig = XmlLoaderJaxb.loadXml(oldDoc, ScheduleConfigType.class);
        newScheduleConfig = XmlLoaderJaxb.loadXml(newDoc, ScheduleConfigType.class);
    }

    private static Map<String, ClauseType> toPatternMap(List<ClauseType> clauses) {
        Map<String, ClauseType> map = new HashMap<>();
        for (ClauseType clause : clauses) {
            if (clause.getPattern() != null) {
                map.put(clause.getPattern(), clause);
            }
        }
        return map;
    }

    private static List<XMLDiffResult> compareAutoNumberPropertyInfo(String pattern, ClauseType oldClause, ClauseType newClause) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();
        AutoNumberPropertyInfoType oldInfo = oldClause.getAutoNumberPropertyInfoList().isEmpty() ? null : oldClause.getAutoNumberPropertyInfoList().get(0);
        AutoNumberPropertyInfoType newInfo = newClause.getAutoNumberPropertyInfoList().isEmpty() ? null : newClause.getAutoNumberPropertyInfoList().get(0);

        Set<String> allNames = new HashSet<>();
        if (oldInfo != null) allNames.add(oldInfo.getName());
        if (newInfo != null) allNames.add(newInfo.getName());

        for (String name : allNames) {

            if (!oldInfo.getName().equalsIgnoreCase(name)) {
                diffs.add(new XMLDiffResult("SCHEDULE_CONFIG_XML", pattern, name, "null", newInfo.toString(), NEW, "AutoNumberPropertyInfo"));
            } else if (!newInfo.getName().equalsIgnoreCase(name)) {
                diffs.add(new XMLDiffResult("SCHEDULE_CONFIG_XML", pattern, name, oldInfo.toString(), "null", REMOVED, "AutoNumberPropertyInfo"));
            } else {
                diffs.addAll(ComparatorUtilities.compareObjectsRecursively(pattern, oldInfo, newInfo, "AutoNumberPropertyInfo", "SCHEDULE_CONFIG_XML", Arrays.asList("name")));
            }
        }
        return diffs;
    }

    /*private static List<XMLDiffResult> comparePropertyInfoLists(String pattern, ClauseType oldClause, ClauseType newClause) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();
        List<PropertyInfoType> oldList = oldClause.getPropertyInfoList();
        List<PropertyInfoType> newList = newClause.getPropertyInfoList();

        Map<String, PropertyInfoType> oldMap = oldList.stream().collect(Collectors.toMap(PropertyInfoType::getName, item -> item));
        Map<String, PropertyInfoType> newMap = newList.stream().collect(Collectors.toMap(PropertyInfoType::getName, item -> item));

        Set<String> allNames = new HashSet<>();
        allNames.addAll(oldMap.keySet());
        allNames.addAll(newMap.keySet());

        for (String name : allNames) {
            PropertyInfoType oldInfo = oldMap.get(name);
            PropertyInfoType newInfo = newMap.get(name);

            if (oldInfo == null) {
                diffs.add(new XMLDiffResult("SCHEDULE_CONFIG_XML", pattern, "PropertyInfo[" + name + "]", "null", newInfo.toString(), NEW, "PropertyInfo"));
            } else if (newInfo == null) {
                diffs.add(new XMLDiffResult("SCHEDULE_CONFIG_XML", pattern, "PropertyInfo[" + name + "]", oldInfo.toString(), "null", REMOVED, "PropertyInfo"));
            } else {
                diffs.addAll(comparePropertyInfoVersions(pattern, oldInfo, newInfo));
            }
        }
        return diffs;
    }

    private static List<XMLDiffResult> comparePropertyInfoVersions(String pattern, PropertyInfoType oldInfo, PropertyInfoType newInfo) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();
        List<PropertyInfoVersionType> oldVersions = oldInfo.getVersion();
        List<PropertyInfoVersionType> newVersions = newInfo.getVersion();

        List<String> uniqueKeys = Arrays.asList("jurisdiction", "effectiveDate");

        diffs.addAll(ComparatorUtilities.compareListsByUniqueKey(pattern, oldVersions, newVersions, "PropertyInfo[" + oldInfo.getName() + "].Version", "SCHEDULE_CONFIG_XML", uniqueKeys));
        return diffs;
    }*/
    private static List<XMLDiffResult> comparePropertyInfoLists(String pattern, ClauseType oldClause, ClauseType newClause) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();
        List<PropertyInfoType> oldList = oldClause.getPropertyInfoList();
        List<PropertyInfoType> newList = newClause.getPropertyInfoList();

        Map<String, PropertyInfoType> oldMap = oldList.stream().collect(Collectors.toMap(PropertyInfoType::getName, item -> item));
        Map<String, PropertyInfoType> newMap = newList.stream().collect(Collectors.toMap(PropertyInfoType::getName, item -> item));

        Set<String> allNames = new HashSet<>();
        allNames.addAll(oldMap.keySet());
        allNames.addAll(newMap.keySet());

        for (String name : allNames) {
            PropertyInfoType oldInfo = oldMap.get(name);
            PropertyInfoType newInfo = newMap.get(name);

            String propertyInfoPath = "Clause[" + pattern + "].PropertyInfo[" + name + "]";

            if (oldInfo == null) {
                diffs.add(new XMLDiffResult("SCHEDULE_CONFIG_XML", pattern, propertyInfoPath, "null", newInfo.toString(), NEW, "PropertyInfo"));
            } else if (newInfo == null) {
                diffs.add(new XMLDiffResult("SCHEDULE_CONFIG_XML", pattern, propertyInfoPath, oldInfo.toString(), "null", REMOVED, "PropertyInfo"));
            } else {
                diffs.addAll(comparePropertyInfoVersions(pattern, oldInfo, newInfo, propertyInfoPath));
            }
        }
        return diffs;
    }

    private static List<XMLDiffResult> comparePropertyInfoVersions(String pattern, PropertyInfoType oldInfo, PropertyInfoType newInfo, String propertyInfoPath) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();
        List<PropertyInfoVersionType> oldVersions = oldInfo.getVersion();
        List<PropertyInfoVersionType> newVersions = newInfo.getVersion();

        List<String> uniqueKeys = Arrays.asList("jurisdiction", "effectiveDate");

        // This will produce paths like Clause[W1].PropertyInfo[ABCD].Version[MA2023-07-01]
        diffs.addAll(ComparatorUtilities.compareListsByUniqueKey(
                pattern,
                oldVersions,
                newVersions,
                propertyInfoPath + ".Version",
                "SCHEDULE_CONFIG_XML",
                uniqueKeys
        ));
        return diffs;
    }
}
