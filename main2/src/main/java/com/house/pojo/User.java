package com.house.pojo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

//用户表
@Setter
@Getter
public class User {

	private Integer uid;

	private String username;

	private String realName;

	private String password;

	private String phone;

	private List<House> hList;

}
