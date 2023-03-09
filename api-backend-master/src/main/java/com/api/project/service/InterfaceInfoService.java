package com.api.project.service;

import com.api.common.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * 接口信息服务
 *
 * @author huoyouri
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
