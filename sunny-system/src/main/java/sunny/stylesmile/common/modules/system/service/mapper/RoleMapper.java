package sunny.stylesmile.common.modules.system.service.mapper;

import sunny.stylesmile.common.base.BaseMapper;
import sunny.stylesmile.common.modules.system.domain.Role;
import sunny.stylesmile.common.modules.system.service.dto.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Zheng Jie
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring", uses = {MenuMapper.class, DeptMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends BaseMapper<RoleDto, Role> {

}
