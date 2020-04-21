package com.stylesmile.console.modules.system.service.mapper;

import com.stylesmile.console.modules.system.domain.Dept;
import com.stylesmile.console.modules.system.service.dto.DeptSmallDto;
import sunny.stylesmile.common.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Stylesmile
* @date 2019-03-25
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptSmallMapper extends BaseMapper<DeptSmallDto, Dept> {

}