package com.louis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author lu
 * @create 2019-09-08 17:51
 */
@EnableZuulProxy
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ZuulApplication_3001 {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication_3001.class, args);
    }
}
