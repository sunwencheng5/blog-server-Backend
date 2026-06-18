package com.lwzy.blog.controller;

import com.lwzy.blog.bean.Admin;
import com.lwzy.blog.bean.Category;
import com.lwzy.blog.common.Result;
import com.lwzy.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController //相当于@Controller+@ResponseBody，所有方法默认返回数据
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/login")
    public Result login(@RequestBody Admin admin){
        Admin a=adminService.selectByUserNameAndPwd(admin);
        if(a==null){
            return Result.error("用户不存在");
        }else{
            return Result.success(a);
        }
    }

    //请求路径的形式是：localhost:8080/上下文路径/admin/12
    //@PathVariable的作用：接收请求路径中占位符的值
    @GetMapping(value = "/{id}")
    public Result selectById(@PathVariable(value="id") int id){
        Admin a=adminService.selectById(id);
        return Result.success(a);
    }

    //更新
    @PutMapping
    public Result update(@RequestBody Admin admin){
        int count=adminService.update(admin);
        return count>0?Result.success(null):Result.error("更新失败");
    }
}
