package com.sts.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: haidong.feng
 * @createdAt: 2020/7/15
 * @description:
 **/
@RestController
@RequestMapping(path = "/demo")
public class DemoController {

    @GetMapping(path = "/")
    public String hello() {
        return "hello world";
    }
}
