package com.louis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @author lu
 * @create 2019-05-04 22:18
 */
@EnableCircuitBreaker
@SpringBootApplication
public class StudentProviderHystrixApplication_1004 {

    public static void main(String[] args) {
        SpringApplication.run(StudentProviderHystrixApplication_1004.class, args);
    }

}
