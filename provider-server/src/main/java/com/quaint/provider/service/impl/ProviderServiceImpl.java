package com.quaint.provider.service.impl;

import com.quaint.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Value;
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
public class ProviderServiceImpl implements ProviderService {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private String port;


    @Override
    public String sayHello(){
        return appName+":"+port+" ==> hello";
    }


}
