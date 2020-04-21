package sunny.stylesmile.common.modules.mnt.service.mapper;

import sunny.stylesmile.common.base.BaseMapper;
import sunny.stylesmile.common.modules.mnt.domain.Database;
import sunny.stylesmile.common.modules.mnt.service.dto.DatabaseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author zhanghouying
* @date 2019-08-24
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DatabaseMapper extends BaseMapper<DatabaseDto, Database> {

}
