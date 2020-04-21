package com.stylesmile.console.modules.system.service.mapper;

import com.stylesmile.console.modules.system.domain.DictDetail;
import com.stylesmile.console.modules.system.service.dto.DictDetailDto;
import sunny.stylesmile.common.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Stylesmile
* @date 2019-04-10
*/
@Mapper(componentModel = "spring", uses = {DictSmallMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDetailMapper extends BaseMapper<DictDetailDto, DictDetail> {

}