package com.lwzy.blog.service;

import com.lwzy.blog.bean.Category;
import com.lwzy.blog.common.PageVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    List<Category> selectAll();
    PageVO<Category> selectByPage(Map<String,Object> map);
    Category selectById(int id);
    //新增
    public int add(Category category);
    //修改
    public int update(Category category);
    //删除
    public int delete(int id);
}
