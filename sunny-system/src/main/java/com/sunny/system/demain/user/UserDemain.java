package com.sunny.system.demain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenye
 * @date 2020-0316
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDemain {

    private String id;
    private String name;
    private String email;

}
