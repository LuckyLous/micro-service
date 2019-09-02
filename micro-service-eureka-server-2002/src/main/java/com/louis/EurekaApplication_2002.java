package com.louis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 主要是加入@EnableEurekaServer
 * @author lu
 * @create 2019-05-05 0:11
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication_2002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication_2002.class, args);
    }
}
