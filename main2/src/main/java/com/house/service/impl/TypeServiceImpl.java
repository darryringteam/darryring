package com.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.house.dao.TypeMapper;
import com.house.pojo.Type;
import com.house.service.TypeService;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeMapper typeMapper;

	@Override
	public List<Type> queryType() {

		return typeMapper.queryType();
	}

}
