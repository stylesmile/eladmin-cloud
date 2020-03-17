package com.sunny.system.demain.user;

import com.sunny.system.common.aop.annotation.JpaQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chenye
 * @date 2020-0315
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserQuery implements Serializable {


    @JpaQuery(type = JpaQuery.Type.INNER_LIKE)
    @ApiModelProperty(value = "id", example = "1231", dataType = "String")
    private String id;

    @JpaQuery(type = JpaQuery.Type.INNER_LIKE)
    @ApiModelProperty(value = "名称", example = "1231", dataType = "String")
    private String userName;

    @JpaQuery(type = JpaQuery.Type.INNER_LIKE)
    @ApiModelProperty(value = "邮箱", example = "sdf", dataType = "String")
    private String email;

}
