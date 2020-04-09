package com.quaint.eureka.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author quaint
 * @since 09 April 2020
 */
@RestController
public class ClientConsumerController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    /**
     * ===================== discoveryClient =====================
     */
    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/consumer/hello")
    public String consumerHelloWord(){

        String description = discoveryClient.description();
        System.out.println("==> discoveryClient.description <== description:" + description);

        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-client-provider");
        System.out.println("==> discoveryClient.getInstances <== size:"+instances.size());
        instances.forEach(System.out::println);

        List<String> services = discoveryClient.getServices();
        System.out.println("==> discoveryClient.getServices <== size:"+services.size());
        services.forEach(System.out::println);

        return "consumerHelloWord";
    }




    /**
     * ===================== eurekaClient =====================
     */
    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    /**
     * // eureka ui 里面的 Status 里面的 id , 获取某一个实例
     * List<InstanceInfo> instances1 = eurekaClient.getInstancesById("quaintdembp.lan:eureka-client-provider:10020");
     * @return str
     */
    @GetMapping("/consumer/hello2")
    public String consumerHelloWord2(){

        // 通过服务名 获取实例
        List<InstanceInfo> instances = eurekaClient.getInstancesByVipAddress("eureka-client-provider", false);

        // 输出实例信息
        System.out.println("==> eurekaClient.getInstancesById <== size:"+instances.size());
        instances.forEach(System.out::println);

        if (instances.size()>0){

            // 创建远程调用对象
            RestTemplate restTemplate = new RestTemplate();
            // 获取第一个实例
            InstanceInfo ins = instances.get(0);
            // 如果 eureka 拉取的服务没有挂掉
            if (ins.getStatus().equals(InstanceInfo.InstanceStatus.UP)){
                String url = "http://"+ins.getHostName()+":"+ins.getPort()+"/get/hello";
                System.out.println(url);


                String forObject = restTemplate.getForObject(url, String.class);
                System.out.println(forObject);
            }

            // 通过负载均衡获取实例
            ServiceInstance choose = loadBalancerClient.choose("eureka-client-provider");
            String url = "http://"+choose.getHost()+":"+choose.getPort()+"/get/hello";
            String forObject = restTemplate.getForObject(url, String.class);
            System.out.println("loadBalancerClient ==>" + forObject);

        }

        return "consumerHelloWord2";
    }

}
