package com.gw.xmlcompare.comparators.utils;

import com.gw.xmlcompare.loader.XmlLoaderJaxb;
import com.gw.xmlcompare.model.XMLDiffResult;
import com.gw.xmlcompare.model.formavailability.AvailabilityConfigType;
import com.gw.xmlcompare.model.formschedule.PropertyInfoType;
import com.gw.xmlcompare.model.formschedule.PropertyInfoVersionType;
import org.apache.commons.math3.util.Pair;
import org.apache.poi.ss.formula.functions.T;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Field;
import java.util.*;

import static com.gw.xmlcompare.utils.ConstantUtils.*;

public class ComparatorUtilities {

    public static List<XMLDiffResult> compareObjectsRecursively(String code, Object oldObj, Object newObj, String path, String xmlSource) throws IllegalAccessException {
        List<XMLDiffResult> diffs = new ArrayList<>() ;

        //when code is available but not the entire formPatternProduct
        if (oldObj == null && newObj == null) return diffs;

        //when 2 forms are of different types and when extra child element is added
        //optimise this code to handle inner added and removed elements
        if (oldObj == null || newObj == null || !oldObj.getClass().equals(newObj.getClass())) {
            if(oldObj == null ){
                diffs.add(new XMLDiffResult(xmlSource,code, path,
                        oldObj != null ? oldObj.toString() : "null",
                        newObj != null ? newObj.toString() : "null",
                        NEW, "Object"));
            } else if(newObj == null){
                diffs.add(new XMLDiffResult(xmlSource,code, path,
                        oldObj != null ? oldObj.toString() : "null",
                        newObj != null ? newObj.toString() : "null",
                        REMOVED, "Object"));
            }
            return diffs;
        }

        //looping through every field in object using reflection
        for (Field field : oldObj.getClass().getDeclaredFields()) {
            //to access private fields
            field.setAccessible(true);
            if(PUBLIC_ID.equalsIgnoreCase(field.getName())) continue;
            Object oldVal = field.get(oldObj);
            Object newVal = field.get(newObj);
            String fullPath = path + "." + field.getName();
            if (isSimpleType(field.getType())) {
                if (!Objects.equals(oldVal, newVal)) {
                    diffs.add(new XMLDiffResult(xmlSource, code, fullPath,
                            oldVal != null ? oldVal.toString() : "null",
                            newVal != null ? newVal.toString() : "null",
                            CHANGED, field.getName()));
                }
            } else if (List.class.isAssignableFrom(field.getType())) { //formpatternjobs
                diffs.addAll(compareLists(code, (List<?>) oldVal, (List<?>) newVal, fullPath, xmlSource));
            } else {
                diffs.addAll(compareObjectsRecursively(code, oldVal, newVal, fullPath, xmlSource));
            }
        }
        return diffs;
    }

    private static List<XMLDiffResult> compareLists(String code, List<?> oldList, List<?> newList, String path, String xmlSource) throws IllegalAccessException {
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
                    diffs.add(new XMLDiffResult(xmlSource,code, itemPath,
                            oldItem != null ? oldItem.toString() : "null",
                            newItem != null ? newItem.toString() : "null",
                            CHANGED, "List Item"));
                }
            } else {
                diffs.addAll(compareObjectsRecursively(code, oldItem, newItem, itemPath, xmlSource));
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

    public static <T> Pair<T,T> makeFileChangesAndLoad(String NEW_ROOT, Class<T> className) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document oldDoc = builder.parse(new File(FORM_1_COMPARE));
        Document newDoc = builder.parse(new File(FORM_2_COMPARE));

        Document oldDocReplaced = replaceRoot(oldDoc, NEW_ROOT);
        Document newDocReplaced = replaceRoot(newDoc, NEW_ROOT);
        T oldFormPatterns = XmlLoaderJaxb.loadXml(oldDocReplaced, className);
        T newFormPatterns = XmlLoaderJaxb.loadXml(newDocReplaced, className);

        return Pair.create(oldFormPatterns, newFormPatterns);
    }

    public static Document replaceRoot(Document doc, String NEW_ROOT) {
        Element oldRoot = doc.getDocumentElement();
        // new root
        Element newRoot = doc.createElement(NEW_ROOT);

        //Move all children to new root
        while (oldRoot.hasChildNodes()) {
            Node child = oldRoot.getFirstChild();
            oldRoot.removeChild(child);
            newRoot.appendChild(child);
        }

        // Replace the new root in the Document
        doc.removeChild(oldRoot);
        doc.appendChild(newRoot);
        return doc;
    }




}
