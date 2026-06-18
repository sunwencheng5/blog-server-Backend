package com.lwzy.blog.controller;

import com.lwzy.blog.bean.Blog;
import com.lwzy.blog.bean.Category;
import com.lwzy.blog.common.Result;
import com.lwzy.blog.common.PageVO;
import com.lwzy.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController //相当于@Controller+@ResponseBody,所有方法都默认返回数据
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/all")
    public Result selectAll(){
        List<Category> list=categoryService.selectAll();
        return Result.success(list);
    }

    @GetMapping
    //@RequestParam接收请求路径？后面的参数值，
    //例：localhost:8080/上下文名称/category?pageSize=5&pageNum=2
    public Result page(@RequestParam Map<String,Object> map){
        PageVO pageVO=categoryService.selectByPage(map);
        return Result.success(pageVO);
    }

    @GetMapping(value = "/{id}")
    public Result selectById(@PathVariable(value="id") int id){
        Category c=categoryService.selectById(id);
        return Result.success(c);
    }

    //新增
    @PostMapping
    public Result add(@RequestBody Category category){
        int count=categoryService.add(category);
        return count>0?Result.success(null):Result.error("添加失败");
    }
    //更新
    @PutMapping
    public Result update(@RequestBody Category category){
        int count=categoryService.update(category);
        return count>0?Result.success(null):Result.error("更新失败");
    }

    //删除
    @DeleteMapping(value = "/{id}")
    public Result update(@PathVariable(value="id") int id){
        int count=categoryService.delete(id);
        return count>0?Result.success(null):Result.error("删除失败");
    }
}

