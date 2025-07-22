package com.gw.xmlcompare.loader;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;

public class XmlLoader {

    public static <T> T loadXml(File file, Class<T> clazz) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(file, clazz);
    }
}