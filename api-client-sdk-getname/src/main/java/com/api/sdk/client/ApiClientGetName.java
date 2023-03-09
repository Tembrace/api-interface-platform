package com.api.sdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.api.sdk.model.User;
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
public class ApiClientGetName {

    private static final String GATEWAY_HOST = "http://localhost:8888";

    private final String accessKey;

    private final String secretKey;

    public ApiClientGetName(String accessKey, String secretKey) {
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
     * Get请求获取userName，后续加上鉴权后不能访问，当作前期测试
     *
     * @param name 名字
     * @return {@link String}
     */
    public String getNameByGet(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String s = HttpUtil.get(GATEWAY_HOST + "/api/name/get", paramMap);
        log.info("getNameByGet: " + s);
        return s;
    }


    /**
     * POST请求获取userName
     *
     * @param user 用户
     * @return {@link String}
     */
    public String getUsernameByPost(User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/post")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        log.info("getUsernameByPost " + httpResponse.getStatus());
        String result = httpResponse.body();
        log.info("getUsernameByPost " + result);
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
