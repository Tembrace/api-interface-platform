package com.api.sdk;

import com.api.sdk.client.ApiClientGetSoup;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("api.client.get-soup")
@Data
@ComponentScan 
public class ApiClientGetSoupConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public ApiClientGetSoup apiClientGetSoup() {
        return new ApiClientGetSoup(accessKey, secretKey);
    }
}
