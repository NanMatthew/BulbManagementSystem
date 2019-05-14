package com.sicnu.bulb.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by HY
 * 2019/5/13 21:15
 */
@Configuration
public class MyConfig {

    /**
     * 屏蔽Jackson null转换报的错
     * <p>
     * 默认情况下Jackson 转换时 为空时报错
     */
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

}
