package com.api.sdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import static com.api.sdk.utils.SignUtils.genSign;

/**
 * 调用第三方接口的客户端
 *
 * @author huoyouri
 */
@Slf4j
public class ApiClientGetSoup {

    private static final String GATEWAY_HOST = "http://localhost:8888";

    private final String accessKey;

    private final String secretKey;

    public ApiClientGetSoup(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    @Override
    public String toString() {
        return "ApiClient{" +
                "accessKey='" + accessKey + '\'' +
                ", secretKey='" + secretKey + '\'' +
                '}';
    }

    /**
     * 获取随机的一条心灵鸡汤
     *
     * @return {@link String}
     */
    public String getRandomSoulSoother() {
        HttpResponse httpResponse = HttpRequest.get(GATEWAY_HOST + "/api/soul/get")
                .addHeaders(getHeaderMap(""))
                .body("")
                .execute();
        log.info("getRandomSoulSoother " + httpResponse.getStatus());
        String result = httpResponse.body();
        log.info("getRandomSoulSoother " + result);
        return result;
    }

    /**
     * 添加请求头信息
     *
     * @param body 请求头
     * @return {@link Map}<{@link String}, {@link String}>
     */
    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        // 一定不能直接发送, 要通过加密转成sign
        hashMap.put("sign", genSign(body, secretKey));
        log.info("getHeaderMap is: " + hashMap);
        return hashMap;
    }
}
