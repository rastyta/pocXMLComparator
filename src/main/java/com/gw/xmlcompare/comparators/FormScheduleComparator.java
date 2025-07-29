package com.gw.xmlcompare.comparators;

import com.gw.xmlcompare.loader.XmlLoaderJaxb;
import com.gw.xmlcompare.model.XMLDiffResult;
import com.gw.xmlcompare.model.formschedule.*;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

import static com.gw.xmlcompare.utils.ConstantUtils.*;

public class FormScheduleComparator {

    public static ScheduleConfigType oldFormPatterns;
    public static ScheduleConfigType newFormPatterns;
    public static List<XMLDiffResult> results = new ArrayList<>();

    public static List<XMLDiffResult> compare(String code, ClauseType oldFP, ClauseType newFP) throws Exception {
        List<XMLDiffResult> diffs = compareClauseType(code, oldFP, newFP);
        if(diffs.isEmpty()){
            diffs.add(new XMLDiffResult(SCHEDULE_CONFIG_XML,code, null,
                    "-",
                    "-",
                    NO_CHANGE, SCHEDULE_CONFIG_XML));
            return diffs;
        }
        return diffs;
    }

    public static List<XMLDiffResult> compareScheduleConfigPatterns() throws Exception {
        //Make necessary changes to the XML files before mapping to Java objects
        //And mapping to Java Object
        makeFileChangesAndLoad();

        Map<String, ClauseType> oldMap = toCodeMap(oldFormPatterns.getClause());
        Map<String, ClauseType> newMap = toCodeMap(newFormPatterns.getClause());

        Set<String> allCodes = new HashSet<>();
        allCodes.addAll(oldMap.keySet());
        allCodes.addAll(newMap.keySet());

        for (String code : allCodes) {
            ClauseType oldFP = oldMap.get(code);
            ClauseType newFP = newMap.get(code);

            if (oldFP == null) {
                //create method and return diff from there
                results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, "", "N/A", newFP.toString(), NEW,"New Schedule Config XML"));
            } else if (newFP == null) {
                results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, "", oldFP.toString(), "N/A", REMOVED, "Removed Schedule Config XML"));
            } else {
                results.addAll(compare(code, oldFP, newFP));
            }
        }
        return results;
    }

    private static void makeFileChangesAndLoad() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document oldDoc = builder.parse(new File(FORM_1_COMPARE));
        Document newDoc = builder.parse(new File(FORM_2_COMPARE));

        oldFormPatterns = XmlLoaderJaxb.loadXml(oldDoc, ScheduleConfigType.class);
        newFormPatterns = XmlLoaderJaxb.loadXml(newDoc, ScheduleConfigType.class);
    }

    private static Map<String, ClauseType> toCodeMap(List<ClauseType> formInference) {
        Map<String, ClauseType> map = new HashMap<>();
        for (ClauseType fp : formInference) {
            if (fp.getPattern()!= null) {
                map.put(fp.getPattern(), fp);
            }
        }
        return map;
    }


    private static List<XMLDiffResult> compareClauseType(String code, ClauseType oldClause, ClauseType newClause) throws IllegalAccessException {
        List<XMLDiffResult> results = new ArrayList<>();

        List<AutoNumberPropertyInfoType> oldAutoNumberList = new ArrayList<>();
        List<PropertyInfoType> oldPropertyList = new ArrayList<>();
        List<AutoNumberPropertyInfoType> newAutoNumberList = new ArrayList<>();
        List<PropertyInfoType> newPropertyList = new ArrayList<>();

        // Separate old and new lists into AutoNumberPropertyInfo and PropertyInfo lists
        for (Object obj : oldClause.getAutoNumberPropertyInfoOrPropertyInfo()) {
            if (obj instanceof AutoNumberPropertyInfoType) {
                oldAutoNumberList.add((AutoNumberPropertyInfoType) obj);
            } else if (obj instanceof PropertyInfoType) {
                oldPropertyList.add((PropertyInfoType) obj);
            }
        }

        for (Object obj : newClause.getAutoNumberPropertyInfoOrPropertyInfo()) {
            if (obj instanceof AutoNumberPropertyInfoType) {
                newAutoNumberList.add((AutoNumberPropertyInfoType) obj);
            } else if (obj instanceof PropertyInfoType) {
                newPropertyList.add((PropertyInfoType) obj);
            }
        }

        // Compare AutoNumberPropertyInfo lists
        int maxAutoNumberLength = Math.max(oldAutoNumberList.size(), newAutoNumberList.size());
        for (int i = 0; i < maxAutoNumberLength; i++) {
            AutoNumberPropertyInfoType oldAutoNumber = i < oldAutoNumberList.size() ? oldAutoNumberList.get(i) : null;
            AutoNumberPropertyInfoType newAutoNumber = i < newAutoNumberList.size() ? newAutoNumberList.get(i) : null;

            if (oldAutoNumber == null) {
                results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, "AutoNumberPropertyInfo[" + i + "]", "N/A", newAutoNumber.toString(), NEW, "New AutoNumberPropertyInfo"));
            } else if (newAutoNumber == null) {
                results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, "AutoNumberPropertyInfo[" + i + "]", oldAutoNumber.toString(), "N/A", REMOVED, "Removed AutoNumberPropertyInfo"));
            } else {
                results.addAll(compareAutoNumberPropertyInfoType(code, "AutoNumberPropertyInfo[" + i + "]", oldAutoNumber, newAutoNumber));
            }
        }

        // Compare PropertyInfo lists
        int maxPropertyLength = Math.max(oldPropertyList.size(), newPropertyList.size());
        for (int i = 0; i < maxPropertyLength; i++) {
            PropertyInfoType oldProperty = i < oldPropertyList.size() ? oldPropertyList.get(i) : null;
            PropertyInfoType newProperty = i < newPropertyList.size() ? newPropertyList.get(i) : null;

            if (oldProperty == null) {
                results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, "PropertyInfo[" + i + "]", "N/A", newProperty.toString(), NEW, "New PropertyInfo"));
            } else if (newProperty == null) {
                results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, "PropertyInfo[" + i + "]", oldProperty.toString(), "N/A", REMOVED, "Removed PropertyInfo"));
            } else {
                results.addAll(comparePropertyInfoType(code, "PropertyInfo[" + i + "]", oldProperty, newProperty));
            }
        }

        return results;
    }


    private static List<XMLDiffResult> compareAutoNumberPropertyInfoType(String code, String path, AutoNumberPropertyInfoType oldInfo, AutoNumberPropertyInfoType newInfo) {
        List<XMLDiffResult> results = new ArrayList<>();

        // Compare fields of AutoNumberPropertyInfoType and add differences to results
        if (!oldInfo.getColumnName().equals(newInfo.getColumnName())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".ColumnName", oldInfo.getColumnName(), newInfo.getColumnName(), CHANGED, "AutoNumberPropertyInfo"));
        }
        if (!oldInfo.getColumnLabel().equals(newInfo.getColumnLabel())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".ColumnLabel", oldInfo.getColumnLabel(), newInfo.getColumnLabel(), CHANGED, "AutoNumberPropertyInfo"));
        }
        if (!oldInfo.getRequired().equals(newInfo.getRequired())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".Required", String.valueOf(oldInfo.getRequired()), String.valueOf(newInfo.getRequired()), CHANGED, "AutoNumberPropertyInfo"));
        }
        if (!oldInfo.getPriority().equals(newInfo.getPriority())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".Priority", String.valueOf(oldInfo.getPriority()), String.valueOf(newInfo.getPriority()), CHANGED, "AutoNumberPropertyInfo"));
        }

        return results;
    }

    private static List<XMLDiffResult> comparePropertyInfoType(String code, String path, PropertyInfoType oldInfo, PropertyInfoType newInfo) throws IllegalAccessException {
        List<XMLDiffResult> results = new ArrayList<>();

        // Compare fields of PropertyInfoType and add differences to results
        if (!oldInfo.getName().equals(newInfo.getName())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".Name", oldInfo.getName(), newInfo.getName(), CHANGED, "PropertyInfo"));
        }

        List<PropertyInfoVersionType> oldVersions = oldInfo.getVersion();
        List<PropertyInfoVersionType> newVersions = newInfo.getVersion();

        int maxLength = Math.max(oldVersions.size(), newVersions.size());

        for (int i = 0; i < maxLength; i++) {
            PropertyInfoVersionType oldVersion = i < oldVersions.size() ? oldVersions.get(i) : null;
            PropertyInfoVersionType newVersion = i < newVersions.size() ? newVersions.get(i) : null;

            if (oldVersion == null) {
                results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".Version[" + i + "]", "N/A", newVersion.toString(), NEW, "New Version"));
            } else if (newVersion == null) {
                results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".Version[" + i + "]", oldVersion.toString(), "N/A", REMOVED, "Removed Version"));
            } else {
                results.addAll(comparePropertyInfoVersionType(code, path + ".Version[" + i + "]", oldVersion, newVersion));
            }
        }

        return results;
    }

    private static List<XMLDiffResult> comparePropertyInfoVersionType(String code, String path, PropertyInfoVersionType oldVersion, PropertyInfoVersionType newVersion) throws IllegalAccessException {
        List<XMLDiffResult> results = new ArrayList<>();

        // Compare fields of PropertyInfoVersionType and add differences to results

        if (!Objects.equals(oldVersion.getColumnName(), newVersion.getColumnName())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".ColumnName", oldVersion.getColumnName(), newVersion.getColumnName(), CHANGED, "PropertyInfoVersion"));
        }
        if (!Objects.equals(oldVersion.getColumnLabel(), newVersion.getColumnLabel())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".ColumnLabel", oldVersion.getColumnLabel(), newVersion.getColumnLabel(), CHANGED, "PropertyInfoVersion"));
        }
        if (!Objects.equals(oldVersion.getRequired(), newVersion.getRequired())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".Required", String.valueOf(oldVersion.getRequired()), String.valueOf(newVersion.getRequired()), CHANGED, "PropertyInfoVersion"));
        }
        if (!Objects.equals(oldVersion.getPriority(), newVersion.getPriority())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".Priority", String.valueOf(oldVersion.getPriority()), String.valueOf(newVersion.getPriority()), CHANGED, "PropertyInfoVersion"));
        }

        if (!oldVersion.getType().equals(newVersion.getType())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".Type", oldVersion.getType().toString(), newVersion.getType().toString(), CHANGED, "PropertyInfoVersion"));
        }
        if (!Objects.equals(oldVersion.getScheduledItemType(), newVersion.getScheduledItemType())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".ScheduledItemType", oldVersion.getScheduledItemType(), newVersion.getScheduledItemType(), CHANGED, "PropertyInfoVersion"));
        }
        if (!Objects.equals(oldVersion.getDefault(), newVersion.getDefault())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + "._default", oldVersion.getDefault(), newVersion.getDefault(), CHANGED, "PropertyInfoVersion"));
        }
        if (!Objects.equals(oldVersion.isIsKey(), newVersion.isIsKey())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".IsKey", String.valueOf(oldVersion.isIsKey()), String.valueOf(newVersion.isIsKey()), CHANGED, "PropertyInfoVersion"));
        }
        if (!Objects.equals(oldVersion.getMinimum(), newVersion.getMinimum())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".Minimum", String.valueOf(oldVersion.getMinimum()), String.valueOf(newVersion.getMinimum()), CHANGED, "PropertyInfoVersion"));
        }
        if (!Objects.equals(oldVersion.getMaximum(), newVersion.getMaximum())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".Maximum", String.valueOf(oldVersion.getMaximum()), String.valueOf(newVersion.getMaximum()), CHANGED, "PropertyInfoVersion"));
        }
        if (!Objects.equals(oldVersion.getMethodExpression(), newVersion.getMethodExpression())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".MethodExpression", oldVersion.getMethodExpression(), newVersion.getMethodExpression(), CHANGED, "PropertyInfoVersion"));
        }
        if (!Objects.equals(oldVersion.getTypeList(), newVersion.getTypeList())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".TypeList", oldVersion.getTypeList(), newVersion.getTypeList(), CHANGED, "PropertyInfoVersion"));
        }
        if (!Objects.equals(oldVersion.getTypeFilter(), newVersion.getTypeFilter())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".TypeFilter", oldVersion.getTypeFilter(), newVersion.getTypeFilter(), CHANGED, "PropertyInfoVersion"));
        }
        if (!Objects.equals(oldVersion.getValueRangeGetter(), newVersion.getValueRangeGetter())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".ValueRangeGetter", oldVersion.getValueRangeGetter(), newVersion.getValueRangeGetter(), CHANGED, "PropertyInfoVersion"));
        }
        if (!Objects.equals(oldVersion.getOptionGroupLabelMethodExpression(), newVersion.getOptionGroupLabelMethodExpression())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".OptionGroupLabelMethodExpression", oldVersion.getOptionGroupLabelMethodExpression(), newVersion.getOptionGroupLabelMethodExpression(), CHANGED, "PropertyInfoVersion"));
        }
        if (!Objects.equals(oldVersion.getOptionLabelMethodExpression(), newVersion.getOptionLabelMethodExpression())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".OptionLabelMethodExpression", oldVersion.getOptionLabelMethodExpression(), newVersion.getOptionLabelMethodExpression(), CHANGED, "PropertyInfoVersion"));
        }
        if (!Objects.equals(oldVersion.getJurisdiction(), newVersion.getJurisdiction())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".Jurisdiction", oldVersion.getJurisdiction(), newVersion.getJurisdiction(), CHANGED, "PropertyInfoVersion"));
        }
        if (!Objects.equals(oldVersion.getEffectiveDate(), newVersion.getEffectiveDate())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".EffectiveDate", oldVersion.getEffectiveDate(), newVersion.getEffectiveDate(), CHANGED, "PropertyInfoVersion"));
        }
        if (!Objects.equals(oldVersion.getExpirationDate(), newVersion.getExpirationDate())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".ExpirationDate", oldVersion.getExpirationDate(), newVersion.getExpirationDate(), CHANGED, "PropertyInfoVersion"));
        }
        if (!Objects.equals(oldVersion.isAvailable(), newVersion.isAvailable())) {
            results.add(new XMLDiffResult(SCHEDULE_CONFIG_XML, code, path + ".Available", String.valueOf(oldVersion.isAvailable()), String.valueOf(newVersion.isAvailable()), CHANGED, "PropertyInfoVersion"));
        }

        return results;
    }



}




