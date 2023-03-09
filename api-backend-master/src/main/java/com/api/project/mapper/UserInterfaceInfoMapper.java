package com.api.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.api.common.model.entity.UserInterfaceInfo;

import java.util.List;


/**
 * UserInterfaceInfo的mapper
 * 
 * @author huoyouri
 */
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);

}




