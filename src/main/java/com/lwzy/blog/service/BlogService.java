package com.lwzy.blog.service;

import com.lwzy.blog.bean.Blog;
import com.lwzy.blog.common.PageVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

public interface BlogService {
    //map中存放pageSize和pageNum
    PageVO selectByPage(Map<String,Object> map);
    //根据id查询
    public Blog selectById(int id);
    //查询点击量top n
    public List<Blog> selectTop(int num);
    //新增
    public int add(Blog blog);
    //修改
    public int update(Blog blog);
    //删除
    public int delete(int id);
}
