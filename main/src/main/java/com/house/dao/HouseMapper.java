package com.house.dao;

import java.util.List;
import java.util.Map;

import com.house.pojo.House;

public interface HouseMapper {

	// 多条件查询用户下的房屋
	public List<House> queryAll(Map<String, Object> map);

	// 查询用户下的房屋
	public List<House> queryHousesByUid(Integer uid);

	public int upHouseById(Integer hmid, Integer uid);

	public int delHouseById(Integer hmid, Integer uid);
}
