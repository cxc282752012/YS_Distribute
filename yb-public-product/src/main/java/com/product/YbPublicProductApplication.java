package com.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.product.mapper")
public class YbPublicProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(YbPublicProductApplication.class, args);
	}

}
