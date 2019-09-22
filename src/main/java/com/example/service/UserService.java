package com.example.service;

import java.util.List;

import com.example.pojo.User;
import com.example.pojo.UserDTO;
import com.github.pagehelper.PageInfo;

public interface UserService {
public PageInfo<User> queryUserList(UserDTO user);
public void insertUser(User user) throws Exception;
}
