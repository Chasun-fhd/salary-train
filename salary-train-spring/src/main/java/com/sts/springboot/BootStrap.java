package com.sts.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author: haidong.feng
 * @createdAt: 2020/7/15
 * @description:
 **/
@SpringBootApplication
@EnableWebMvc
@EnableJpaRepositories
public class BootStrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(BootStrap.class).run(args);
    }
}
