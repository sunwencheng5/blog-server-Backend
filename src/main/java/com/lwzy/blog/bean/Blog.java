package com.lwzy.blog.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private int id;
    private String title;
    private Category category;
    private String summary;
    private String photo;
    private String content;
    private int click_num;
    private String create_time;
    private String update_time;
}
