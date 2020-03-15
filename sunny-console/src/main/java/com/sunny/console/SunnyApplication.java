package com.sunny.console;

import com.sunny.console.repository.JpaRepositoryReBuild;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 启动类
 *
 * @author chenye
 * @date 2020-0314
 * EnableJpaAuditing 允许编辑jpa
 * JpaRepositoryReBuild 重写jpa
 * EnableJpaRepositories  扫描 repository
 * EntityScan 扫描实体 最好添加
 */
@EnableJpaAuditing
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableJpaRepositories(
        value = {"com.sunny.console.repository"},
        repositoryBaseClass = JpaRepositoryReBuild.class)
@EntityScan(basePackages = {"com.sunny.console.entity"})
public class SunnyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SunnyApplication.class, args);
    }

}
