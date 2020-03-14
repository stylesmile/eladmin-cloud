package com.sunny.service;

import com.sunny.demain.UserDemain;
import com.sunny.entity.User;
import com.sunny.filter.UserFilter;
import com.sunny.repository.UserRepository;
import com.sunny.util.BeanCopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService extends BaseCURDService<UserDemain, User, UserFilter, Integer> {

    @Resource
    UserRepository userRepository;

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.saveAndFlush(user);
    }

    public void getUserListByCondition(UserDemain userDemain) {
        //userRepository.findAll(pa)
    }

    public void update(UserDemain userDemain) throws Exception {
        Integer id = userDemain.getId();
        if (null == id) {
            throw new Exception("id 为空");
        }
        User user = userRepository.getOne(id);
        BeanCopyUtil.beanCopy(userDemain, user);
        userRepository.saveAndFlush(user);
    }


}
