package com.stylesmile.console.modules.system.service.mapper;

import com.stylesmile.console.modules.system.domain.Menu;
import sunny.stylesmile.common.base.BaseMapper;
import com.stylesmile.console.modules.system.service.dto.MenuDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Stylesmile
 * @date 2018-12-17
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper extends BaseMapper<MenuDto, Menu> {

}
