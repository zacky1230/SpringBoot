package com.zctech88.SpringBootIntegration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zctech88.SpringBootIntegration.dao")
public class TestSpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(TestSpringBoot.class, args);
    }
}
