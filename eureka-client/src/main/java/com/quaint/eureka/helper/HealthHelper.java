package com.quaint.eureka.helper;

import lombok.Data;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author quaint
 * @since 11 April 2020
 */
@Component
@Data
public class HealthHelper implements HealthIndicator {

    /**
     * 服务状态
     */
    private Boolean status = true;

    @Override
    public Health health() {
        if (status){
            return Health.up().build();
        }
        return Health.down().build();
    }
}
