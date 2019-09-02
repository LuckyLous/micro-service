package com.louis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lu
 * @create 2019-05-04 22:40
 */
@Configuration
public class SpringCloudConfig {

    /**
     * 调用服务模版
     * @return
     */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
