
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

})
@XmlSeeAlso({
    PropertyInfoVersionType.class,
    AutoNumberPropertyInfoType.class, PropertyInfoType.class
})
public class BasePropertyInfoType {


}
