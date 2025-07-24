
package com.gw.xmlcompare.model.formavailability;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AvailabilityConfig_QNAME = new QName("", "AvailabilityConfig");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AvailabilityConfigType }
     * 
     */
    public AvailabilityConfigType createAvailabilityConfigType() {
        return new AvailabilityConfigType();
    }

    /**
     * Create an instance of {@link ContainerType }
     * 
     */
    public ContainerType createContainerType() {
        return new ContainerType();
    }

    /**
     * Create an instance of {@link PropertyType }
     * 
     */
    public PropertyType createPropertyType() {
        return new PropertyType();
    }

    /**
     * Create an instance of {@link VersionType }
     * 
     */
    public VersionType createVersionType() {
        return new VersionType();
    }

    /**
     * Create an instance of {@link DependsType }
     * 
     */
    public DependsType createDependsType() {
        return new DependsType();
    }

    /**
     * Create an instance of {@link OnType }
     * 
     */
    public OnType createOnType() {
        return new OnType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AvailabilityConfigType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AvailabilityConfigType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "AvailabilityConfig")
    public JAXBElement<AvailabilityConfigType> createAvailabilityConfig(AvailabilityConfigType value) {
        return new JAXBElement<AvailabilityConfigType>(_AvailabilityConfig_QNAME, AvailabilityConfigType.class, null, value);
    }

}
