package com.lwzy.blog.service.impl;

import com.lwzy.blog.bean.Blog;
import com.lwzy.blog.bean.Category;
import com.lwzy.blog.common.PageVO;
import com.lwzy.blog.mapper.CategoryMapper;
import com.lwzy.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper catMapper;

    @Override
    public List<Category> selectAll() {
        return catMapper.selectAll();
    }

    @Override
    public PageVO<Category> selectByPage(Map<String, Object> map) {
        int start=0;//起始索引
        int limit=0;//查询条数
        if(map.containsKey("pageSize")){
            limit=Integer.parseInt(map.get("pageSize").toString());//从参数中得到查询条数
        }
        if(map.containsKey("pageNum")){
            int pageNum=Integer.parseInt(map.get("pageNum").toString());//从参数中得到页码
            start=limit*(pageNum-1);//计算得到起始索引
        }
        //从map中移除pageSize和pageNum
        map.remove("pageSize");
        map.remove("pageNum");
        //往map中加入start和limit参数
        map.put("start",start);
        map.put("limit",limit);
        //调用mapper中的方法得到该页数据
        List<Category> list=catMapper.selectByPage(map);
        //得到总条数
        int total=catMapper.selectTotal(map);
        //封装数据
        return new PageVO<Category>(list,total);
    }

    @Override
    public Category selectById(int id) {
        return catMapper.selectById(id);
    }
    @Override
    public int add(Category category) {
        return catMapper.add(category);
    }

    @Override
    public int update(Category category) {
        return catMapper.update(category);
    }

    @Override
    public int delete(int id) {
        return catMapper.delete(id);
    }
}
