package com.api.project.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 删除请求
 *
 * @author huoyouri
 */
@Data
public class IdRequest implements Serializable {

    private Long id;

    private static final long serialVersionUID = 1L;
}