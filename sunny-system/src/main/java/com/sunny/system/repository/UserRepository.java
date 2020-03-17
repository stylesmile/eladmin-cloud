package com.sunny.system.repository;

import com.sunny.system.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 继承JpaRepository来完成对数据库的操作
 *
 * @author chenye
 */
@Repository
public interface UserRepository extends
        BaseJpaRepository<User, String> {
    /**
     * 通过名称获取用户
     *
     * @param userName 名称
     * @return User
     */
    User getUserByUserName(@Param("userName") String userName);

    /**
     * 通过名称模糊查询用户
     *
     * @param userName     条件
     * @param pageable 页码
     * @return Page
     */
    Page<User> getUserByUserNameLike(String userName, Pageable pageable);
}
