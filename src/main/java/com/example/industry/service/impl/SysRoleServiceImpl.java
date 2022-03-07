package com.example.industry.service.impl;

import com.example.industry.dao.SysRoleMapper;
import com.example.industry.entity.User.SysRole;
import com.example.industry.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：shadow
 * @date ：Created in 2022/3/7 10:12
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;

    public SysRole selectById(Integer id){
        return roleMapper.selectById(id);
    }
}

