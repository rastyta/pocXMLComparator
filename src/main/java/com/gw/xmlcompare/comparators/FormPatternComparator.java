package com.gw.xmlcompare.comparators;

import com.gw.xmlcompare.comparators.utils.ComparatorUtilities;
import com.gw.xmlcompare.loader.XmlLoaderJaxb;
import com.gw.xmlcompare.model.XMLDiffResult;
import com.gw.xmlcompare.model.formpatterns.FormPattern;
import com.gw.xmlcompare.model.formpatterns.FormPatterns;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

public class FormPatternComparator {

    public static final String OLD_XML = "src/main/resources/demo1.xml";
    public static final String NEW_XML = "src/main/resources/demo2.xml";
    public static final String NEW_ROOT = "FormPatterns";
    public static FormPatterns oldFormPatterns;
    public static FormPatterns newFormPatterns;

    public static List<XMLDiffResult> getResults() {
        return results;
    }

    public static List<XMLDiffResult> results = new ArrayList<>();

    public static List<XMLDiffResult> compareFormPatterns() throws Exception {
        //Make necessary changes to the XML files before mapping to Java objects
        //And mapping to Java Object
        makeFileChangesAndLoad();

        Map<String, FormPattern> oldMap = toCodeMap(oldFormPatterns.getFormPattern());
        Map<String, FormPattern> newMap = toCodeMap(newFormPatterns.getFormPattern());

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
                List<XMLDiffResult> diffs = compare(code, oldFP, newFP);
                results.addAll(diffs);
            }
        }
        return results;
    }

    public static List<XMLDiffResult> compare(String code, FormPattern oldFP, FormPattern newFP) throws IllegalAccessException {
        return ComparatorUtilities.compareObjectsRecursively(code, oldFP, newFP, "FormPattern");
    }

    private static void makeFileChangesAndLoad() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document oldDoc = builder.parse(new File(OLD_XML));
        Document newDoc = builder.parse(new File(NEW_XML));

        Document oldDocReplaced = replaceRoot(oldDoc);
        Document newDocReplaced = replaceRoot(newDoc);
        oldFormPatterns = XmlLoaderJaxb.loadXml(oldDocReplaced, FormPatterns.class);
        newFormPatterns = XmlLoaderJaxb.loadXml(newDocReplaced, FormPatterns.class);
    }

    private static Document replaceRoot(Document doc) {
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

    private static Map<String, FormPattern> toCodeMap(List<FormPattern> list) {
        Map<String, FormPattern> map = new HashMap<>();
        for (FormPattern fp : list) {
            if (fp.getCode() != null) {
                map.put(fp.getCode(), fp);
            }
        }
        return map;
    }
}
