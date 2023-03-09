package com.api.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.api.common.model.entity.InterfaceInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * InterfaceInfo的mapper
 * 
 * @author huoyouri
 */
public interface InterfaceInfoMapper extends BaseMapper<InterfaceInfo> {

    /**
     * 测试的SQL
     */
    @Select("select id from interface_info where status = 1 order by createTime")
    List<Integer> listOrderCreateTime();
}




