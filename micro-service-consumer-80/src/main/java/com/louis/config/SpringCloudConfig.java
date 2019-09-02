package com.louis.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    @LoadBalanced  // 引入ribbon负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
