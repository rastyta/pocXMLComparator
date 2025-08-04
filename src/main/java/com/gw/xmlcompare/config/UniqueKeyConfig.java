package com.gw.xmlcompare.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueKeyConfig {
    private static final Map<String, List<String>> uniqueKeyMap = new HashMap<>();

    static {
        // Define unique keys for different XML structures
        uniqueKeyMap.put("FormInferenceConfig", List.of("jurisdiction"));
        uniqueKeyMap.put("ScheduleConfig", List.of("pattern"));
        uniqueKeyMap.put("ClauseType", List.of("pattern"));
        uniqueKeyMap.put("AutoNumberPropertyInfoType", List.of("columnName"));
        uniqueKeyMap.put("PropertyInfoType", List.of("name"));
        uniqueKeyMap.put("PropertyInfoVersionType", List.of("columnName"));

        uniqueKeyMap.put("VersionType", List.of("jurisdiction", "effectiveDate"));
        uniqueKeyMap.put("FormPattern", List.of("code"));
        uniqueKeyMap.put("FormPatternLookup", List.of("jurisdiction", "startEffectiveDate"));



    }

    // Method to get unique keys for a given element name
    public static List<String> getUniqueKeys(String elementName) {
        return uniqueKeyMap.get(elementName);
    }
}