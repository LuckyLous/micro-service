package com.louis.config;

import com.louis.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author lu
 * @create 2019-09-08 18:35
 */
@Component
public class ZuulConfig {

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }

}
