package com.eladmin.modules.mnt.service.mapper;

import com.eladmin.base.BaseMapper;
import com.eladmin.modules.mnt.domain.Database;
import com.eladmin.modules.mnt.service.dto.DatabaseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author zhanghouying
* @date 2019-08-24
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DatabaseMapper extends BaseMapper<DatabaseDto, Database> {

}
