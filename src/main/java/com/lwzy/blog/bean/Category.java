package com.lwzy.blog.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private int id;
    private String category_name;
    private String remark;
    private String create_time;
    private String update_time;
}
