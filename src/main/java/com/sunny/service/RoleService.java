package com.sunny.service;

import com.sunny.entity.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService {

    @Resource
    com.sunny.repository.RoleRepository RoleRepository;

    public List<Role> getRoleList() {
        return RoleRepository.findAll();
    }

    public void save(Role role) {
        RoleRepository.save(role);
    }
    public void update(Role role) {
        RoleRepository.saveAndFlush(role);
    }
}
