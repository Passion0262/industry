package com.example.industry.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：shadow
 * @date ：Created in 2022/3/7 10:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private String password;

}
