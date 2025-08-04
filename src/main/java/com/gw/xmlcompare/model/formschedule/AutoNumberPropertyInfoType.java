
package com.gw.xmlcompare.model.formschedule;

import javax.xml.bind.annotation.*;
import java.util.Objects;


/**
 * &lt;p&gt;Java class for AutoNumberPropertyInfoType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="AutoNumberPropertyInfoType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{}BasePropertyInfoType"&amp;gt;
 *       &amp;lt;attribute ref="{}name use="required""/&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AutoNumberPropertyInfoType", propOrder = {
        "name",
        "columnName",
        "columnLabel",
        "required",
        "priority"
})
public class AutoNumberPropertyInfoType extends BasePropertyInfoType{

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlElement(name = "ColumnName")
    protected String columnName;
    @XmlElement(name = "ColumnLabel")
    protected String columnLabel;
    @XmlElement(name = "Required")
    protected Boolean required;
    @XmlElement(name = "Priority")
    protected Integer priority;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnLabel() {
        return columnLabel;
    }

    public void setColumnLabel(String columnLabel) {
        this.columnLabel = columnLabel;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoNumberPropertyInfoType that = (AutoNumberPropertyInfoType) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(columnName, that.columnName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, columnName);
    }
}
