package com.sts.springboot.entity;

import javax.persistence.Entity;

/**
 * @author: haidong.feng
 * @createdAt: 2020/8/15
 * @description:
 **/
@Entity(name = "t_order")
public class Order extends AbstractEntity{

    private String orderNo;


    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
