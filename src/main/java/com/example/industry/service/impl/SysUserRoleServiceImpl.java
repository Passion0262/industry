package com.example.industry.service.impl;

import com.example.industry.dao.SysUserRoleMapper;
import com.example.industry.entity.User.SysUserRole;
import com.example.industry.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：shadow
 * @date ：Created in 2022/3/7 10:14
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    private SysUserRoleMapper userRoleMapper;

    public List<SysUserRole> listByUserId(Integer userId) {
        return userRoleMapper.listByUserId(userId);
    }
}
