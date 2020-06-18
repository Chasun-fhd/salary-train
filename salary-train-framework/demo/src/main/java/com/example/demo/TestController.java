package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: haidong.feng
 * @createdAt: 2020/6/18
 * @description:
 **/
@RestController
@RequestMapping(path = "/test")
public class TestController {

    @GetMapping(path = "/hello")
    @Intercept
    public String hello(@RequestParam("age") String age,
                        @RequestParam("name") @CacheKey(name = "name") String name) {
        return name;
    }
}
