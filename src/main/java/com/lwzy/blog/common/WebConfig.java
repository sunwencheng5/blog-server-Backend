package com.lwzy.blog.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private UploadConfig uploadConfig;//上传配置


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将/uploads/**请求映射到本地上传目录D:/uploads/blog/
        //使本地目录下的文件可以通过 HTTP请求访问
        //实际效果：
        //访问 http://localhost:8080/blog-server-1/uploads/avatar.jpg
        //对应本地文件 D:/uploads/blog/avatar.jpg
        registry.addResourceHandler(uploadConfig.getAccessPrefix() + "**")
                .addResourceLocations("file:" + uploadConfig.getLocalPath());
    }
}

