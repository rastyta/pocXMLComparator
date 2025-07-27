package com.gw.xmlcompare.comparators;

import com.gw.xmlcompare.comparators.utils.ComparatorUtilities;
import com.gw.xmlcompare.loader.XmlLoaderJaxb;
import com.gw.xmlcompare.model.XMLDiffResult;
import com.gw.xmlcompare.model.formpatterns.FormPattern;
import com.gw.xmlcompare.model.formpatterns.FormPatterns;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

import static com.gw.xmlcompare.comparators.utils.ComparatorUtilities.replaceRoot;
import static com.gw.xmlcompare.utils.ConstantUtils.*;

public class FormPatternComparator {


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
                results.add(new XMLDiffResult(FORMS_PATTERNS_XML, code, "", "N/A", "N/A", NEW,"New FormPattern XML"));
            } else if (newFP == null) {
                results.add(new XMLDiffResult(FORMS_PATTERNS_XML, code, "", "N/A", "N/A", REMOVED, "Removed FormPattern XML"));
            } else {
                List<XMLDiffResult> diffs = compare(code, oldFP, newFP);
                results.addAll(diffs);
            }
        }
        return results;
    }

    public static List<XMLDiffResult> compare(String code, FormPattern oldFP, FormPattern newFP) throws IllegalAccessException {
        List<XMLDiffResult> diffs = ComparatorUtilities.compareObjectsRecursively(code, oldFP, newFP, FORM_PATTERN, FORMS_PATTERNS_XML);
        if(diffs.isEmpty()){
            diffs.add(new XMLDiffResult(FORMS_PATTERNS_XML,code, null,
                    "-",
                    "-",
                    NO_CHANGE, FORMS_PATTERNS_XML));
            return diffs;
        }
        return diffs;
    }

    private static void makeFileChangesAndLoad() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document oldDoc = builder.parse(new File(FORM_1_COMPARE));
        Document newDoc = builder.parse(new File(FORM_2_COMPARE));

        Document oldDocReplaced = replaceRoot(oldDoc, FORM_PATTERNS_ROOT);
        Document newDocReplaced = replaceRoot(newDoc, FORM_PATTERNS_ROOT);
        oldFormPatterns = XmlLoaderJaxb.loadXml(oldDocReplaced, FormPatterns.class);
        newFormPatterns = XmlLoaderJaxb.loadXml(newDocReplaced, FormPatterns.class);
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
