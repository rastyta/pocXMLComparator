package com.gw.xmlcompare.comparators;

import com.gw.xmlcompare.comparators.utils.ComparatorUtilities;
import com.gw.xmlcompare.loader.XmlLoaderJaxb;
import com.gw.xmlcompare.model.XMLDiffResult;
import com.gw.xmlcompare.model.formlobfieldmeta.ColumnType;
import com.gw.xmlcompare.model.formlobfieldmeta.EntityType;
import com.gw.xmlcompare.model.formlobfieldmeta.LobFieldMetaType;
import com.gw.xmlcompare.model.formlobfieldmeta.VersionType;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;

import static com.gw.xmlcompare.utils.ConstantUtils.*;

public class LobFieldMetaComparator {

    public static List<XMLDiffResult> results = new ArrayList<>();
    public static final String LOB_FIELD_META_ROOT = "LobFieldMeta";
    public static LobFieldMetaType oldLobFieldMeta;
    public static LobFieldMetaType newLobFieldMeta;

    public static List<XMLDiffResult> compare(String entityName, EntityType oldEntity, EntityType newEntity) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();

        // Compare Columns
        diffs.addAll(compareColumnLists(entityName, oldEntity, newEntity));

        if (diffs.isEmpty()) {
            diffs.add(new XMLDiffResult(LOB_FIELD_META_XML, entityName, null, "-", "-", NO_CHANGE, LOB_FIELD_META_XML));
        }
        return diffs;
    }

    /**
     * This method uniquely identifies duplicate entities and compares them
     * @return
     * @throws Exception
     */
    public static List<XMLDiffResult> compareLobFieldMetaPatterns() throws Exception {
        makeFileChangesAndLoad();

        // Step 1 to Detect duplicates in old and new
        List<XMLDiffResult> duplicateResults = new ArrayList<>();
        duplicateResults.addAll(findDuplicateEntityNames(oldLobFieldMeta.getEntity(), OLD));
        duplicateResults.addAll(findDuplicateEntityNames(newLobFieldMeta.getEntity(), NEW));

        if (!duplicateResults.isEmpty()) {
            results.addAll(duplicateResults);
            return results;
        }

        // Step 2: Proceed with standard comparison for unique entity names
        Map<String, EntityType> oldMap = toEntityNameMap(oldLobFieldMeta.getEntity());
        Map<String, EntityType> newMap = toEntityNameMap(newLobFieldMeta.getEntity());

        Set<String> allNames = new HashSet<>();
        allNames.addAll(oldMap.keySet());
        allNames.addAll(newMap.keySet());

        for (String name : allNames) {
            EntityType oldEntity = oldMap.get(name);
            EntityType newEntity = newMap.get(name);

            if (oldEntity == null) {
                results.add(new XMLDiffResult(LOB_FIELD_META_XML, name, "", "N/A", newEntity.toString(), NEW, NEW_ENTITY));
            } else if (newEntity == null) {
                results.add(new XMLDiffResult(LOB_FIELD_META_XML, name, "", oldEntity.toString(), "N/A", REMOVED, REMOVED_ENTITY));
            } else {
                results.addAll(compare(name, oldEntity, newEntity));
            }
        }
        return results;
    }

    /**
     * This method is used to find the duplicate entity names within LobFieldMeta
     * @param entities
     * @param xmlSource
     * @return
     */
    private static List<XMLDiffResult> findDuplicateEntityNames(List<EntityType> entities, String xmlSource) {
        Map<String, List<EntityType>> nameMap = new HashMap<>();
        for (EntityType entity : entities) {
            nameMap.computeIfAbsent(entity.getName(), k -> new ArrayList<>()).add(entity);
        }
        List<XMLDiffResult> duplicates = new ArrayList<>();
        for (Map.Entry<String, List<EntityType>> entry : nameMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                duplicates.add(new XMLDiffResult(
                        LOB_FIELD_META_XML,
                        entry.getKey(),
                        "Entity",
                        "Duplicate Entity name found in " + xmlSource + ": " + entry.getKey(),
                        "Human interference required",
                        CHANGED,
                        "Object"
                ));
            }
        }
        return duplicates;
    }

    /**
     *  This method is used to find duplicate column names
     * @param columns
     * @param entityName
     * @param xmlSource
     * @return
     */
    private static List<XMLDiffResult> findDuplicateColumnNames(List<ColumnType> columns, String entityName, String xmlSource) {
        Map<String, List<ColumnType>> nameMap = new HashMap<>();
        for (ColumnType column : columns) {
            nameMap.computeIfAbsent(column.getName(), k -> new ArrayList<>()).add(column);
        }
        List<XMLDiffResult> duplicates = new ArrayList<>();
        for (Map.Entry<String, List<ColumnType>> entry : nameMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                duplicates.add(new XMLDiffResult(
                        LOB_FIELD_META_XML,
                        entityName,
                        "Entity[" + entityName + "].Column[" + entry.getKey() + "]",
                        "Duplicate Column name found in " + xmlSource + ": " + entry.getKey(),
                        "Human interference required",
                        CHANGED,
                        "Object"
                ));
            }
        }
        return duplicates;
    }

    /**
     * This method is used to find duplicate VersionKeys
     * @param versions
     * @param entityName
     * @param columnName
     * @param xmlSource
     * @return
     */
    private static List<XMLDiffResult> findDuplicateVersionKeys(List<VersionType> versions, String entityName, String columnName, String xmlSource) {
        Map<String, List<VersionType>> keyMap = new HashMap<>();
        for (VersionType version : versions) {
            String key = (version.getJurisdiction() != null ? version.getJurisdiction() : "") +
                    (version.getEffectiveDate() != null ? version.getEffectiveDate() : "");
            keyMap.computeIfAbsent(key, k -> new ArrayList<>()).add(version);
        }
        List<XMLDiffResult> duplicates = new ArrayList<>();
        for (Map.Entry<String, List<VersionType>> entry : keyMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                duplicates.add(new XMLDiffResult(
                        LOB_FIELD_META_XML,
                        entityName,
                        "Entity[" + entityName + "].Column[" + columnName + "].Version[" + entry.getKey() + "]",
                        "Duplicate Version key found in " + xmlSource + ": " + entry.getKey(),
                        "Contact DEV : Human interference required",
                        CHANGED,
                        "Object"
                ));
            }
        }
        return duplicates;
    }


    /**
     * This method maps the EntityType with distinct name
     * @param entities
     * @return
     */
    private static Map<String, EntityType> toEntityNameMap(List<EntityType> entities) {
        Map<String, EntityType> map = new HashMap<>();
        for (EntityType entity : entities) {
            if (entity.getName() != null) {
                map.put(entity.getName(), entity);
            }
        }
        return map;
    }

    /**
     * This method maps the ColumnType with distinct name
     * @param columns
     * @return
     */
    private static Map<String, ColumnType> toColumnNameMap(List<ColumnType> columns) {
        Map<String, ColumnType> map = new HashMap<>();
        for (ColumnType column : columns) {
            if (column.getName() != null) {
                map.put(column.getName(), column);
            }
        }
        return map;
    }

    /**
     * This method is used to load the file into LobFieldMetaType object
     * @throws Exception
     */
    private static void makeFileChangesAndLoad() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document oldDoc = builder.parse(new File(FORM_1_COMPARE));
        Document newDoc = builder.parse(new File(FORM_2_COMPARE));

        oldLobFieldMeta = XmlLoaderJaxb.loadXml(oldDoc, LobFieldMetaType.class);
        newLobFieldMeta = XmlLoaderJaxb.loadXml(newDoc, LobFieldMetaType.class);
    }


    /**
     * This method is used to compare the distinct column from the incoming list
     * @param entityName
     * @param oldEntity
     * @param newEntity
     * @return
     * @throws IllegalAccessException
     */
    private static List<XMLDiffResult> compareColumnLists(String entityName, EntityType oldEntity, EntityType newEntity) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();
        List<ColumnType> oldList = oldEntity.getColumn();
        List<ColumnType> newList = newEntity.getColumn();

        // Duplicate detection for columns
        diffs.addAll(findDuplicateColumnNames(oldList, entityName, OLD));
        diffs.addAll(findDuplicateColumnNames(newList, entityName, NEW));

        // Only proceed if no duplicates
        if (!diffs.isEmpty()) return diffs;

        Map<String, ColumnType> oldMap = toColumnNameMap(oldList);
        Map<String, ColumnType> newMap = toColumnNameMap(newList);

        Set<String> allNames = new HashSet<>();
        allNames.addAll(oldMap.keySet());
        allNames.addAll(newMap.keySet());

        for (String name : allNames) {
            ColumnType oldColumn = oldMap.get(name);
            ColumnType newColumn = newMap.get(name);

            String columnPath = "Entity[" + entityName + "].Column[" + name + "]";

            if (oldColumn == null) {
                diffs.add(new XMLDiffResult(LOB_FIELD_META_XML, entityName, columnPath, "null", newColumn.toString(), NEW, "Object"));
            } else if (newColumn == null) {
                diffs.add(new XMLDiffResult(LOB_FIELD_META_XML, entityName, columnPath, oldColumn.toString(), "null", REMOVED, "Object"));
            } else {
                diffs.addAll(compareVersionLists(entityName, name, oldColumn, newColumn, columnPath));
            }
        }
        return diffs;
    }


    /**
     * This method is used to compare the distinct version inside Column
     * @param entityName
     * @param columnName
     * @param oldColumn
     * @param newColumn
     * @param columnPath
     * @return
     * @throws IllegalAccessException
     */
    private static List<XMLDiffResult> compareVersionLists(String entityName, String columnName, ColumnType oldColumn, ColumnType newColumn, String columnPath) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>();
        List<VersionType> oldList = oldColumn.getVersion();
        List<VersionType> newList = newColumn.getVersion();

        // Duplicate detection for versions
        diffs.addAll(findDuplicateVersionKeys(oldList, entityName, columnName, OLD));
        diffs.addAll(findDuplicateVersionKeys(newList, entityName, columnName, NEW));

        // Only proceeding if there are no duplicates
        if (!diffs.isEmpty()) return diffs;

        List<String> uniqueKeys = Arrays.asList("jurisdiction", "effectiveDate");

        // Hierarchical path
        String versionPath = columnPath + ".Version";
        diffs.addAll(ComparatorUtilities.compareListsByUniqueKey(
                entityName, oldList, newList, versionPath, LOB_FIELD_META_XML, uniqueKeys));
        return diffs;
    }
}
