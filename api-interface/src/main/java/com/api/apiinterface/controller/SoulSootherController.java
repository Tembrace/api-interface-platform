package com.api.apiinterface.controller;

import com.api.apiinterface.service.SoulSootherInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 随机返回一条心灵鸡汤
 *
 * @author huoyouri
 */
@RestController
@RequestMapping("/soul")
@Slf4j
public class SoulSootherController {
    
    @Resource
    private SoulSootherInfoService soulSootherInfoService;
    
    @GetMapping("/get")
    public String getRandomSoulSoother() {
        return soulSootherInfoService.getRandomSoulSoother();
    }
}
