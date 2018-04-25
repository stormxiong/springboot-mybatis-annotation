package com.xpc.boot.mapper;

import com.xpc.boot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDAO {

    @Select("SELECT * FROM user")
    @Results({
            @Result(column = "user_name",property = "userName")
    })
    List<User> findAll();

    @Insert("INSERT INTO user(userName,password,authority,phone) VALUES (#{userName},#{password},#{authority},#{phone})")
    @Results({
            @Result(column = "user_name",property = "userName")
    })
    void addOne(User user);

    @Update("UPDATE user SET userName=#{userName},password=#{password},authority=#{authority},phone=#{phone} where id=#{id}")
    @Results({
            @Result(column = "user_name",property = "userName")
    })
    void update(User user);

    @Select("SELECT * FROM user WHERE id=#{id}")
    User findOne(int id);

    @Delete("DELETE FROM user WHERE id=#{id}")
    void delOne(int id);
} 
