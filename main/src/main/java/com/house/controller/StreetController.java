package com.house.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.house.pojo.Street;
import com.house.service.StreetService;

@Controller
public class StreetController {

	@Autowired
	private StreetService ss;

	@ResponseBody
	@RequestMapping("/queryStreets")
	public List<Street> queryStreets(@RequestBody @RequestParam(value = "did", defaultValue = "0") String did) {

		return ss.queryStrByDid(Integer.parseInt(did));
	}
}
