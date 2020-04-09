package com.quaint.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author quaint
 * @since 09 April 2020
 */
@RestController
public class ClientProviderController {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private String port;


    @GetMapping("/get/hello")
    public String getHelloWord(){

        return "provider " + port + " --> hello world! " + appName;
    }

}
