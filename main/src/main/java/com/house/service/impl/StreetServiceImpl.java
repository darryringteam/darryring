package com.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.house.dao.StreetMapper;
import com.house.pojo.Street;
import com.house.service.StreetService;

@Service
@Transactional
public class StreetServiceImpl implements StreetService {

	@Autowired
	private StreetMapper streetMapper;

	@Override
	public List<Street> queryStrByDid(Integer did) {

		return streetMapper.queryStrByDid(did);
	}

}
