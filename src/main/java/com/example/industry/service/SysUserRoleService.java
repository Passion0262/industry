package com.example.industry.service;

import com.example.industry.dao.SysUserRoleMapper;
import com.example.industry.entity.User.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ：shadow
 * @date ：Created in 2022/3/7 10:13
 */
public interface SysUserRoleService {

    public List<SysUserRole> listByUserId(Integer userId);
}

