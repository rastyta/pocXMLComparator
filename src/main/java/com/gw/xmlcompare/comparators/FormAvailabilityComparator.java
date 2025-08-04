package com.gw.xmlcompare.comparators;

import com.gw.xmlcompare.comparators.utils.ComparatorUtilities;
import com.gw.xmlcompare.loader.XmlLoaderJaxb;
import com.gw.xmlcompare.model.XMLDiffResult;
import com.gw.xmlcompare.model.formavailability.*;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

import static com.gw.xmlcompare.utils.ConstantUtils.*;

public class FormAvailabilityComparator {

    public static List<XMLDiffResult> results = new ArrayList<>();
    public static final String AVAILABILITY_CONFIG_ROOT = "AvailabilityConfig";
    public static AvailabilityConfigType oldAvailabilityConfig;
    public static AvailabilityConfigType newAvailabilityConfig;

    public static List<XMLDiffResult> compare(String code, ContainerType oldConfig, ContainerType newConfig) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();

        // Compare Version lists
        List<XMLDiffResult> versionDiffs = compareVersionLists(code, oldConfig, newConfig);
        diffs.addAll(versionDiffs);

        // If no diffs found, add a no-change result
        if (diffs.isEmpty()) {
            diffs.add(new XMLDiffResult("AVAILABILITY_CONFIG_XML", code, null, "-", "-", NO_CHANGE, "AVAILABILITY_CONFIG_XML"));
        }
        return diffs;
    }

    /*public static List<XMLDiffResult> compareAvailabilityConfigPatterns() throws Exception {
        // Make necessary changes to the XML files before mapping to Java objects
        makeFileChangesAndLoad();

        Map<String, ContainerType> oldMap = toNameMap(oldAvailabilityConfig.getContainer());
        Map<String, ContainerType> newMap = toNameMap(newAvailabilityConfig.getContainer());

        Set<String> allNames = new HashSet<>();
        allNames.addAll(oldMap.keySet());
        allNames.addAll(newMap.keySet());

        for (String name : allNames) {
            ContainerType oldContainer = oldMap.get(name);
            ContainerType newContainer = newMap.get(name);

            if (oldContainer == null) {
                results.add(new XMLDiffResult("AVAILABILITY_CONFIG_XML", name, "", "N/A", newContainer.toString(), NEW, "New Availability Config XML"));
            } else if (newContainer == null) {
                results.add(new XMLDiffResult("AVAILABILITY_CONFIG_XML", name, "", oldContainer.toString(), "N/A", REMOVED, "Removed Availability Config XML"));
            } else {
                List<XMLDiffResult> diffs = compare(name, oldContainer, newContainer);
                results.addAll(diffs);
            }
        }
        return results;
    }*/

    public static List<XMLDiffResult> compareAvailabilityConfigPatterns() throws Exception {
        makeFileChangesAndLoad();

        // Step 1: Detect duplicates in old and new
        List<XMLDiffResult> duplicateResults = new ArrayList<>();
        duplicateResults.addAll(findDuplicateNames(oldAvailabilityConfig.getContainer(), "old"));
        duplicateResults.addAll(findDuplicateNames(newAvailabilityConfig.getContainer(), "new"));

        if (!duplicateResults.isEmpty()) {
            results.addAll(duplicateResults);
            return results;
        }

        // Step 2: Proceed with standard comparison for unique names
        Map<String, ContainerType> oldMap = toNameMap(oldAvailabilityConfig.getContainer());
        Map<String, ContainerType> newMap = toNameMap(newAvailabilityConfig.getContainer());

        Set<String> allNames = new HashSet<>();
        allNames.addAll(oldMap.keySet());
        allNames.addAll(newMap.keySet());

        for (String name : allNames) {
            ContainerType oldContainer = oldMap.get(name);
            ContainerType newContainer = newMap.get(name);

            if (oldContainer == null) {
                results.add(new XMLDiffResult("AVAILABILITY_CONFIG_XML", name, "", "N/A", newContainer.toString(), NEW, "New Availability Config XML"));
            } else if (newContainer == null) {
                results.add(new XMLDiffResult("AVAILABILITY_CONFIG_XML", name, "", oldContainer.toString(), "N/A", REMOVED, "Removed Availability Config XML"));
            } else {
                // Compare all fields of Container, including nested elements
                results.addAll(compare(name, oldContainer, newContainer));
            }
        }
        return results;
    }

    private static List<XMLDiffResult> findDuplicateNames(List<ContainerType> containers, String xmlSource) {
        Map<String, List<ContainerType>> nameMap = new HashMap<>();
        for (ContainerType container : containers) {
            nameMap.computeIfAbsent(container.getName(), k -> new ArrayList<>()).add(container);
        }
        List<XMLDiffResult> duplicates = new ArrayList<>();
        for (Map.Entry<String, List<ContainerType>> entry : nameMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                duplicates.add(new XMLDiffResult(
                        "AVAILABILITY_CONFIG_XML",
                        entry.getKey(),
                        "Container",
                        "Duplicate name found in " + xmlSource + ": " + entry.getKey(),
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

        oldAvailabilityConfig = XmlLoaderJaxb.loadXml(oldDoc, AvailabilityConfigType.class);
        newAvailabilityConfig = XmlLoaderJaxb.loadXml(newDoc, AvailabilityConfigType.class);
    }

    private static Map<String, ContainerType> toNameMap(List<ContainerType> containers) {
        Map<String, ContainerType> map = new HashMap<>();
        for (ContainerType container : containers) {
            if (container.getName() != null) {
                map.put(container.getName(), container);
            }
        }
        return map;
    }


    //Version[NY2011-11-01].depends[1]
   private static List<XMLDiffResult> compareVersionLists(String name, ContainerType oldContainer, ContainerType newContainer) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();
        List<VersionType> oldList = oldContainer.getVersion();
        List<VersionType> newList = newContainer.getVersion();

        List<String> uniqueKeys = Arrays.asList("jurisdiction", "effectiveDate");

        diffs.addAll(ComparatorUtilities.compareListsByUniqueKey(name, oldList, newList, "Version", "AVAILABILITY_CONFIG_XML", uniqueKeys));
        return diffs;
    }

}
