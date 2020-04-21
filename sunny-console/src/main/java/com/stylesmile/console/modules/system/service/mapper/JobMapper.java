package com.stylesmile.console.modules.system.service.mapper;

import com.stylesmile.console.modules.system.domain.Job;
import com.stylesmile.console.modules.system.service.dto.JobDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import sunny.stylesmile.common.base.BaseMapper;

/**
* @author Stylesmile
* @date 2019-03-29
*/
@Mapper(componentModel = "spring",uses = {DeptMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobMapper extends BaseMapper<JobDto, Job> {

    /**
     * 转Dto
     * @param job 原始数据
     * @param deptSuperiorName /
     * @return /
     */
    @Mapping(source = "deptSuperiorName", target = "deptSuperiorName")
    JobDto toDto(Job job, String deptSuperiorName);
}