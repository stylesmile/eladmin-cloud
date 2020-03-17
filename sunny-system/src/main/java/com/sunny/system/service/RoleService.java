package com.sunny.system.service;

import com.sunny.system.entity.Role;
import com.sunny.system.repository.RoleRepository;
import com.sunny.system.demain.role.RoleDemain;
import com.sunny.system.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenye
 */
@Service
public class RoleService extends BaseCURDService<RoleDemain, Role, String, UserRepository> {

    @Resource
    RoleRepository roleRepository;

    public List<Role> getRoleList() {
        return roleRepository.findAll();
    }
}
