package sunny.stylesmile.common.modules.mnt.service.mapper;

import sunny.stylesmile.common.base.BaseMapper;
import sunny.stylesmile.common.modules.mnt.domain.ServerDeploy;
import sunny.stylesmile.common.modules.mnt.service.dto.ServerDeployDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author zhanghouying
* @date 2019-08-24
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServerDeployMapper extends BaseMapper<ServerDeployDto, ServerDeploy> {

}
