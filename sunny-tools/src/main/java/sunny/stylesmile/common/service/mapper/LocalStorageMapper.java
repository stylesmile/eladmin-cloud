package sunny.stylesmile.common.service.mapper;

import sunny.stylesmile.common.base.BaseMapper;
import sunny.stylesmile.common.service.dto.LocalStorageDto;
import sunny.stylesmile.common.domain.LocalStorage;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Zheng Jie
* @date 2019-09-05
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocalStorageMapper extends BaseMapper<LocalStorageDto, LocalStorage> {

}