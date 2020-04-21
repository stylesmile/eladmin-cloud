package sunny.stylesmile.common.service.mapper;

import sunny.stylesmile.common.base.BaseMapper;
import sunny.stylesmile.common.domain.Log;
import sunny.stylesmile.common.service.dto.LogSmallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Stylesmile
 * @date 2019-5-22
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogSmallMapper extends BaseMapper<LogSmallDTO, Log> {

}