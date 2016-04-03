package com.rabbit.post.gateway;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class CountryTransformer {

    @Resource
    private org.springframework.core.io.Resource countryXML;

    /**
     * SAXBuilder object.
     */
    @Autowired
    private SAXBuilder saxBuilder;

    @Transformer(
            inputChannel = "consume-counrty-request-xml-channel",
            outputChannel = "to-hystrix"
    )
    public String getCountryXML() throws IOException, JDOMException {

        Document document = saxBuilder.build(countryXML.getURL());
        XMLOutputter xmlOutputter = new XMLOutputter();
        System.out.println("REQuest MAGIC IS "+xmlOutputter.outputString(document));
        return xmlOutputter.outputString(document);
    }
}
