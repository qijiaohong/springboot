package com.example.mapper;

import java.util.List;

import com.example.pojo.User;
import com.example.pojo.UserDTO;
import tk.mybatis.mapper.common.Mapper;

//@Mapper
public interface UserMapper extends Mapper<User> {
	  List<User> queryUserList(UserDTO user);
}
