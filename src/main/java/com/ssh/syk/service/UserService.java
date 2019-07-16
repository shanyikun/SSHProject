package com.ssh.syk.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssh.syk.dao.UserDao;

@Service("userService")
public class UserService {
	@Resource(name = "userDao")
	private UserDao userDao;
	public String register(String name, String password) {
		return userDao.register(name, password);
	}
}
