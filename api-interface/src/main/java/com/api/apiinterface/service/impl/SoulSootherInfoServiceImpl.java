package com.api.apiinterface.service.impl;

import com.api.apiinterface.mapper.SoulSootherInfoMapper;
import com.api.apiinterface.model.SoulSootherInfo;
import com.api.apiinterface.service.SoulSootherInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * 心灵鸡汤实现类
 *
 * @author huoyouri
 */
@Service
public class SoulSootherInfoServiceImpl extends ServiceImpl<SoulSootherInfoMapper, SoulSootherInfo>
        implements SoulSootherInfoService {
    @Resource
    private SoulSootherInfoMapper soulSootherInfoMapper;

    @Override
    public String getRandomSoulSoother() {
        Random random = new Random();
        long count = this.count();
        QueryWrapper<SoulSootherInfo> query = new QueryWrapper<>();
        query.eq("id", random.nextInt((int) count) + 1);
        SoulSootherInfo res = soulSootherInfoMapper.selectOne(query);
        return res.getSentence();
    }
}




