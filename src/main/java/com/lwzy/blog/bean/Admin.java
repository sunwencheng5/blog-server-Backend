package com.lwzy.blog.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private String sign;
    private String create_time;
    private String update_time;
}
