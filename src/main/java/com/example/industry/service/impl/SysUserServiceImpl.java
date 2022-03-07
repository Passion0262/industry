package com.example.industry.service.impl;

import com.example.industry.dao.SysUserMapper;
import com.example.industry.entity.User.SysUser;
import com.example.industry.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：shadow
 * @date ：Created in 2022/3/7 10:10
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper userMapper;

    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }
}
