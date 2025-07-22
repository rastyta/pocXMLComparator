package com.gw.xmlcompare;

import com.gw.xmlcompare.loader.XmlLoaderJaxb;
import com.gw.xmlcompare.model.XMLDiffResult;
import com.gw.xmlcompare.model.formpatterns.FormPattern;
import com.gw.xmlcompare.model.formpatterns.FormPatterns;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class FormPatternComparator {
    public static void main(String[] args) throws Exception {

        List<XMLDiffResult> results = new ArrayList<>();
        FormPatterns xml1 = XmlLoaderJaxb.loadXml(new File("src/main/resources/demo1.xml"), FormPatterns.class);
        FormPatterns xml2 = XmlLoaderJaxb.loadXml(new File("src/main/resources/demo2.xml"), FormPatterns.class);

        Map<String, FormPattern> oldMap = toCodeMap(xml1.getFormPattern());
        Map<String, FormPattern> newMap = toCodeMap(xml2.getFormPattern());

        Set<String> allCodes = new HashSet<>();
        allCodes.addAll(oldMap.keySet());
        allCodes.addAll(newMap.keySet());

        for (String code : allCodes) {
            FormPattern oldFP = oldMap.get(code);
            FormPattern newFP = newMap.get(code);

            if (oldFP == null) {
                //create method and return diff from there
                results.add(new XMLDiffResult("FormPattern XML", code, "", "N/A", "N/A", "New FORM","New FormPattern XML"));
            } else if (newFP == null) {
                results.add(new XMLDiffResult("FormPattern XML", code, "", "N/A", "N/A", "Removed Form", "Removed FormPattern"));
            } else {
                List<XMLDiffResult> diffs =  (compare(code, oldFP, newFP));
                results.addAll(diffs);
            }
        }
    }

    private static Map<String, FormPattern> toCodeMap(List<FormPattern> list) {
        Map<String, FormPattern> map = new HashMap<>();
        for (FormPattern fp : list) {
            if (fp.getCode() != null) {
                map.put(fp.getCode(), fp);
            }
        }
        return map;
    }

    /*private static List<XMLDiffResult> compareFields(String code, FormPattern oldFP, FormPattern newFP) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();
        for (Field field : FormPattern.class.getDeclaredFields()) {
            field.setAccessible(true);
            Object oldVal = field.get(oldFP);
            Object newVal = field.get(newFP);
            if (!Objects.equals(oldVal, newVal)) {
                diffs.add(new XMLDiffResult("Forms Pattern XML",code, field.getName(),
                        oldVal != null ? oldVal.toString() : "null",
                        newVal != null ? newVal.toString() : "null",
                        "Changed", "Attribute"));
            }
        }
        return diffs;
    }*/

    /*private static List<XMLDiffResult> compareFields(String code, Object oldObj, Object newObj) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();
        if (oldObj == null && newObj == null) return diffs;
        if (oldObj == null || newObj == null || !oldObj.getClass().equals(newObj.getClass())) {
            diffs.add(new XMLDiffResult("Forms Pattern XML", code, "Object",
                    oldObj != null ? oldObj.toString() : "null",
                    newObj != null ? newObj.toString() : "null",
                    "Changed", "Object"));
            return diffs;
        }
        for (Field field : oldObj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object oldVal = field.get(oldObj);
            Object newVal = field.get(newObj);
            if (isSimpleType(field.getType())) {
                if (!Objects.equals(oldVal, newVal)) {
                    diffs.add(new XMLDiffResult("Forms Pattern XML", code, field.getName(),
                            oldVal != null ? oldVal.toString() : "null",
                            newVal != null ? newVal.toString() : "null",
                            "Changed", "Attribute"));
                }
            } else {
                // Nested objects — comparing recursively
                diffs.addAll(compareFields(code + "." + field.getName(), oldVal, newVal));
            }
        }
        return diffs;
    }
    private static boolean isSimpleType(Class<?> type) {
        return type.isPrimitive()
                || type == String.class
                || Number.class.isAssignableFrom(type)
                || type == Boolean.class
                || type.isEnum();
    }*/

    public static List<XMLDiffResult> compare(String code, FormPattern oldFP, FormPattern newFP) throws IllegalAccessException {
        return compareObjectsRecursively(code, oldFP, newFP, "FormPattern");
    }
    private static List<XMLDiffResult> compareObjectsRecursively(String code, Object oldObj, Object newObj, String path) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();

        //when code is available but not the entire formPatternProduct
        if (oldObj == null && newObj == null) return diffs;

        //when 2 forms are of different types and when extra child element is added
        if (oldObj == null || newObj == null || !oldObj.getClass().equals(newObj.getClass())) {
            diffs.add(new XMLDiffResult("FormPattern XML",code, path,
                    oldObj != null ? oldObj.toString() : "null",
                    newObj != null ? newObj.toString() : "null",
                    "New", "Object"));
            return diffs;
        }
        for (Field field : oldObj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object oldVal = field.get(oldObj);
            Object newVal = field.get(newObj);
            String fullPath = path + "." + field.getName();
            if (isSimpleType(field.getType())) {
                if (!Objects.equals(oldVal, newVal)) {
                    diffs.add(new XMLDiffResult("FormPattern XML", code, fullPath,
                            oldVal != null ? oldVal.toString() : "null",
                            newVal != null ? newVal.toString() : "null",
                            "Changed", field.getName()));
                }
            } else if (List.class.isAssignableFrom(field.getType())) {
                diffs.addAll(compareLists(code, (List<?>) oldVal, (List<?>) newVal, fullPath));
            } else {
                diffs.addAll(compareObjectsRecursively(code, oldVal, newVal, fullPath));
            }
        }
        return diffs;
    }
    private static List<XMLDiffResult> compareLists(String code, List<?> oldList, List<?> newList, String path) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();
        int max = Math.max(
                oldList != null ? oldList.size() : 0,
                newList != null ? newList.size() : 0
        );
        for (int i = 0; i < max; i++) {
            Object oldItem = (oldList != null && i < oldList.size()) ? oldList.get(i) : null;
            Object newItem = (newList != null && i < newList.size()) ? newList.get(i) : null;
            String itemPath = path + "[" + i + "]";
            if (isSimpleType((oldItem != null ? oldItem.getClass() : (newItem != null ? newItem.getClass() : Object.class)))) {
                if (!Objects.equals(oldItem, newItem)) {
                    diffs.add(new XMLDiffResult("FormPattern XML",code, itemPath,
                            oldItem != null ? oldItem.toString() : "null",
                            newItem != null ? newItem.toString() : "null",
                            "Changed", "List Item"));
                }
            } else {
                diffs.addAll(compareObjectsRecursively(code, oldItem, newItem, itemPath));
            }
        }
        return diffs;
    }
    private static boolean isSimpleType(Class<?> type) {
        return type.isPrimitive()
                || type.equals(String.class)
                || Number.class.isAssignableFrom(type)
                || Boolean.class.isAssignableFrom(type)
                || type.isEnum();
    }

}
