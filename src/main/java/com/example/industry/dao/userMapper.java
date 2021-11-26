package com.example.industry.dao;

import com.example.industry.entity.User.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import  java.util.List;
@Mapper
public interface userMapper {
    /**
     * 新增用户
     */
    @Insert("INSERT INTO User(id, permission, username, password) VALUES (#{id},#{permission},#{username},#{password})")
    boolean insertuser(user User);

    @Select("SELECT * FROM user WHERE user_id = 1")
    user returnid();

    /**
     *  查询用户是否已存在
     */
    @Select("SELECT * FROM user WHERE id=#{id}AND username=#{username}")
    boolean isExist(String username,String password);

    @Select("SELECT username FROM user WHERE id = #{id}")
    user getusername(int user_id);

    @Select("SELECT password FROM user WHERE id = #{id}")
    user getpassword(int user_id);

}
