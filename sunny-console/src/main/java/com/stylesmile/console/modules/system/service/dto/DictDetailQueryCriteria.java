package com.stylesmile.console.modules.system.service.dto;

import lombok.Data;
import sunny.stylesmile.common.annotation.Query;

/**
* @author Stylesmile
* @date 2019-04-10
*/
@Data
public class DictDetailQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String label;

    @Query(propName = "name",joinName = "dict")
    private String dictName;
}