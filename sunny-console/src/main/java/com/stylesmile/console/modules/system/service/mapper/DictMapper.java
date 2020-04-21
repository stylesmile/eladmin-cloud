package com.stylesmile.console.modules.system.service.mapper;

import com.stylesmile.console.modules.system.domain.Dict;
import sunny.stylesmile.common.base.BaseMapper;
import com.stylesmile.console.modules.system.service.dto.DictDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Stylesmile
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictMapper extends BaseMapper<DictDto, Dict> {

}