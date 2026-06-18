package com.lwzy.blog.common;

import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

//文件上传工具类
@Component
public class FileUploadUtil {

    @Autowired
    private UploadConfig uploadConfig;

    /**
     * 上传图片
     * @return 访问路径
     */
    public String uploadImage(MultipartFile file) throws IOException {
        // 1. 校验文件是否为空
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("文件不能为空");
        }

        // 2. 校验文件类型
        String contentType = file.getContentType();
        if (!uploadConfig.getAllowedTypes().contains(contentType)) {
            throw new IllegalArgumentException("不支持的文件类型");
        }

        // 3. 校验文件大小
        long maxSize = uploadConfig.getMaxSize() * 1024 * 1024;
        if (file.getSize() > maxSize) {
            throw new IllegalArgumentException("文件不能超过" + uploadConfig.getMaxSize() + "MB");
        }

        // 4. 生成文件名
        String originalName = file.getOriginalFilename(); //获取文件名
        String extension = originalName.substring(originalName.lastIndexOf("."));//获取扩展名
        //生成32位的永不重复的随机字符串，用作新的文件名,例：e3b0c4425dfbe41f934a2f13ada120.jpg
        String newFileName = IdUtil.fastSimpleUUID() + extension;

        // 5. 创建目录:D:/uploads/blog/
        String absolutePath = uploadConfig.getLocalPath() + newFileName;
        File destFile = new File(absolutePath);
        if (!destFile.getParentFile().exists()) {
            destFile.getParentFile().mkdirs();
        }

        // 6. 上传文件到以上目录
        file.transferTo(destFile);

        // 7. 返回访问路径:/uploads/文件名
        return uploadConfig.getAccessPrefix() + newFileName;
    }
}
