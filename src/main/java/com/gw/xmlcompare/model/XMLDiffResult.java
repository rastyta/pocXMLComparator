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

    public String getXmlSource() {
        return xmlSource;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public String getField() {
        return field;
    }

    public String getOldValue() {
        return oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public String getChangeType() {
        return changeType;
    }

    public String getCategory() {
        return category;
    }
}
