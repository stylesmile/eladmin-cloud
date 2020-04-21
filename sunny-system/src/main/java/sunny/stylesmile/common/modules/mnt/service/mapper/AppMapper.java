package sunny.stylesmile.common.modules.mnt.service.mapper;

import sunny.stylesmile.common.base.BaseMapper;
import sunny.stylesmile.common.modules.mnt.domain.App;
import sunny.stylesmile.common.modules.mnt.service.dto.AppDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author zhanghouying
* @date 2019-08-24
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppMapper extends BaseMapper<AppDto, App> {

}
