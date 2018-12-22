package com.house.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.house.pojo.User;
import com.house.service.UserService;

@Controller
@SessionAttributes(value = { "user" })
public class UsersController {

	@Autowired
	private UserService us;

	@RequestMapping("/regist")
	public String register(User user) throws IOException {
		int num = us.regUser(user);
		if (num > 0) {
			return "login.jsp";
		}
		return "regs.jsp";
	}

	@RequestMapping("/login")
	public String login(User user, Model model) throws IOException {
		User users = us.findUserByUandP(user.getUsername(), user.getPassword());
		if (users != null) {
			model.addAttribute("user", users);
			return "/list";
		} else {
			return "login.jsp";
		}
	}

}
