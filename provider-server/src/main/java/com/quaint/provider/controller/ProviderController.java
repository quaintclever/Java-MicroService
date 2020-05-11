package com.quaint.provider.controller;

import com.quaint.provider.api.ProviderApi;
import com.quaint.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 11 May 2020
 */
@RestController
@RequestMapping("provider")
public class ProviderController implements ProviderApi {

    @Autowired
    ProviderService providerService;

    @Override
    public String sayHello(){
        return providerService.sayHello();
    }

}
