package com.gw.xmlcompare;

import com.gw.xmlcompare.comparators.FormInferenceComparator;
import com.gw.xmlcompare.comparators.FormPatternComparator;
import com.gw.xmlcompare.model.XMLDiffResult;
import com.gw.xmlcompare.model.XMLFileType;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.List;

public class RunComparator {
    public static final String FORM_PATTERN = "FormPattern";
    public static final String FORM_INFERENCE = "FormInference";

    public static void main(String[] args) throws Exception{
        initProcess();
    }

    private static List<XMLDiffResult> initProcess() throws Exception {
        List<XMLDiffResult> results = null;
        XMLFileType oldFileType = resolveXmlFileType("demo1.xml");
        XMLFileType newFileType = resolveXmlFileType("demo2.xml");
        if(newFileType == null || oldFileType != newFileType){
            throw new IllegalArgumentException("Different XML file types: " + oldFileType+"/"+newFileType);
        }
        if(oldFileType == XMLFileType.Form_Patterns){
            results = FormPatternComparator.compareFormPatterns();
        }else if(oldFileType == XMLFileType.Form_Inference){
            //TODO: Add logic
            results = FormInferenceComparator.compare();
        }
        //todo: Export result to a excel sheet
        return results;
    }

    private static XMLFileType resolveXmlFileType(String resourcePath) throws Exception {
        InputStream is = RunComparator.class.getClassLoader().getResourceAsStream(resourcePath);
        if (is == null) {
            throw new IllegalArgumentException("Not XML file found " + resourcePath);
        }
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(is);

        Element root = doc.getDocumentElement();

        return findTypeRecursive(root);
    }
    private static XMLFileType findTypeRecursive(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            String nodeName = node.getNodeName();
            // Find XML type
            switch (nodeName) {
                case FORM_PATTERN:
                    return XMLFileType.Form_Patterns;
                case FORM_INFERENCE:
                    return XMLFileType.Form_Inference;
            }
        }
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            XMLFileType type = findTypeRecursive(children.item(i));
            if (type != null) {
                return type;
            }
        }
        return null;
    }
}
