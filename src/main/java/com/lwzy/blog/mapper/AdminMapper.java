package com.lwzy.blog.mapper;

import com.lwzy.blog.bean.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    Admin selectByUserNameAndPwd(Admin admin);//根据用户名和密码查询用户
    Admin selectById(int id);//根据id查询用户
    int update(Admin admin);//更新用户
}
