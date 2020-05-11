package com.quaint.provider.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 11 May 2020
 */
@RequestMapping("provider")
public interface ProviderApi {

    @GetMapping("/hello")
    String sayHello();

}
