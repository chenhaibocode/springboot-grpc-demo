package com.chenhaibo.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: com.com.chenhaibo
 * @Description:
 * @Date: Created in 16:04 2018/7/26
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.chenhaibo")
@MapperScan("com.chenhaibo.dao")
public class GrpcServerEntry {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(GrpcServerEntry.class, args);
    }
}