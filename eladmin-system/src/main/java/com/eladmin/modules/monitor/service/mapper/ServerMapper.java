package com.eladmin.modules.monitor.service.mapper;

import com.eladmin.base.BaseMapper;
import com.eladmin.modules.monitor.domain.Server;
import com.eladmin.modules.monitor.service.dto.ServerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Zhang houying
* @date 2019-11-03
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServerMapper extends BaseMapper<ServerDTO, Server> {

}
