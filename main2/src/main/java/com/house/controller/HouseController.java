package com.house.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.house.pojo.User;
import com.house.service.DistrictService;
import com.house.service.HouseService;
import com.house.service.TypeService;

@Controller
@SessionAttributes(value = { "tylist", "map", "dislist", "pg", "page" })
public class HouseController {

	@Autowired
	private TypeService ts;
	@Autowired
	private DistrictService ds;
	@Autowired
	private HouseService hs;

	@RequestMapping("/list")
	public String searchHousesByCondition(@RequestParam Map<String, Object> map, Model model) {
		// 价格处理
		String price = (String) map.get("price");

		if (price != null && !"".equals(price)) {
			// 最低价
			map.put("PLPrice", price.substring(0, price.indexOf("-")));
			// 最高价
			map.put("PHPrice", price.substring(price.indexOf("-") + 1));
		}
		// 面积处理
		String floorage = (String) map.get("floorage");

		if (floorage != null && !"".equals(floorage)) {
			// 最低面积
			map.put("ALarea", floorage.substring(0, floorage.indexOf("-")));
			// 最高面积
			map.put("AHarea", floorage.substring(floorage.indexOf("-") + 1));
		}

		String pageIndex = (String) map.get("pageIndex");
		if (pageIndex == null) {
			pageIndex = "1";
		}
		Page<Object> page = PageHelper.startPage(Integer.parseInt(pageIndex), 3, "price desc");
		// 加载房屋
		hs.queryAll(map);

		model.addAttribute("tylist", ts.queryType());

		model.addAttribute("map", map);

		model.addAttribute("dislist", ds.queryDistrict());

		model.addAttribute("pg", page);

		return "redirect:/list.jsp";

	}

	@RequestMapping("/guanli")
	public String guanli(Integer pageIndex, HttpSession session, Model model) {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		User user = (User) session.getAttribute("user");
		Page<Object> page = PageHelper.startPage(pageIndex, 3, "price desc");
		hs.queryHousesByUid(user.getUid());
		model.addAttribute("page", page);
		return "redirect:/guanli.jsp";

	}

	@RequestMapping("/update")
	public String update(Integer hmid, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (hs.upHouseById(hmid, user.getUid()) > 0) {
			return "redirect:/guanli.jsp";
		}
		return "/list.jsp";

	}

	@RequestMapping("/del")
	public String delete(Integer hmid, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (hs.delHouseById(hmid, user.getUid()) > 0) {
			return "redirect:/guanli.jsp";
		}
		return "/list.jsp";

	}

}
