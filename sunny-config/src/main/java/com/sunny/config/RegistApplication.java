package com.sunny.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chenye
 * @date 2020-0402
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class RegistApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistApplication.class, args);
    }

}
