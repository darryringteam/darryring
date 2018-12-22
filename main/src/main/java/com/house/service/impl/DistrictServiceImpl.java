package com.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.house.dao.DistrictMapper;
import com.house.pojo.District;
import com.house.service.DistrictService;

@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictMapper districtMapper;

	@Override
	public List<District> queryDistrict() {

		return districtMapper.queryDistrict();
	}

	@Override
	public District queryDistrictById(Integer did) {

		return districtMapper.queryDistrictById(did);
	}

}
