package com.stylesmile.console.modules.monitor.service.mapper;

import com.stylesmile.console.modules.monitor.domain.Server;
import com.stylesmile.console.modules.monitor.service.dto.ServerDTO;
import sunny.stylesmile.common.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Zhang houying
* @date 2019-11-03
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServerMapper extends BaseMapper<ServerDTO, Server> {

    @Override
    ServerDTO toDto(Server server);
}
