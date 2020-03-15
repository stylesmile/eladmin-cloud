package com.sunny.system.demain.user;

import com.sunny.common.constant.RegexpConst;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreate {

    @NotNull(message = "用户名不能为空")
    @Size(min = 6, max = 20, message = "用户名长度应该在6-20个字符之间")
    @Pattern(regexp = RegexpConst.PASSWD_REGEXP, message = "密码长度为6-20位，必须且只能包含数字和字母")
    @ApiModelProperty(value = "用户名", example = "zhagnsan", dataType = "String")
    private String name;


    @NotNull(message = "年龄不能为空")
    @Size(min = 6, max = 20, message = "密码长度应该在6-20个字符之间")
    @ApiModelProperty(value = "年龄", example = "11", dataType = "Integer")
    private String password;

}
