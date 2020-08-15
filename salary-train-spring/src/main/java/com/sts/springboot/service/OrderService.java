package com.sts.springboot.service;

import com.sts.springboot.entity.Order;
import com.sts.springboot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: haidong.feng
 * @createdAt: 2020/8/15
 * @description:
 **/
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserService userService;

    @Transactional(rollbackFor = Exception.class)
    public Order create() {
        Order order = new Order();
        order.setOrderNo("o1");
        orderRepository.save(order);
//        int ret = 1 / 0;
//        userService.create();
        this.create2();
        return order;
    }

//    @Transactional(rollbackFor = Exception.class)
    public void create2() {
        Order order = new Order();
        order.setOrderNo("o2");
        orderRepository.save(order);
        int ret = 1/0;
    }

    public List<Order> findByOrderNo(String orderNo) {
        return orderRepository.findByOrderNo(orderNo);
    }
}
