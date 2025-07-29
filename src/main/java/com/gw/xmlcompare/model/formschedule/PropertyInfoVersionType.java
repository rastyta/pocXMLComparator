
package com.gw.xmlcompare.model.formschedule;

import javax.xml.bind.annotation.*;


/**
 * &lt;p&gt;Java class for PropertyInfoVersionType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PropertyInfoVersionType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{}BasePropertyInfoType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{}Type"/&amp;gt;
 *         &amp;lt;element ref="{}ScheduledItemType" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}Default" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}IsKey" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}Minimum" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}Maximum" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}MethodExpression" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}TypeList" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}TypeFilter" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}ValueRangeGetter" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}OptionGroupLabelMethodExpression" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}OptionLabelMethodExpression" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}Jurisdiction" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}EffectiveDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}ExpirationDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}Available" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyInfoVersionType", propOrder = {
    "type",
    "scheduledItemType",
    "_default",
    "isKey",
    "minimum",
    "maximum",
    "methodExpression",
    "typeList",
    "typeFilter",
    "valueRangeGetter",
    "optionGroupLabelMethodExpression",
    "optionLabelMethodExpression",
    "jurisdiction",
    "effectiveDate",
    "expirationDate",
    "available"
})
public class PropertyInfoVersionType
    extends BasePropertyInfoType
{

    @XmlElement(name = "Type", required = true)
    @XmlSchemaType(name = "string")
    protected PropertyInfoEnum type;
    @XmlElement(name = "ScheduledItemType")
    protected String scheduledItemType;
    @XmlElement(name = "Default")
    protected String _default;
    @XmlElement(name = "IsKey")
    protected Boolean isKey;
    @XmlElement(name = "Minimum")
    protected Integer minimum;
    @XmlElement(name = "Maximum")
    protected Integer maximum;
    @XmlElement(name = "MethodExpression")
    protected String methodExpression;
    @XmlElement(name = "TypeList")
    protected String typeList;
    @XmlElement(name = "TypeFilter")
    protected String typeFilter;
    @XmlElement(name = "ValueRangeGetter")
    protected String valueRangeGetter;
    @XmlElement(name = "OptionGroupLabelMethodExpression")
    protected String optionGroupLabelMethodExpression;
    @XmlElement(name = "OptionLabelMethodExpression")
    protected String optionLabelMethodExpression;
    @XmlElement(name = "Jurisdiction")
    protected String jurisdiction;
    @XmlElement(name = "EffectiveDate")
    protected String effectiveDate;
    @XmlElement(name = "ExpirationDate")
    protected String expirationDate;
    @XmlElement(name = "Available")
    protected Boolean available;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyInfoEnum }
     *     
     */
    public PropertyInfoEnum getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyInfoEnum }
     *     
     */
    public void setType(PropertyInfoEnum value) {
        this.type = value;
    }

    /**
     * Gets the value of the scheduledItemType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheduledItemType() {
        return scheduledItemType;
    }

    /**
     * Sets the value of the scheduledItemType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduledItemType(String value) {
        this.scheduledItemType = value;
    }

    /**
     * Gets the value of the default property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefault() {
        return _default;
    }

    /**
     * Sets the value of the default property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefault(String value) {
        this._default = value;
    }

    /**
     * Gets the value of the isKey property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsKey() {
        return isKey;
    }

    /**
     * Sets the value of the isKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsKey(Boolean value) {
        this.isKey = value;
    }

    /**
     * Gets the value of the minimum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinimum() {
        return minimum;
    }

    /**
     * Sets the value of the minimum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinimum(Integer value) {
        this.minimum = value;
    }

    /**
     * Gets the value of the maximum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaximum() {
        return maximum;
    }

    /**
     * Sets the value of the maximum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaximum(Integer value) {
        this.maximum = value;
    }

    /**
     * Gets the value of the methodExpression property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMethodExpression() {
        return methodExpression;
    }

    /**
     * Sets the value of the methodExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMethodExpression(String value) {
        this.methodExpression = value;
    }

    /**
     * Gets the value of the typeList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeList() {
        return typeList;
    }

    /**
     * Sets the value of the typeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeList(String value) {
        this.typeList = value;
    }

    /**
     * Gets the value of the typeFilter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeFilter() {
        return typeFilter;
    }

    /**
     * Sets the value of the typeFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeFilter(String value) {
        this.typeFilter = value;
    }

    /**
     * Gets the value of the valueRangeGetter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValueRangeGetter() {
        return valueRangeGetter;
    }

    /**
     * Sets the value of the valueRangeGetter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValueRangeGetter(String value) {
        this.valueRangeGetter = value;
    }

    /**
     * Gets the value of the optionGroupLabelMethodExpression property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptionGroupLabelMethodExpression() {
        return optionGroupLabelMethodExpression;
    }

    /**
     * Sets the value of the optionGroupLabelMethodExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionGroupLabelMethodExpression(String value) {
        this.optionGroupLabelMethodExpression = value;
    }

    /**
     * Gets the value of the optionLabelMethodExpression property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptionLabelMethodExpression() {
        return optionLabelMethodExpression;
    }

    /**
     * Sets the value of the optionLabelMethodExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionLabelMethodExpression(String value) {
        this.optionLabelMethodExpression = value;
    }

    /**
     * Gets the value of the jurisdiction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJurisdiction() {
        return jurisdiction;
    }

    /**
     * Sets the value of the jurisdiction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJurisdiction(String value) {
        this.jurisdiction = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffectiveDate(String value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpirationDate(String value) {
        this.expirationDate = value;
    }

    /**
     * Gets the value of the available property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAvailable() {
        return available;
    }

    /**
     * Sets the value of the available property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAvailable(Boolean value) {
        this.available = value;
    }

}
