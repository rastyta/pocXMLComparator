
package com.gw.xmlcompare.model.formschedule;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ItemClauseType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ItemClauseType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;attribute ref="{}pattern use="required""/&amp;gt;
 *       &amp;lt;attribute ref="{}amendmentOf"/&amp;gt;
 *       &amp;lt;attribute ref="{}whenClause"/&amp;gt;
 *       &amp;lt;attribute ref="{}hideFromSummary"/&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemClauseType")
public class ItemClauseType {

    @XmlAttribute(name = "pattern", required = true)
    protected String pattern;
    @XmlAttribute(name = "amendmentOf")
    protected String amendmentOf;
    @XmlAttribute(name = "whenClause")
    protected String whenClause;
    @XmlAttribute(name = "hideFromSummary")
    protected Boolean hideFromSummary;

    /**
     * Gets the value of the pattern property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * Sets the value of the pattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPattern(String value) {
        this.pattern = value;
    }

    /**
     * Gets the value of the amendmentOf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmendmentOf() {
        return amendmentOf;
    }

    /**
     * Sets the value of the amendmentOf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmendmentOf(String value) {
        this.amendmentOf = value;
    }

    /**
     * Gets the value of the whenClause property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWhenClause() {
        return whenClause;
    }

    /**
     * Sets the value of the whenClause property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWhenClause(String value) {
        this.whenClause = value;
    }

    /**
     * Gets the value of the hideFromSummary property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHideFromSummary() {
        return hideFromSummary;
    }

    /**
     * Sets the value of the hideFromSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHideFromSummary(Boolean value) {
        this.hideFromSummary = value;
    }

}
