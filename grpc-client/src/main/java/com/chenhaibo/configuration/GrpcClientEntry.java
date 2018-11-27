package com.chenhaibo.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: chenhaibo
 * @Description:
 * @Date: Created in 16:04 2018/7/26
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.chenhaibo", "com.zk.springboot.grpc"})
public class GrpcClientEntry {
    public static void main(String[] args) {
        SpringApplication.run(GrpcClientEntry.class, args);
    }
}