package com.weixf.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "misc")
public class XmlUser {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
