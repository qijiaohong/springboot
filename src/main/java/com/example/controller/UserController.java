package com.example.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.pojo.AjaxResponse;
import com.example.pojo.PaginationResponse;
import com.example.pojo.UserDTO;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.User;
import com.example.service.UserService;
@Slf4j
@RestController
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@RequestMapping(value = "/userList")
	public PaginationResponse<User> userList(UserDTO user) {
		log.info("查询用户信息");
		  User u = new User(); u.setId(1); u.setName("张三"); u.setAge(23);
		  u.setBirthday(new Date());


		PageInfo<User> pi = userService.queryUserList(user);
		PaginationResponse<User> pr = new PaginationResponse<User>();
		//pr.setPage(pi.getPageNum());
		pr.setRows(pi.getList());
		pr.setTotal(pi.getTotal());
		return pr;
	}
//加密,encoder每次加密的密文都不一样
@RequestMapping(value = "/bcrypt")
	public void insertUser(){
		String pwd = "123";
		logger.info("密文:{}",encoder.encode(pwd));
	}

	@RequestMapping(value = "/add")
	public AjaxResponse add(User user){
		try {
			userService.insertUser(user);
			return new AjaxResponse(AjaxResponse.ResponseStatus.SUCCESS);
		}catch(Exception e){
			return new AjaxResponse(AjaxResponse.ResponseStatus.FAIL,e.getMessage());
		}

	}
}