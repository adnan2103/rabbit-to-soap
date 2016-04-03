package com.rabbit.post.gateway;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.core.DestinationResolver;
import org.springframework.stereotype.Service;


/**
 * Created by khana on 11/12/15.
 */
@Service
public class SendSOAPRequest {

    @Autowired
    DestinationResolver<MessageChannel> channelResolver;

    @HystrixCommand(
            fallbackMethod = "fallback",
            commandKey = "CountryDetailsAction",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "800000"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000000")
            }
    )
    @ServiceActivator(inputChannel = "to-hystrix")
    public void sendSOAPRequestToODE(String requestXML) {

        Message<String> message = MessageBuilder.withPayload(requestXML).build();
        MessageChannel channel = channelResolver.resolveDestination("country-soap-request-channel");
        System.out.println("I am going to call SOAP Request. with message ==> " + message);

        channel.send(message);
    }

    public void fallback(String requestXML) {

        System.out.println("You are in Fallback.===>");

        /*Country country = new Country();
        country.setCountryId(123);
        Message<Country> message = MessageBuilder.withPayload(country).build();
        MessageChannel channel = channelResolver.resolveDestination("request-json-channel");
        channel.send(message);*/
    }
}
