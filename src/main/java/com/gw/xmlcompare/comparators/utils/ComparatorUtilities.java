package com.gw.xmlcompare.comparators.utils;

import com.gw.xmlcompare.model.XMLDiffResult;

import java.lang.reflect.Field;
import java.util.*;

import static com.gw.xmlcompare.utils.ConstantUtils.*;

public class ComparatorUtilities {

    public static List<XMLDiffResult> compareObjectsRecursively(String code, Object oldObj, Object newObj, String path, String xmlSource, List<String> uniqueKeys) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();

        if (oldObj == null && newObj == null) return diffs;

        if (oldObj == null || newObj == null || !oldObj.getClass().equals(newObj.getClass())) {
            if (oldObj == null) {
                diffs.add(new XMLDiffResult(xmlSource, code, path, "null", newObj != null ? newObj.toString() : "null", NEW, "Object"));
            } else {
                diffs.add(new XMLDiffResult(xmlSource, code, path, oldObj != null ? oldObj.toString() : "null", "null", REMOVED, "Object"));
            }
            return diffs;
        }

        for (Field field : oldObj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object oldVal = field.get(oldObj);
            Object newVal = field.get(newObj);
            String fullPath = path + "." + field.getName();
            if (isSimpleType(field.getType())) {
                if (!Objects.equals(oldVal, newVal)) {
                    diffs.add(new XMLDiffResult(xmlSource, code, fullPath, oldVal != null ? oldVal.toString() : "null", newVal != null ? newVal.toString() : "null", CHANGED, field.getName()));
                }
            } else if (List.class.isAssignableFrom(field.getType())) {
                diffs.addAll(compareLists(code, (List<?>) oldVal, (List<?>) newVal, fullPath, xmlSource, uniqueKeys));
            } else {
                diffs.addAll(compareObjectsRecursively(code, oldVal, newVal, fullPath, xmlSource, uniqueKeys));
            }
        }
        return diffs;
    }

    public static List<XMLDiffResult>
    compareLists(String code, List<?> oldList, List<?> newList, String path, String xmlSource, List<String> uniqueKeys) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();
        int max = Math.max(oldList != null ? oldList.size() : 0, newList != null ? newList.size() : 0);
        for (int i = 0; i < max; i++) {
            Object oldItem = (oldList != null && i < oldList.size()) ? oldList.get(i) : null;
            Object newItem = (newList != null && i < newList.size()) ? newList.get(i) : null;
            String itemPath = path + "[" + i + "]";
            if (isSimpleType((oldItem != null ? oldItem.getClass() : (newItem != null ? newItem.getClass() : Object.class)))) {
                if (!Objects.equals(oldItem, newItem)) {
                    if(oldItem == null && newItem != null ){
                        diffs.add(new XMLDiffResult(xmlSource, code, itemPath, oldItem != null ? oldItem.toString() : "null", newItem != null ? newItem.toString() : "null", NEW, "List Item"));
                    }else if(oldItem != null && newItem == null){
                        diffs.add(new XMLDiffResult(xmlSource, code, itemPath, oldItem != null ? oldItem.toString() : "null", newItem != null ? newItem.toString() : "null", REMOVED, "List Item"));
                    }else{
                        diffs.add(new XMLDiffResult(xmlSource, code, itemPath, oldItem != null ? oldItem.toString() : "null", newItem != null ? newItem.toString() : "null", CHANGED, "List Item"));
                    }
                }
            } else {
                diffs.addAll(compareObjectsRecursively(code, oldItem, newItem, itemPath, xmlSource, uniqueKeys));
            }
        }
        return diffs;
    }

    private static boolean isSimpleType(Class<?> type) {
        return type.isPrimitive() || type.equals(String.class) || Number.class.isAssignableFrom(type) || Boolean.class.isAssignableFrom(type) || type.isEnum();
    }

    public static List<XMLDiffResult> compareListsByUniqueKey(String code, List<?> oldList, List<?> newList, String path, String xmlSource, List<String> uniqueKeys) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();

        Map<String, List<Object>> oldMap = createUniqueKeyMap(oldList, uniqueKeys);
        Map<String, List<Object>> newMap = createUniqueKeyMap(newList, uniqueKeys);

        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(oldMap.keySet());
        allKeys.addAll(newMap.keySet());

        for (String key : allKeys) {
            List<Object> oldItems = oldMap.get(key);
            List<Object> newItems = newMap.get(key);

            if (oldItems != null && oldItems.size() > 1 || newItems != null && newItems.size() > 1) {
                diffs.add(new XMLDiffResult(xmlSource, code, path, "Duplicate keys found : " + key, "Contact DEV : Human interference required", CHANGED, "Object"));
                continue;
            }

            Object oldItem = oldItems != null && !oldItems.isEmpty() ? oldItems.get(0) : null;
            Object newItem = newItems != null && !newItems.isEmpty() ? newItems.get(0) : null;
            String itemPath = path + "[" + key + "]";

            if (oldItem == null) {
                diffs.add(new XMLDiffResult(xmlSource, code, itemPath, "null", newItem.toString(), NEW, "Object"));
            } else if (newItem == null) {
                diffs.add(new XMLDiffResult(xmlSource, code, itemPath, oldItem.toString(), "null", REMOVED, "Object"));
            } else if (!areObjectsEqual(oldItem, newItem)) {
                diffs.addAll(compareObjectsRecursively(code, oldItem, newItem, itemPath, xmlSource, uniqueKeys));
            }
        }

        return diffs;
    }

    private static Map<String, List<Object>> createUniqueKeyMap(List<?> list, List<String> uniqueKeys) {
        Map<String, List<Object>> map = new HashMap<>();
        for (Object item : list) {
            String key = generateUniqueKey(item, uniqueKeys);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(item);
        }
        return map;
    }

    public static String generateUniqueKey(Object obj, List<String> uniqueKeys) {
        StringBuilder keyBuilder = new StringBuilder();
        for (String key : uniqueKeys) {
            try {
                Field field = obj.getClass().getDeclaredField(key);
                field.setAccessible(true);
                Object value = field.get(obj);
                if (value != null) {
                    keyBuilder.append(value.toString());
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return keyBuilder.length() > 0 ? keyBuilder.toString() : "";
    }

    private static boolean areObjectsEqual(Object obj1, Object obj2) {
        if (obj1 == obj2) return true;
        if (obj1 == null || obj2 == null) return false;
        if (!obj1.getClass().equals(obj2.getClass())) return false;

        for (Field field : obj1.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value1 = field.get(obj1);
                Object value2 = field.get(obj2);
                if (value1 == null && value2 == null) continue;
                if (value1 == null || value2 == null) return false;
                if (!value1.equals(value2)) return false;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}