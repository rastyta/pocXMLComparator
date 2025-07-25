package com.gw.xmlcompare.loader;

import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlLoaderJaxb {
    public static <T> T loadXml(Document doc, Class<T> clazz) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Object obj = unmarshaller.unmarshal(doc);
        if (clazz.isInstance(obj)) {
            return clazz.cast(obj);
        } else {
            throw new ClassCastException("Expected " + clazz + " but got " + obj.getClass());
        }
    }
}