package com.example.industry.service;

import com.example.industry.dao.SysRoleMapper;
import com.example.industry.entity.User.SysRole;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：shadow
 * @date ：Created in 2022/3/7 10:12
 */
public interface SysRoleService {

    public SysRole selectById(Integer id);

}
