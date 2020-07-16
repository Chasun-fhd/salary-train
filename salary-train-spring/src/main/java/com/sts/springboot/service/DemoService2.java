package com.sts.springboot.service;

import org.springframework.stereotype.Service;

/**
 * @author: haidong.feng
 * @createdAt: 2020/7/16
 * @description:
 **/
@Service
public class DemoService2 implements IDemoService {

    @Override
    public String echo() {
        return "DemoService2";
    }
}
