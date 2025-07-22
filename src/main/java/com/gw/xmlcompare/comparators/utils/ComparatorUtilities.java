package com.gw.xmlcompare.comparators.utils;

import com.gw.xmlcompare.model.XMLDiffResult;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ComparatorUtilities {
    public static List<XMLDiffResult> compareObjectsRecursively(String code, Object oldObj, Object newObj, String path) throws IllegalAccessException {
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
