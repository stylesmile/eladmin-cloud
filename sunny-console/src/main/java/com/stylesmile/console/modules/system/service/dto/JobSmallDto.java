package com.stylesmile.console.modules.system.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
* @author Stylesmile
* @date 2019-6-10 16:32:18
*/
@Data
@NoArgsConstructor
public class JobSmallDto implements Serializable {

    private Long id;

    private String name;
}