package com.gw.xmlcompare.model;

public class XMLDiffResult {
    public String xmlSource;
    public String uniqueKey;
    public String field;
    public String oldValue;
    public String newValue;
    public String changeType;
    public String category;
    public XMLDiffResult(String xmlSource, String uniqueKey, String field,
                         String oldValue, String newValue, String changeType, String category) {
        this.xmlSource = xmlSource;
        this.uniqueKey = uniqueKey;
        this.field = field;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.changeType = changeType;
        this.category = category;


    }

}
