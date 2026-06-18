package com.lwzy.blog.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//封装返回结果
public class Result<T> {
    private Integer code; //状态码
    private String message; //消息
    private T data; //数据

    // 成功：只传数据（自动补全code和message）
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    // 失败：只传错误信息（自动补全code=500）
    public static <T> Result<T> error(String message) {
        return new Result<>(500, message, null);
    }
}
