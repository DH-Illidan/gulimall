package com.atguigu.gulimall.coupon;

import com.atguigu.common.config.Swagger2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * @author Illidan
 */
@Import(Swagger2Config.class)
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallCouponApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }
    
}
