package com.example.industry.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class user {
    private int user_id;
    private String accesslevel;
    private String username;
    private String password;
//    private long id;
//    private String permission;
//    private String username;
//    private String password;
//    public void person(long id,String permission,String username,String password){
//        this.id = id;
//        this.permission = permission;
//        this.username = username;
//        this.password = password;
//    }
}
