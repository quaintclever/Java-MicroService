package com.quaint.consumer.service.impl;

import com.quaint.consumer.service.FeignService;
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
public class FeignServiceImpl implements FeignService {

    @Autowired
    ProviderApi providerApi;

    @Override
    public String rpcSayHello() {
        return providerApi.sayHello();
    }
}
