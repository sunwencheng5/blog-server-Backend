package com.lwzy.blog.controller;

import com.lwzy.blog.bean.Blog;
import com.lwzy.blog.common.FileUploadUtil;
import com.lwzy.blog.common.PageVO;
import com.lwzy.blog.common.Result;
import com.lwzy.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    FileUploadUtil fileUploadUtil;

    //分页查询博客数据
    //请求路径的形式是：localhost:8080/上下文路径/blog?pageSize=5&pageNum=2
    //@RequestParam作用：接收请求参数值(路径中?后面的参数)
    @GetMapping
    public Result page(@RequestParam Map<String,Object> map){
        PageVO pageVO=blogService.selectByPage(map);
        return Result.success(pageVO);
    }

    @GetMapping(value = "/{id}")
    public Result selectById(@PathVariable(value="id") int id){
        Blog b=blogService.selectById(id);
        //更新点击次数：点击次数+1
        b.setClick_num(b.getClick_num()+1);
        blogService.update(b);
        return Result.success(b);
    }

    @GetMapping(value = "/hot/{num}")
    public Result selectTop(@PathVariable(value="num") int num){
        List<Blog> list=blogService.selectTop(num);
        return Result.success(list);
    }

    //新增
    @PostMapping
    public Result add(@RequestBody Blog blog){
        int count=blogService.add(blog);
        return count>0?Result.success(null):Result.error("添加失败");
    }
    //更新
    @PutMapping
    public Result update(@RequestBody Blog blog){
        int count=blogService.update(blog);
        return count>0?Result.success(null):Result.error("更新失败");
    }

    //删除
    @DeleteMapping(value = "/{id}")
    public Result update(@PathVariable(value="id") int id){
        int count=blogService.delete(id);
        return count>0?Result.success(null):Result.error("删除失败");
    }

    //上传文件
    @PostMapping(value="upload")
    public Result uploadFile(@RequestParam("file") MultipartFile file) {
        try{
            //上传文件，并获取文件访问路径
            String url = fileUploadUtil.uploadImage(file);
            // 返回文件上传成功相关信息
            Map<String, String> result = new HashMap<>();
            result.put("url", url);//文件访问路径
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("文件上传失败: " + e.getMessage());
        }
    }

}

