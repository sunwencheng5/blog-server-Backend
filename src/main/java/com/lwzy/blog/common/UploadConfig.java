package com.lwzy.blog.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
//@ConfigurationProperties的作用：
//将配置文件（application.yml）中的属性值批量绑定到 Java 对象中。（支持驼峰转短横线）
@ConfigurationProperties(prefix = "upload") //对应 yml 中的 upload
public class UploadConfig {
    private String localPath; // 对应 local-path
    private String accessPrefix;// 对应 access-prefix
    private List<String> allowedTypes;// 对应 allowed-types
    private Integer maxSize;// 对应 max-size
}

