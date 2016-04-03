package com.rabbit.post.config;

import org.jdom.input.SAXBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created by khana on 09/12/15.
 */
@Configuration
public class ApplicationConfig {

    /**
     * Get the red flag template.
     * @return Resource for the template.
     * @throws IOException if the template cannot be found/read.
     */
    @Bean(name = "countryXML")
    public Resource getCreditCheckTemplate() throws IOException {
        return new ClassPathResource("countryXML.xml");
    }

    /**
     * Create a SAX Builder Bean.
     *
     * @return SaxBuilder Object
     */
    @Bean(name = "saxBuilder")
    public SAXBuilder getSaxBuilder() {
        return new SAXBuilder();
    }

    /**
     * Allow Hystrix to use AoP to create proxies for circuit breaking.
     *
     * @return Hystrix Command Aspect.
     */
    @Bean
    public HystrixCommandAspect hystrixAspect() {
        return new HystrixCommandAspect();
    }


}
