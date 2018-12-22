package com.house.dao;

import org.apache.ibatis.annotations.Param;

import com.house.pojo.User;

public interface UserMapper {
	
	//判断登录
	public User findUserByUandP(@Param("userName")String userName,@Param("password")String password);

	//用户注册
	public int regUser(User user);
}
