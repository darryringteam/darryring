package com.house.service;

import org.apache.ibatis.annotations.Param;

import com.house.pojo.User;

public interface UserService {
	
    //查询用户
	public User findUserByUandP(@Param("userName")String userName,@Param("password")String password);

	//用户注册
	public int regUser(User user);
}
