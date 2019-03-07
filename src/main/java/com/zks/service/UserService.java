package com.zks.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zks.model.Area;
import com.zks.model.Role;
import com.zks.model.User;

public interface UserService {
	List<User> getall();
	User getone(String user_code);
	List<Area> getarea();
	void adduser(User user);
	void deleteuser(String user_name);
	void update(User user);
	List<User> select(User user);
	List<Area> getcity(String name);
	List<Area> getcounty(String name);//获取区县
	List<Role> getallrole();
}
