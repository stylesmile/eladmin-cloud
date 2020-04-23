package com.eladmin.modules.monitor.service.dto;

import lombok.Data;
import com.eladmin.annotation.Query;

/**
* @author Zhang houying
* @date 2019-11-03
*/
@Data
public class ServerQueryCriteria{

    @Query(blurry = "name,address")
    private String blurry;
}