package com.sunny.console.repository;

import com.sunny.console.entity.User;
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
        JpaRepository<User, Integer> {
    User getUserByName(@Param("name") String name);
}
