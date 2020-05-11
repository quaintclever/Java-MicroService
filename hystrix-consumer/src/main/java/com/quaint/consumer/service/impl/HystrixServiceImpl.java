package com.quaint.consumer.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.quaint.consumer.service.HystrixService;
import com.quaint.provider.api.ProviderApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 11 May 2020
 */
@Service
public class HystrixServiceImpl implements HystrixService {

    @Autowired
    ProviderApi providerApi;


    @HystrixCommand(defaultFallback = "sayHelloBack")
    @Override
    public String hystrixRpcSayHello() {
        return providerApi.sayHello();
    }

    private String sayHelloBack(){
        return "sayHelloBack";
    }
}
