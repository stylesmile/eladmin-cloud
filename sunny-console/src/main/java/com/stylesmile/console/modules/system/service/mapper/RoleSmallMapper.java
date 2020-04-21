package com.stylesmile.console.modules.system.service.mapper;

import com.stylesmile.console.modules.system.domain.Role;
import com.stylesmile.console.modules.system.service.dto.RoleSmallDto;
import sunny.stylesmile.common.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Stylesmile
 * @date 2019-5-23
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleSmallMapper extends BaseMapper<RoleSmallDto, Role> {

}
