package com.stylesmile.console.modules.mnt.service.mapper;

import com.stylesmile.console.modules.mnt.domain.Database;
import com.stylesmile.console.modules.mnt.service.dto.DatabaseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import sunny.stylesmile.common.base.BaseMapper;


/**
* @author zhanghouying
* @date 2019-08-24
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DatabaseMapper extends BaseMapper<DatabaseDto, Database> {

}
