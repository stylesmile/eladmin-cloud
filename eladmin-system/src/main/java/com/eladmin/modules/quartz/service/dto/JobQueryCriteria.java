package com.eladmin.modules.quartz.service.dto;

import com.eladmin.annotation.Query;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Zheng Jie
 * @date 2019-6-4 10:33:02
 */
@Data
public class JobQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String jobName;

    @Query
    private Boolean isSuccess;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
