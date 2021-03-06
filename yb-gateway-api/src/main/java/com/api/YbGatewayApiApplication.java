package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableHystrix
@EnableDiscoveryClient
@EnableFeignClients
public class YbGatewayApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YbGatewayApiApplication.class, args);
    }

}
