package com.quaint.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 *
 * desc: 第二个实例 请增加参数
 *
 * -Dserver.port=9996
 *
 * </p>
 *
 * @author quaint
 * @since 11 May 2020
 */
@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }

}
