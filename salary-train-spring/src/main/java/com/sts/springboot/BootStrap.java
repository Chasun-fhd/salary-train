package com.sts.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author: haidong.feng
 * @createdAt: 2020/7/15
 * @description:
 **/
@SpringBootApplication
public class BootStrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(BootStrap.class).run(args);
    }
}
