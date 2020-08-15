package com.sts.springboot.controller;

import com.sts.springboot.entity.Order;
import com.sts.springboot.entity.User;
import com.sts.springboot.service.DemoServiceContext;
import com.sts.springboot.service.IDemoService;
import com.sts.springboot.service.OrderService;
import com.sts.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: haidong.feng
 * @createdAt: 2020/7/15
 * @description:
 **/
@RestController
@RequestMapping(path = "/demo")
public class DemoController {

    @Resource(name = "demoService1")
    private IDemoService demoService;
    @Resource(name = "demoService2")
    private IDemoService demoService2;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @GetMapping(path = "/{type}")
    public String hello(@PathVariable("type") Integer type) {
        if (type == 1) {
            return new DemoServiceContext(demoService).echo();
        } else {
            return new DemoServiceContext(demoService2).echo();
        }
    }

    @GetMapping(path = "/create")
    public boolean create() {
        orderService.create();
        return true;
    }

    @GetMapping(path = "/query/{orderNo}")
    public List<Order> queryOrder(@PathVariable("orderNo") String orderNo) {
        return orderService.findByOrderNo(orderNo);
    }

    @GetMapping(path = "/user/query/{id}")
    public User queryUser(@PathVariable("id") Long id) {
        return userService.findById(id);
    }
}
