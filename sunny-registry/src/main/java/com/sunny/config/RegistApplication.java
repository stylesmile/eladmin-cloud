package com.sunny.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author chenye
 * @date 2020-0401
 */
@EnableEurekaServer
@SpringBootApplication
public class RegistApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistApplication.class, args);
    }

}
