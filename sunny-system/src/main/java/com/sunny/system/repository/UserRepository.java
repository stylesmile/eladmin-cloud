package com.sunny.system.repository;

import com.sunny.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 继承JpaRepository来完成对数据库的操作
 *
 * @author chenye
 */
@Repository
public interface UserRepository extends
        JpaRepository<User, String> {
    User getUserByName(@Param("name") String name);
}
