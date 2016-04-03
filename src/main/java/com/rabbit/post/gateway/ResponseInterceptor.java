package com.rabbit.post.gateway;

import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;

/**
 * Created by khana on 09/12/15.
 */
public class ResponseInterceptor implements ClientInterceptor {
    @Override
    public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
        System.out.println("####### handleRequest #########");
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
        System.out.println("####### handleResponse #########");
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
        System.out.println("####### handleFault #########");
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Exception e) throws WebServiceClientException {
        System.out.println("####### afterCompletion #########"+messageContext.hasResponse());
    }
}
