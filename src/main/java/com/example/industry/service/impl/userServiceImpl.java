package com.example.industry.service.impl;

import com.example.industry.dao.*;
import com.example.industry.entity.User.user;
import com.example.industry.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class userServiceImpl implements userService{
    @Autowired
    userMapper userMapper;

    @Override
    public boolean insertuser(user User) {
        return userMapper.insertuser(User);
    }

    @Override
    public boolean isExist(String username, String password) {
        return userMapper.isExist(username,password);
    }

    @Override
    public user returnid(){
        return userMapper.returnid();
    }

    @Override
    public user getusername(int user_id) {
        return userMapper.getusername(user_id);
    }

    @Override
    public user getpassword(int user_id) {
        return userMapper.getpassword(user_id);
    }

}
