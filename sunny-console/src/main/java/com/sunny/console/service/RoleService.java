package com.sunny.console.service;

import com.sunny.console.entity.Role;
import com.sunny.console.repository.RoleRepository;
import com.sunny.console.demain.role.RoleDemain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenye
 */
@Service
public class RoleService extends BaseCURDService<RoleDemain, Role, String> {

    @Resource
    RoleRepository roleRepository;

    public List<Role> getRoleList() {
        return roleRepository.findAll();
    }
}
