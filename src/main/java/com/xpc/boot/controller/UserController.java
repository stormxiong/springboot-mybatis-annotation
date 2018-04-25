package com.xpc.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.xpc.boot.entity.User;
import com.xpc.boot.mapper.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/all")
    public JSONObject findAll(){
        List<User> userList = userDAO.findAll();
        JSONObject json =new JSONObject();
        json.put("data",userList);
        return json;
    }

    @RequestMapping("/add")
    public void addOne(User user){
        userDAO.addOne(user);
    }

    @RequestMapping("/update")
    public JSONObject update(User user){
        userDAO.update(user);
        JSONObject json =new JSONObject();
        json.put("data",user);
        return json;
    }

    @RequestMapping("/find")
    public JSONObject findOne(int id){
        User user = userDAO.findOne(id);
        JSONObject json =new JSONObject();
        json.put("data",user);
        return json;
    }

    @RequestMapping("/del")
    public void delOne(int id){
        userDAO.delOne(id);
    }
} 
