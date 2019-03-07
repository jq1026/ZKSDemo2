package com.zks.dao;

import java.util.List;

import com.zks.model.Area;
import com.zks.model.Role;
import com.zks.model.User;

public interface UserMapper {
	List<User> getall();//获取列表
	User getone(String user_code);//根据用户账号查询
	List<Area> getarea();//获取区域
	void adduser(User user);//添加
	void deleteuser(String user_name);//删除用户
	void update(User user);//修改
	List<User> select(User user);//模糊查询
	List<Area> getcity(String name);//获取城市
	List<Area> getcounty(String name);//获取区县
	List<Role> getallrole();//获取角色列表
	
}
