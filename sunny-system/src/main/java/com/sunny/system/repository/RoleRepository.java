package com.sunny.system.repository;

import com.sunny.system.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 继承JpaRepository来完成对数据库的操作
 *
 * @author chenye
 */
@Repository
public interface RoleRepository extends
        JpaRepository<Role, String> {

}
