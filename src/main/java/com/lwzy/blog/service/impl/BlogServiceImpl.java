package com.lwzy.blog.service.impl;

import com.lwzy.blog.bean.Blog;
import com.lwzy.blog.common.PageVO;
import com.lwzy.blog.mapper.BlogMapper;
import com.lwzy.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;

    @Override
    public PageVO selectByPage(Map<String, Object> map) {
        int start=0;//起始索引
        int limit=0;//查询条数
        if(map.containsKey("pageSize")){
            limit=Integer.parseInt(map.get("pageSize").toString());//从参数中取出查询条数
        }
        if(map.containsKey("pageNum")){
            int pNum=Integer.parseInt(map.get("pageNum").toString());//从参数中取出页码
            start=limit*(pNum-1);//计算出起始索引
        }
        //从map中删除pageSize,pageNum
        map.remove("pageSize");
        map.remove("pageNum");
        //往map中存入start和limit
        map.put("start",start);
        map.put("limit",limit);
        //查询分页数据
        List<Blog> list=blogMapper.selectByPage(map);
        //查询总数
        int total=blogMapper.selectTotal(map);
        return new PageVO(list,total);
    }
    @Override
    public Blog selectById(int id) {
        return blogMapper.selectById(id);
    }

    @Override
    public List<Blog> selectTop(int num) {
        return blogMapper.selectTop(num);
    }

    @Override
    public int add(Blog blog) {
        return blogMapper.add(blog);
    }

    @Override
    public int update(Blog blog) {
        return blogMapper.update(blog);
    }

    @Override
    public int delete(int id) {
        return blogMapper.delete(id);
    }
}
