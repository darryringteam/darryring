package com.house.service;

import java.util.List;

import com.house.pojo.District;

public interface DistrictService {

	//查询房屋所在区
	public List<District> queryDistrict();
	
	public District queryDistrictById(Integer did);
}
