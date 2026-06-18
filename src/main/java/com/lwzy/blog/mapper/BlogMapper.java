package com.lwzy.blog.mapper;

import com.lwzy.blog.bean.Blog;
import com.lwzy.blog.bean.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BlogMapper {
    //map中存放起始索引（start），查询条数（limit）
    List<Blog>  selectByPage(Map<String,Object> map);
    //查询总数
    int selectTotal(Map<String,Object> map);
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
