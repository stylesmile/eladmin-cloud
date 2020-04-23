package com.eladmin.modules.system.service.dto;

import com.eladmin.annotation.Query;
import lombok.Data;

/**
 * @author Zheng Jie
 * 公共查询类
 */
@Data
public class DictQueryCriteria {

    @Query(blurry = "name,remark")
    private String blurry;
}
