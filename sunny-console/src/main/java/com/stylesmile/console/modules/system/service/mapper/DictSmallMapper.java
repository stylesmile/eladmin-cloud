package com.stylesmile.console.modules.system.service.mapper;

import com.stylesmile.console.modules.system.domain.Dict;
import com.stylesmile.console.modules.system.service.dto.DictSmallDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import sunny.stylesmile.common.base.BaseMapper;

/**
* @author Stylesmile
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictSmallMapper extends BaseMapper<DictSmallDto, Dict> {

}