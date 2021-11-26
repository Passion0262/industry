package com.example.industry.service;

import com.example.industry.entity.User.user;
import java.util.List;

public interface userService {

    boolean insertuser(user User);

    boolean isExist(String username,String password);

    user returnid();
    user getusername(int user_id);
    user getpassword(int user_id);

}
