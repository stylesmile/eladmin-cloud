package com.sunny;

import com.sunny.repository.JpaRepositoryReBuild;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 启动类
 *
 * @author chenye
 * @date 2020-0314
 */
@EnableJpaAuditing
@SpringBootApplication
@EnableJpaRepositories(
        value = {"com.sunny.repository"},
        repositoryBaseClass = JpaRepositoryReBuild.class)//最好添加
@EntityScan(basePackages = {"com.sunny.entity"})//最好添加
public class SunnyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SunnyApplication.class, args);
    }

}
