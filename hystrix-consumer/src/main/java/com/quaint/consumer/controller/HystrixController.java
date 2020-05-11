package com.quaint.consumer.controller;

import com.quaint.consumer.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("hystrix")
public class HystrixController {

    @Autowired
    HystrixService hystrixService;

    @GetMapping("hello")
    public String hystrixRpcSayHello(){
        return hystrixService.hystrixRpcSayHello();
    }

}
