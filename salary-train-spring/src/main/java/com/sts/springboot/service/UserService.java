package com.sts.springboot.service;

import com.sts.springboot.entity.User;
import com.sts.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: haidong.feng
 * @createdAt: 2020/8/15
 * @description:
 **/
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public void create() {
        User user = new User();
        user.setMail("11111@qq.com");
        userRepository.save(user);
        int ret = 1 / 0;
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
}
