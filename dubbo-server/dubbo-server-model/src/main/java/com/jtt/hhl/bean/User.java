package com.jtt.hhl.bean;

import lombok.Data;

/**
 * @Description: java类作用描述
 * @Author: Herman
 * @CreateDate: 2019/1/30 16:58
 */
@Data
public class User {
    private Long id;
    private String userName;

    public User(Long id, String s) {
        this.id=id;
        this.userName=s;
    }
}
