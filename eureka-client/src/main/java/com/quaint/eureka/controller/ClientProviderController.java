package com.quaint.eureka.controller;

import com.quaint.eureka.helper.HealthHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    HealthHelper healthHelper;


    /**
     * provider 提供服务
     * @return 对应provider 端口号, 测试负载均衡
     */
    @GetMapping("/get/hello")
    public String getHelloWord(){
        return "server[" + appName +":"+ port + "] say: hello world! ";
    }

    /**
     * postman post 请求终止该服务使用下面api接口
     * http://localhost:10020/actuator/shutdown
     *
     * 修改服务状态
     * @param status 状态
     * @return 修改后的抓固态
     */
    @GetMapping("/update/status")
    public Boolean updateServerStatus(@RequestParam("status") Boolean status){
        healthHelper.setStatus(status);
        healthHelper.health();
        return healthHelper.getStatus();
    }


}
