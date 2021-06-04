package com.oj.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.oj.DAO.model.User;

import com.oj.DAO.model.UserGroup;
import com.oj.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserServiceImpl userService;



    @RequestMapping(value = "/searchAll")
    public @ResponseBody UserGroup UserAll(){
        UserGroup users= userService.selectAll();
        System.out.println(users.getUsers());
        return users;
    }

    @PostMapping("/addUser")
    public Boolean add(@RequestBody JSONObject jsonParam){
        return  userService.insertUser(jsonParam);
    }

    @PostMapping("/searchUser")
    public List<User> search(@RequestBody JSONObject jsonParam){
        String key=jsonParam.getString("key");
        System.out.println(key+"\n"+"\n"+"\n"+"\n"+"\n");
        return userService.searchUser(key);
    }


    @PostMapping("/searchLoginUser")
    public User selectPassword(@RequestBody User user){
        if(userService.SelectIsUser(user)){
            return userService.searchLoginUser(user.getUserId());
        }
        return null;
    }

    @PostMapping("/updatePassword")
    public void updatePassword(@RequestBody JSONObject jsonParam){
        String userId=jsonParam.getString("userId");
        System.out.println(userId);
            userService.updatePassword(userId);
    }




}
