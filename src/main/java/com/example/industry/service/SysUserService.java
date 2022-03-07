package com.example.industry.service;

import com.example.industry.entity.User.SysUser;

/**
 * @author ：shadow
 * @date ：Created in 2022/3/7 10:10
 */
public interface SysUserService {
    public SysUser selectById(Integer id);

    public SysUser selectByName(String name);
}
