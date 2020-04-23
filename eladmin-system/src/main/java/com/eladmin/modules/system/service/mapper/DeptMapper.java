package com.eladmin.modules.system.service.mapper;

import com.eladmin.base.BaseMapper;
import com.eladmin.modules.system.domain.Dept;
import com.eladmin.modules.system.service.dto.DeptDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Zheng Jie
* @date 2019-03-25
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptMapper extends BaseMapper<DeptDto, Dept> {

}