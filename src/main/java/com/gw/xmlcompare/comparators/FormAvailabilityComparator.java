package com.gw.xmlcompare.comparators;

import com.gw.xmlcompare.comparators.utils.ComparatorUtilities;
import com.gw.xmlcompare.loader.XmlLoaderJaxb;
import com.gw.xmlcompare.model.XMLDiffResult;
import com.gw.xmlcompare.model.formavailability.AvailabilityConfigType;
import com.gw.xmlcompare.model.formavailability.ContainerType;
import com.gw.xmlcompare.model.forminference.FormInferenceType;
import org.apache.commons.math3.util.Pair;
import org.apache.poi.ss.formula.functions.T;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

import static com.gw.xmlcompare.comparators.utils.ComparatorUtilities.makeFileChangesAndLoad;
import static com.gw.xmlcompare.comparators.utils.ComparatorUtilities.replaceRoot;
import static com.gw.xmlcompare.utils.ConstantUtils.*;

public class FormAvailabilityComparator {
    public static AvailabilityConfigType oldFormPatterns;
    public static AvailabilityConfigType newFormPatterns;
    public static List<XMLDiffResult> results = new ArrayList<>();
    public static final String NEW_ROOT = "AvailabilityConfig";


    public static List<XMLDiffResult> compareConatinerPatterns() throws Exception {

        //Make necessary changes to the XML files before mapping to Java objects
        //And mapping to Java Object


        Pair<AvailabilityConfigType, AvailabilityConfigType> pair = makeFileChangesAndLoad(NEW_ROOT, AvailabilityConfigType.class);
        oldFormPatterns= pair.getFirst();
        newFormPatterns = pair.getSecond();
        Map<String, ContainerType> oldMap = toCodeMap(oldFormPatterns.getContainer());
        Map<String, ContainerType> newMap = toCodeMap(newFormPatterns.getContainer());

        Set<String> allCodes = new HashSet<>();
        allCodes.addAll(oldMap.keySet());
        allCodes.addAll(newMap.keySet());

        for (String code : allCodes) {
            ContainerType oldFP = oldMap.get(code);
            ContainerType newFP = newMap.get(code);

            if (oldFP == null) {
                //create method and return diff from there
                results.add(new XMLDiffResult(AVAILABILITY_XML, code, "", "N/A", newFP.toString(), NEW, "New Availability XML"));
            } else if (newFP == null) {
                results.add(new XMLDiffResult(AVAILABILITY_XML, code, "", oldFP.toString(), "N/A", REMOVED, "Removed Availability XML"));
            } else {
                List<XMLDiffResult> diffs = compare(code, oldFP, newFP);
                results.addAll(diffs);
            }
        }
        return results;
    }

    /*private static void makeFileChangesAndLoad() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document oldDoc = builder.parse(new File(FORM_1_COMPARE));
        Document newDoc = builder.parse(new File(FORM_2_COMPARE));

        Document oldDocReplaced = replaceRoot(oldDoc, NEW_ROOT);
        Document newDocReplaced = replaceRoot(newDoc, NEW_ROOT);
        oldFormPatterns = XmlLoaderJaxb.loadXml(oldDocReplaced, AvailabilityConfigType.class);
        newFormPatterns = XmlLoaderJaxb.loadXml(newDocReplaced, AvailabilityConfigType.class);
    }*/

    private static Map<String, ContainerType> toCodeMap(List<ContainerType> containerTypes) {
        Map<String, ContainerType> map = new HashMap<>();
        for (ContainerType at : containerTypes) {
            if (at.getName()!= null) {
                map.put(at.getName(), at);
            }
        }
        return map;
    }

    public static List<XMLDiffResult> compare(String code, ContainerType oldFP, ContainerType newFP) throws IllegalAccessException {
        List<XMLDiffResult> diffs = ComparatorUtilities.compareObjectsRecursively(code, oldFP, newFP, CONTAINER, AVAILABILITY_XML);
        if(diffs.isEmpty()){
            diffs.add(new XMLDiffResult(AVAILABILITY_XML,code, null,
                    "-",
                    "-",
                    NO_CHANGE, AVAILABILITY_XML));
            return diffs;
        }
        return diffs;
    }

}
