package com.ssh.syk.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssh.syk.paramPOJO.UserInfo;
import com.ssh.syk.service.UserService;

@Controller
public class UserController {
	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegisterPage() {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(UserInfo userInfo, Model model) {
		String result = userService.register(userInfo.getName(), userInfo.getPassword());
		model.addAttribute("result", result);
		return "userPage";
	}
}
