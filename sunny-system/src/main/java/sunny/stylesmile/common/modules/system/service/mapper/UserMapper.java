package sunny.stylesmile.common.modules.system.service.mapper;

import sunny.stylesmile.common.base.BaseMapper;
import sunny.stylesmile.common.modules.system.domain.User;
import sunny.stylesmile.common.modules.system.service.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * @author Zheng Jie
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring",uses = {RoleMapper.class, DeptMapper.class, JobMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<UserDto, User> {

    /**
     * 转换
     * @param user 原始数据
     * @return /
     */
    @Override
    @Mapping(source = "user.userAvatar.realName",target = "avatar")
    UserDto toDto(User user);
}
