package com.oj.service;

import com.alibaba.fastjson.JSONObject;
import com.oj.DAO.model.User;
import com.oj.DAO.model.UserGroup;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    Boolean SelectIsUser(User user);

    UserGroup selectAll();

    Boolean insertUser(JSONObject jsonParam);

    List<User> searchUser(String key);

    void updatePassword(String userId);

    User searchLoginUser(String userId);
}
