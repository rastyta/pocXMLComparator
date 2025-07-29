
package com.gw.xmlcompare.model.formschedule;

import javax.xml.bind.annotation.*;


/**
 * &lt;p&gt;Java class for BasePropertyInfoType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="BasePropertyInfoType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{}ColumnName" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}ColumnLabel" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}Required" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}Priority" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BasePropertyInfoType", propOrder = {
    "columnName",
    "columnLabel",
    "required",
    "priority"
})
@XmlSeeAlso({
    PropertyInfoVersionType.class,
    AutoNumberPropertyInfoType.class
})
public class BasePropertyInfoType {

    @XmlElement(name = "ColumnName")
    protected String columnName;
    @XmlElement(name = "ColumnLabel")
    protected String columnLabel;
    @XmlElement(name = "Required")
    protected Boolean required;
    @XmlElement(name = "Priority")
    protected Integer priority;

    /**
     * Gets the value of the columnName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * Sets the value of the columnName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumnName(String value) {
        this.columnName = value;
    }

    /**
     * Gets the value of the columnLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumnLabel() {
        return columnLabel;
    }

    /**
     * Sets the value of the columnLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumnLabel(String value) {
        this.columnLabel = value;
    }

    public Boolean getRequired() {
        return required;
    }

    /**
     * Gets the value of the required property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequired() {
        return required;
    }

    /**
     * Sets the value of the required property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequired(Boolean value) {
        this.required = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPriority(Integer value) {
        this.priority = value;
    }

}
