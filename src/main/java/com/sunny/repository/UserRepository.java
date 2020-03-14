package com.sunny.repository;

import com.sunny.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 继承JpaRepository来完成对数据库的操作
 *
 * @author chenye
 */
@Repository
public interface UserRepository extends
        JpaRepository<User, Integer> {
}
