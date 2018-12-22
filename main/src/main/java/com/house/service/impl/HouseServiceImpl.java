package com.house.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.house.dao.HouseMapper;
import com.house.pojo.House;
import com.house.service.HouseService;

@Service
@Transactional
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseMapper houseMapper;

	@Override
	public List<House> queryAll(Map<String, Object> map) {

		return houseMapper.queryAll(map);
	}

	@Override
	public List<House> queryHousesByUid(Integer uid) {

		return houseMapper.queryHousesByUid(uid);
	}

	public int upHouseById(Integer hmid, Integer uid) {

		return houseMapper.upHouseById(hmid, uid);
	}

	public int delHouseById(Integer hmid, Integer uid) {

		return houseMapper.delHouseById(hmid, uid);
	}

}
