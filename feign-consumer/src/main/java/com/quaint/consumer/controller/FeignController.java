package com.quaint.consumer.controller;

import com.quaint.consumer.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
public class FeignController {

    @Autowired
    FeignService feignService;

    @GetMapping("rpc/hello")
    public String rpcSayHello(){
        return feignService.rpcSayHello();
    }

}
