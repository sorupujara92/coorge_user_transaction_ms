package com.coorge.userandtransaction.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(
    basePackages = {
        "com.coorge.userandtransaction",
    })
@EntityScan(basePackages = {"com.coorge.userandtransaction.entity"})
@EnableJpaRepositories(basePackages = {"com.coorge.userandtransaction.repository"})
public class DataSourceConfig {


}
