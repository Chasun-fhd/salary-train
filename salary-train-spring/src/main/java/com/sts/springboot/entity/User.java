package com.sts.springboot.entity;

import javax.persistence.Entity;

/**
 * @author: haidong.feng
 * @createdAt: 2020/7/18
 * @description:
 **/
@Entity(name = "t_user")
public class User extends AbstractEntity {

    private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
