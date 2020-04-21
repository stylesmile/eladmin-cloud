package com.stylesmile.console.modules.system.service.mapper;

import com.stylesmile.console.modules.system.domain.Job;
import com.stylesmile.console.modules.system.service.dto.JobSmallDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import sunny.stylesmile.common.base.BaseMapper;

/**
* @author Stylesmile
* @date 2019-03-29
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobSmallMapper extends BaseMapper<JobSmallDto, Job> {

}