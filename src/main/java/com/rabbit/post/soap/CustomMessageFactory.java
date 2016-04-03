package com.rabbit.post.soap;

import com.sun.xml.messaging.saaj.soap.MessageFactoryImpl;
import com.sun.xml.messaging.saaj.soap.ver1_1.Message1_1Impl;
import org.apache.commons.codec.binary.Base64;

import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

/**
 * Custom Message Factory.
 */
public class CustomMessageFactory extends MessageFactoryImpl {

    /**
     * Class Constructor.
     *
     * @return Message1_1Impl
     * @throws SOAPException when there is a SOAP error.
     */
    @Override
    public SOAPMessage createMessage() throws SOAPException {
        return new Message1_1Impl();
    }

    /**
     * Create a new message.
     *
     * @param mimeHeaders headers to add to the message
     * @param in input stream to use in the message.
     * @return New SOAP 1.1 message.
     * @throws IOException when there is an IO error
     * @throws SOAPException when there is a SOAP error
     */
    @Override
    public SOAPMessage createMessage(final MimeHeaders mimeHeaders, final InputStream in)
            throws IOException, SOAPException {
        MimeHeaders headers = mimeHeaders;
        if (headers == null) {
            headers = new MimeHeaders();
        }
        headers.setHeader("Content-Type", "text/xml");
        String authString = "user:password";
        headers.setHeader("Authorization", String.valueOf(Collections.singletonList("Basic " + new String(Base64.encodeBase64(authString.getBytes())))));

        Message1_1Impl msg = new Message1_1Impl(headers, in);
        msg.setLazyAttachments(this.lazyAttachments);
        return msg;
    }
}
