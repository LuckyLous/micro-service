package com.louis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * EnableEurekaClient ribbon
 * EnableCircuitBreaker hystrix
 * @author lu
 * @create 2019-05-04 22:18
 */
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
public class StudentProviderHystrixApplication_1005 {

    public static void main(String[] args) {
        SpringApplication.run(StudentProviderHystrixApplication_1005.class, args);
    }

}
