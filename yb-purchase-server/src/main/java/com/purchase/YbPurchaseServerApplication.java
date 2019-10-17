package com.purchase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.purchase.mapper")
public class YbPurchaseServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YbPurchaseServerApplication.class, args);
    }

}
