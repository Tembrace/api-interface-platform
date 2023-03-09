package com.api.sdk;

import com.api.sdk.client.ApiClientGetName;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("api.client.get-name")
@Data
@ComponentScan 
public class ApiClientGetNameConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public ApiClientGetName apiClientGetName() {
        return new ApiClientGetName(accessKey, secretKey);
    }
}
