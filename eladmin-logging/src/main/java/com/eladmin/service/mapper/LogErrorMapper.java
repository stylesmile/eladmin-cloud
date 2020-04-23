package com.eladmin.service.mapper;

import com.eladmin.service.dto.LogErrorDTO;
import com.eladmin.base.BaseMapper;
import com.eladmin.domain.Log;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Zheng Jie
 * @date 2019-5-22
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogErrorMapper extends BaseMapper<LogErrorDTO, Log> {

}