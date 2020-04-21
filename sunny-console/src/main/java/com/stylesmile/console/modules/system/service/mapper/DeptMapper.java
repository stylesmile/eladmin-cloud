package com.stylesmile.console.modules.system.service.mapper;

import com.stylesmile.console.modules.system.domain.Dept;
import sunny.stylesmile.common.base.BaseMapper;
import com.stylesmile.console.modules.system.service.dto.DeptDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Stylesmile
* @date 2019-03-25
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptMapper extends BaseMapper<DeptDto, Dept> {

}