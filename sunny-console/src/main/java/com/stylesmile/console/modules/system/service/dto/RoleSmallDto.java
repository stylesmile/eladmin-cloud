package com.stylesmile.console.modules.system.service.dto;

import lombok.Data;
import java.io.Serializable;

/**
 * @author Stylesmile
 * @date 2018-11-23
 */
@Data
public class RoleSmallDto implements Serializable {

    private Long id;

    private String name;

    private Integer level;

    private String dataScope;
}
