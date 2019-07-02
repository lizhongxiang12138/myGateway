package com.lzx.gateway.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @SpringBootApplication springboot启动类注解
 * @EnableEurekaClient 启用eureka客服端
 */
@SpringBootApplication
@EnableEurekaClient
public class MyGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyGatewayApplication.class, args);
	}

}
