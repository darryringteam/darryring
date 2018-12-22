package com.house.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.house.dao.UserMapper;
import com.house.pojo.User;
import com.house.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	// 用户登录方法
	public User findUserByUandP(@Param("userName") String userName, @Param("password") String password) {

		return userMapper.findUserByUandP(userName, password);
	}

	@Override // 用户注册方法
	public int regUser(User user) {

		return userMapper.regUser(user);
	}
}
