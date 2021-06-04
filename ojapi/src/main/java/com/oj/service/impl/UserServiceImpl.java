package com.oj.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.oj.DAO.UserMapper;
import com.oj.DAO.model.User;
import com.oj.DAO.model.UserGroup;
import com.oj.DAO.model.Users;
import com.oj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;



    @Override
    public Boolean SelectIsUser(User user) {
        Integer count= userMapper.selectIsUser(user);
        System.out.println(count);
        if(count>0)
            return true;
        else
            return false;
    }

    @Override
    public UserGroup selectAll() {
       System.out.println(userMapper.selectAll());
       UserGroup userGroup =new UserGroup();
       userGroup.setUsers(userMapper.selectAll());
       return userGroup;
    }

    @Override
    public Boolean insertUser(JSONObject jsonParam) {
        System.out.println(jsonParam);
        User user= JSON.toJavaObject(jsonParam,User.class);
        System.out.println(user.toString());
        String nick=jsonParam.getString("name");
        Users users=new Users();
        Date d = new Date();
        Timestamp date =new Timestamp(d.getTime());
        users.setUserId(user.getUserId());
        users.setRegTime(date);
        users.setNick(nick);
        users.setAccesstime(date);
        users.setPassword(user.getPassword());
        System.out.println(user.toString());
        System.out.println(users);
        System.out.println(userMapper.selectId(user.getUserId()));
        if(userMapper.selectId(user.getUserId())!=0){
            return false;
       }else {
                userMapper.insertUsers(users);
             userMapper.insertUser(user);
          return true;
      }
    }

    @Override
    public List<User> searchUser(String key) {
        List<User> users=new ArrayList<>();
        if(key.equals("")){
          //  users=selectAll();
        }
        else {
            users =userMapper.selectUser(key);
        }

        return users;
    }

    @Override
    public void updatePassword(String userId) {
        userMapper.updatePassword(userId);
    }

    @Override
    public User searchLoginUser(String userId) {

        return userMapper.selectLoginUser(userId);
    }
}
