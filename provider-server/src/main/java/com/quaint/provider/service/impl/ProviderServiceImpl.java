package com.quaint.provider.service.impl;

import com.quaint.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

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

    /**
     * 调用次数临时计数
     */
    private int count = 0;

    @Override
    public String sayHello(){
        System.out.println(appName+":"+port+" == >接口第"+ ++count + "次调用");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return appName+":"+port+" ==> hello";
    }


}
