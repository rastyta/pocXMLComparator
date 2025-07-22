
package com.gw.xmlcompare.model.formpatterns;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


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
 *         &amp;lt;element ref="{}FormPatternProduct" maxOccurs="unbounded"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "formPatternProduct"
})
@XmlRootElement(name = "FormPatternProducts")
public class FormPatternProducts {

    @XmlElement(name = "FormPatternProduct", required = true)
    protected List<FormPatternProduct> formPatternProduct;

    /**
     * Gets the value of the formPatternProduct property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the formPatternProduct property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getFormPatternProduct().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link FormPatternProduct }
     * 
     * 
     */
    public List<FormPatternProduct> getFormPatternProduct() {
        if (formPatternProduct == null) {
            formPatternProduct = new ArrayList<FormPatternProduct>();
        }
        return this.formPatternProduct;
    }

}
