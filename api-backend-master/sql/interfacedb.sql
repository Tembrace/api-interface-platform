use apihuoyouri;

create table if not exists soul_soother_info
(
    id           bigint auto_increment comment 'id' primary key,
    sentence     text         not null comment '心灵鸡汤',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
) comment '心灵鸡汤表';

ALTER TABLE soul_soother_info ENGINE=MyISAM

