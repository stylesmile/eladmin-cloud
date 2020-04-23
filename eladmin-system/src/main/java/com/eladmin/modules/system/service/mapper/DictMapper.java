package com.eladmin.modules.system.service.mapper;

import com.eladmin.base.BaseMapper;
import com.eladmin.modules.system.domain.Dict;
import com.eladmin.modules.system.service.dto.DictDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Zheng Jie
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictMapper extends BaseMapper<DictDto, Dict> {

}