package com.api.apiinterface.controller;

import com.api.sdk.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 返回用户的名字
 *
 * @author huoyouri
 */
@RestController
@RequestMapping("/name")
@Slf4j
public class NameController {

    @GetMapping("/get")
    public String getNameByGet(String name) {
        return "GET 你的名字是" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestBody User user) {
        return "POST 你的名字是" + user.getUsername();
    }
}
