package com.sts.springboot.repository;

import com.sts.springboot.entity.Order;
import com.sts.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: haidong.feng
 * @createdAt: 2020/7/18
 * @description:
 **/
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByOrderNo(String orderNo);
}
