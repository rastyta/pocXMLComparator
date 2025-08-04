
package com.gw.xmlcompare.model.formlobfieldmeta;

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

    private final static QName _LobFieldMeta_QNAME = new QName("", "LobFieldMeta");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LobFieldMetaType }
     * 
     */
    public LobFieldMetaType createLobFieldMetaType() {
        return new LobFieldMetaType();
    }

    /**
     * Create an instance of {@link EntityType }
     * 
     */
    public EntityType createEntityType() {
        return new EntityType();
    }

    /**
     * Create an instance of {@link ColumnType }
     * 
     */
    public ColumnType createColumnType() {
        return new ColumnType();
    }

    /**
     * Create an instance of {@link VersionType }
     * 
     */
    public VersionType createVersionType() {
        return new VersionType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LobFieldMetaType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LobFieldMetaType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "LobFieldMeta")
    public JAXBElement<LobFieldMetaType> createLobFieldMeta(LobFieldMetaType value) {
        return new JAXBElement<LobFieldMetaType>(_LobFieldMeta_QNAME, LobFieldMetaType.class, null, value);
    }

}
