package com.api.apiinterface.service;

import com.api.apiinterface.model.SoulSootherInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 心灵鸡汤服务
 *
 * @author huoyouri
 */
public interface SoulSootherInfoService extends IService<SoulSootherInfo> {

    String getRandomSoulSoother();
}
