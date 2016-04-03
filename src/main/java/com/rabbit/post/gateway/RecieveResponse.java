package com.rabbit.post.gateway;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;
/**
 * Created by khana on 09/12/15.
 */
@Service
public class RecieveResponse {

    @ServiceActivator(
            inputChannel = "country-soap-response-channel")
    public void getResponse (String response) {
        System.out.println("Response Magic : "+response);
    }
}
