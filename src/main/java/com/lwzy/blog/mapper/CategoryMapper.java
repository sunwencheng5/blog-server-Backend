package com.lwzy.blog.mapper;

import com.lwzy.blog.bean.Blog;
import com.lwzy.blog.bean.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CategoryMapper {
    List<Category> selectAll();
    List<Category> selectByPage(Map<String,Object> map);
    int selectTotal(Map<String,Object> map);
    Category selectById(int id);
    //新增
    public int add(Category category);
    //修改
    public int update(Category category);
    //删除
    public int delete(int id);
}
