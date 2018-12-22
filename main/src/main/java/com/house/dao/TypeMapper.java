package com.house.dao;

import java.util.List;

import com.house.pojo.Type;

public interface TypeMapper {
   
    //查询房屋所有类型
	public List<Type> queryType();
}
