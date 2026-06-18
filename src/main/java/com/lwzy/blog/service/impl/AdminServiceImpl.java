package com.lwzy.blog.service.impl;

import com.lwzy.blog.bean.Admin;
import com.lwzy.blog.bean.Blog;
import com.lwzy.blog.mapper.AdminMapper;
import com.lwzy.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin selectByUserNameAndPwd(Admin admin) {
        return adminMapper.selectByUserNameAndPwd(admin);
    }

    @Override
    public Admin selectById(int id) {
        return adminMapper.selectById(id);
    }
    @Override
    public int update(Admin admin) {
        return adminMapper.update(admin);
    }
}
