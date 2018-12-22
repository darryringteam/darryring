package com.house.dao;

import java.util.List;

import com.house.pojo.District;


public interface DistrictMapper {
	
	//查询房屋所在区
	public List<District> queryDistrict();
	
	//根据区id查询区
    public District queryDistrictById(Integer did);
}
