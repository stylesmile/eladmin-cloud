package com.eladmin.modules.mnt.service.mapper;

import com.eladmin.base.BaseMapper;
import com.eladmin.modules.mnt.domain.ServerDeploy;
import com.eladmin.modules.mnt.service.dto.ServerDeployDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author zhanghouying
* @date 2019-08-24
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServerDeployMapper extends BaseMapper<ServerDeployDto, ServerDeploy> {

}
