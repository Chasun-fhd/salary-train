package com.sts.springboot.controller;

import com.sts.springboot.service.DemoServiceContext;
import com.sts.springboot.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @GetMapping(path = "/{type}")
    public String hello(@PathVariable("type") Integer type) {
        if (type == 1) {
            return new DemoServiceContext(demoService).echo();
        } else {
            return new DemoServiceContext(demoService2).echo();
        }
    }
}
