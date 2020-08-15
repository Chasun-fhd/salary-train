package com.sts.springboot.repository;

import com.sts.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: haidong.feng
 * @createdAt: 2020/7/18
 * @description:
 **/
public interface UserRepository extends JpaRepository<User, Long> {
}
