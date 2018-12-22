package com.house.service;

import java.util.List;

import com.house.pojo.Street;


public interface StreetService {

	//查询某区下的所有街道
	public List<Street> queryStrByDid(Integer did);
}
