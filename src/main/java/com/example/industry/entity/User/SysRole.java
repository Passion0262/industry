package com.example.industry.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：shadow
 * @date ：Created in 2022/3/7 10:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRole implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    // 省略getter/setter
}

