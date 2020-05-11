package com.quaint.consumer.rpc;

import com.quaint.provider.api.ProviderApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 11 May 2020
 */
@FeignClient(name = "provider-server")
public interface RpcProviderApi extends ProviderApi {

}
