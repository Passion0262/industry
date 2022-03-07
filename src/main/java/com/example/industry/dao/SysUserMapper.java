package com.example.industry.dao;

import com.example.industry.entity.User.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author ：shadow
 * @date ：Created in 2022/3/7 10:03
 */
@Mapper
public interface SysUserMapper {
    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    SysUser selectById(Integer id);

    @Select("SELECT * FROM sys_user WHERE username = #{username}")
    SysUser selectByName(String username);
}
