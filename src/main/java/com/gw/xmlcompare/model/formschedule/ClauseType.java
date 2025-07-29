
package com.gw.xmlcompare.model.formschedule;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * &lt;p&gt;Java class for ClauseType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ClauseType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;choice maxOccurs="unbounded"&amp;gt;
 *           &amp;lt;element ref="{}AutoNumberPropertyInfo"/&amp;gt;
 *           &amp;lt;element ref="{}PropertyInfo" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;/choice&amp;gt;
 *         &amp;lt;element ref="{}ItemClause" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *       &amp;lt;attribute ref="{}pattern use="required""/&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClauseType", propOrder = {
    "autoNumberPropertyInfoOrPropertyInfo",
    "itemClause"
})
public class ClauseType {

    @XmlElements({
        @XmlElement(name = "AutoNumberPropertyInfo", type = AutoNumberPropertyInfoType.class),
        @XmlElement(name = "PropertyInfo", type = PropertyInfoType.class)
    })
    protected List<Object> autoNumberPropertyInfoOrPropertyInfo;
    @XmlElement(name = "ItemClause")
    protected List<ItemClauseType> itemClause;
    @XmlAttribute(name = "pattern", required = true)
    protected String pattern;

    /**
     * Gets the value of the autoNumberPropertyInfoOrPropertyInfo property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the autoNumberPropertyInfoOrPropertyInfo property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getAutoNumberPropertyInfoOrPropertyInfo().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link AutoNumberPropertyInfoType }
     * {@link PropertyInfoType }
     * 
     * 
     */
    public List<Object> getAutoNumberPropertyInfoOrPropertyInfo() {
        if (autoNumberPropertyInfoOrPropertyInfo == null) {
            autoNumberPropertyInfoOrPropertyInfo = new ArrayList<Object>();
        }
        return this.autoNumberPropertyInfoOrPropertyInfo;
    }

    /**
     * Gets the value of the itemClause property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the itemClause property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getItemClause().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ItemClauseType }
     * 
     * 
     */
    public List<ItemClauseType> getItemClause() {
        if (itemClause == null) {
            itemClause = new ArrayList<ItemClauseType>();
        }
        return this.itemClause;
    }

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

}
