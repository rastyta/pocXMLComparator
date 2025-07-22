
package com.gw.xmlcompare.model.formpatterns;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{}Availability"/&amp;gt;
 *         &amp;lt;element ref="{}EndEffectiveDate"/&amp;gt;
 *         &amp;lt;element ref="{}FormPattern"/&amp;gt;
 *         &amp;lt;element ref="{}Jurisdiction"/&amp;gt;
 *         &amp;lt;element ref="{}StartEffectiveDate"/&amp;gt;
 *         &amp;lt;element ref="{}UWCompanyCode"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *       &amp;lt;attribute name="public-id" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" /&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "availability",
    "endEffectiveDate",
    "formPattern",
    "jurisdiction",
    "startEffectiveDate",
    "uwCompanyCode"
})
@XmlRootElement(name = "FormPatternLookup")
public class FormPatternLookup {

    @XmlElement(name = "Availability", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String availability;
    @XmlElement(name = "EndEffectiveDate", required = true)
    protected EndEffectiveDate endEffectiveDate;
    @XmlElement(name = "FormPattern", required = true)
    protected FormPattern formPattern;
    @XmlElement(name = "Jurisdiction", required = true)
    protected String jurisdiction;
    @XmlElement(name = "StartEffectiveDate", required = true)
    protected String startEffectiveDate;
    @XmlElement(name = "UWCompanyCode", required = true)
    protected UWCompanyCode uwCompanyCode;
    @XmlAttribute(name = "public-id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String publicId;

    /**
     * Gets the value of the availability property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvailability() {
        return availability;
    }

    /**
     * Sets the value of the availability property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvailability(String value) {
        this.availability = value;
    }

    /**
     * Gets the value of the endEffectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link EndEffectiveDate }
     *     
     */
    public EndEffectiveDate getEndEffectiveDate() {
        return endEffectiveDate;
    }

    /**
     * Sets the value of the endEffectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link EndEffectiveDate }
     *     
     */
    public void setEndEffectiveDate(EndEffectiveDate value) {
        this.endEffectiveDate = value;
    }

    /**
     * Gets the value of the formPattern property.
     * 
     * @return
     *     possible object is
     *     {@link FormPattern }
     *     
     */
    public FormPattern getFormPattern() {
        return formPattern;
    }

    /**
     * Sets the value of the formPattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormPattern }
     *     
     */
    public void setFormPattern(FormPattern value) {
        this.formPattern = value;
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
     * Gets the value of the startEffectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartEffectiveDate() {
        return startEffectiveDate;
    }

    /**
     * Sets the value of the startEffectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartEffectiveDate(String value) {
        this.startEffectiveDate = value;
    }

    /**
     * Gets the value of the uwCompanyCode property.
     * 
     * @return
     *     possible object is
     *     {@link UWCompanyCode }
     *     
     */
    public UWCompanyCode getUWCompanyCode() {
        return uwCompanyCode;
    }

    /**
     * Sets the value of the uwCompanyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link UWCompanyCode }
     *     
     */
    public void setUWCompanyCode(UWCompanyCode value) {
        this.uwCompanyCode = value;
    }

    /**
     * Gets the value of the publicId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicId() {
        return publicId;
    }

    /**
     * Sets the value of the publicId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicId(String value) {
        this.publicId = value;
    }

}
