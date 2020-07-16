package com.sts.springboot.service;

/**
 * @author: haidong.feng
 * @createdAt: 2020/7/16
 * @description:
 **/
public class DemoServiceContext implements IDemoService{

    private IDemoService demoService;

    public DemoServiceContext(IDemoService demoService) {
        this.demoService = demoService;
    }


    @Override
    public String echo() {
        return this.demoService.echo();
    }
}
