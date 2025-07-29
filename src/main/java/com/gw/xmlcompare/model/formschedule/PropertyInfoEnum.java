
package com.gw.xmlcompare.model.formschedule;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for PropertyInfoEnum.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="PropertyInfoEnum"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *     &amp;lt;enumeration value="Integer"/&amp;gt;
 *     &amp;lt;enumeration value="Percent"/&amp;gt;
 *     &amp;lt;enumeration value="String"/&amp;gt;
 *     &amp;lt;enumeration value="Boolean"/&amp;gt;
 *     &amp;lt;enumeration value="Date"/&amp;gt;
 *     &amp;lt;enumeration value="TypeKey"/&amp;gt;
 *     &amp;lt;enumeration value="ForeignKey"/&amp;gt;
 *     &amp;lt;enumeration value="PolicyLocation"/&amp;gt;
 *     &amp;lt;enumeration value="Building"/&amp;gt;
 *     &amp;lt;enumeration value="NamedInsured"/&amp;gt;
 *     &amp;lt;enumeration value="ForeignKeyWithOptionLabels"/&amp;gt;
 *     &amp;lt;enumeration value="AdditionalInsured"/&amp;gt;
 *     &amp;lt;enumeration value="AdditionalInterest"/&amp;gt;
 *     &amp;lt;enumeration value="Decimal"/&amp;gt;
 *     &amp;lt;enumeration value="ReadOnly"/&amp;gt;
 *     &amp;lt;enumeration value="TextArea"/&amp;gt;
 *     &amp;lt;enumeration value="Option"/&amp;gt;
 *     &amp;lt;enumeration value="PolicyContact"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "PropertyInfoEnum")
@XmlEnum
public enum PropertyInfoEnum {

    @XmlEnumValue("Integer")
    INTEGER("Integer"),
    @XmlEnumValue("Percent")
    PERCENT("Percent"),
    @XmlEnumValue("String")
    STRING("String"),
    @XmlEnumValue("Boolean")
    BOOLEAN("Boolean"),
    @XmlEnumValue("Date")
    DATE("Date"),
    @XmlEnumValue("TypeKey")
    TYPE_KEY("TypeKey"),
    @XmlEnumValue("ForeignKey")
    FOREIGN_KEY("ForeignKey"),
    @XmlEnumValue("PolicyLocation")
    POLICY_LOCATION("PolicyLocation"),
    @XmlEnumValue("Building")
    BUILDING("Building"),
    @XmlEnumValue("NamedInsured")
    NAMED_INSURED("NamedInsured"),
    @XmlEnumValue("ForeignKeyWithOptionLabels")
    FOREIGN_KEY_WITH_OPTION_LABELS("ForeignKeyWithOptionLabels"),
    @XmlEnumValue("AdditionalInsured")
    ADDITIONAL_INSURED("AdditionalInsured"),
    @XmlEnumValue("AdditionalInterest")
    ADDITIONAL_INTEREST("AdditionalInterest"),
    @XmlEnumValue("Decimal")
    DECIMAL("Decimal"),
    @XmlEnumValue("ReadOnly")
    READ_ONLY("ReadOnly"),
    @XmlEnumValue("TextArea")
    TEXT_AREA("TextArea"),
    @XmlEnumValue("Option")
    OPTION("Option"),
    @XmlEnumValue("PolicyContact")
    POLICY_CONTACT("PolicyContact");
    private final String value;

    PropertyInfoEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PropertyInfoEnum fromValue(String v) {
        for (PropertyInfoEnum c: PropertyInfoEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
