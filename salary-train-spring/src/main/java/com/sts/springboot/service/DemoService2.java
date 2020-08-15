package com.sts.springboot.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: haidong.feng
 * @createdAt: 2020/7/16
 * @description:
 **/
@Service
public class DemoService2 implements IDemoService {

    @Resource(name = "demoService1")
    private IDemoService demoService;

    @Override
    public String echo() {
        System.out.println(demoService.echo());
        return "DemoService2";
    }
}
