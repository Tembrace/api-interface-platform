package com.api.apiinterface;

import com.api.sdk.client.ApiClientGetName;
import com.api.sdk.client.ApiClientGetSoup;
import com.api.sdk.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class ApiInterfaceApplicationTests {

    @Resource
    private ApiClientGetName apiClientGetName;

    @Resource
    private ApiClientGetSoup apiClientGetSoup;

    @Test
    void getName() {
        // 测试sdk
        log.info("ApiClientGetName: " + apiClientGetName);
        User user = new User();
        user.setUsername("huoyouri");
        // 这个方法在请求头添加了签名认证参数
        String usernameByPost = apiClientGetName.getUsernameByPost(user);
        log.info(usernameByPost);
    }

    @Test
    void getSoup() {
        // 测试sdk
        log.info("ApiClientGetSoup: " + apiClientGetSoup);
        // 这个方法在请求头添加了签名认证参数
        String soup = apiClientGetSoup.getRandomSoulSoother();
        log.info(soup);
    }
}
