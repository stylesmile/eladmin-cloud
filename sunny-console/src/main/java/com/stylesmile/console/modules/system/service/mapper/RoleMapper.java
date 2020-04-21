package com.stylesmile.console.modules.system.service.mapper;

import com.stylesmile.console.modules.system.domain.Role;
import sunny.stylesmile.common.base.BaseMapper;
import com.stylesmile.console.modules.system.service.dto.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Stylesmile
 * @date 2019-11-23
 */
@Mapper(componentModel = "spring", uses = {MenuMapper.class, DeptMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends BaseMapper<RoleDto, Role> {

}
