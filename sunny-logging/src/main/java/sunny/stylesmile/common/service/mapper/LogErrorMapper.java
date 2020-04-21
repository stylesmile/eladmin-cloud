package sunny.stylesmile.common.service.mapper;

import sunny.stylesmile.common.base.BaseMapper;
import sunny.stylesmile.common.domain.Log;
import sunny.stylesmile.common.service.dto.LogErrorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Zheng Jie
 * @date 2019-5-22
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogErrorMapper extends BaseMapper<LogErrorDTO, Log> {

}