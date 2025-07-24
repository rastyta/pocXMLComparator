
package com.gw.xmlcompare.model.formavailability;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ContainerTypeEnum.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="ContainerTypeEnum"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *     &amp;lt;enumeration value="Coverable"/&amp;gt;
 *     &amp;lt;enumeration value="Schedule"/&amp;gt;
 *     &amp;lt;enumeration value="Clause"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "ContainerTypeEnum")
@XmlEnum
public enum ContainerTypeEnum {

    @XmlEnumValue("Coverable")
    COVERABLE("Coverable"),
    @XmlEnumValue("Schedule")
    SCHEDULE("Schedule"),
    @XmlEnumValue("Clause")
    CLAUSE("Clause");
    private final String value;

    ContainerTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ContainerTypeEnum fromValue(String v) {
        for (ContainerTypeEnum c: ContainerTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
