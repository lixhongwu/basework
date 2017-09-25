package com.lzw.sb.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.baomidou.mybatisplus.annotations.TableName;
@TableName("t_user")
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

}