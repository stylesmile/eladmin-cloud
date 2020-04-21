package com.stylesmile.console.modules.system.service.dto;

import lombok.Data;
import sunny.stylesmile.common.annotation.Query;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Stylesmile
 * 公共查询类
 */
@Data
public class MenuQueryCriteria {

    @Query(blurry = "name,path,component")
    private String blurry;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
