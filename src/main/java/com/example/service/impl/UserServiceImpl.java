package com.example.service.impl;

import java.util.List;

import com.example.pojo.UserDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
@Autowired
private UserMapper userMapper;
	@Override
	public PageInfo<User> queryUserList(UserDTO user) {
		// TODO Auto-generated method stu
		PageHelper.startPage(user.getPageNumber(),user.getPageSize());
		List<User> list = userMapper.queryUserList(user);
		PageInfo<User> pi = new PageInfo<User>(list);
		return pi;
	}
	@Transactional
	public void insertUser(User user) throws Exception{
		 userMapper.insert(user);
	}

}
