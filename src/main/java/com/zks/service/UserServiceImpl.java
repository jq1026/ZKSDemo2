package com.zks.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zks.dao.UserMapper;
import com.zks.model.Area;
import com.zks.model.Role;
import com.zks.model.User;
import com.zks.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	 @Autowired
    private UserMapper userMapper;

	@Override
	public List<User> getall() {
		// TODO Auto-generated method stub
		
		return userMapper.getall();
	}

	@Override
	public User getone(String user_code) {
		// TODO Auto-generated method stub
		return userMapper.getone(user_code);
	}

	@Override
	public List<Area> getarea() {
		// TODO Auto-generated method stub
		return userMapper.getarea();
	}

	@Override
	public void adduser(User user) {
		// TODO Auto-generated method stub
		userMapper.adduser(user);
	}

	@Override
	public void deleteuser(String user_name) {
		// TODO Auto-generated method stub
		userMapper.deleteuser(user_name);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userMapper.update(user);
	}

	@Override
	public List<User> select(User user) {
		// TODO Auto-generated method stub
		return userMapper.select(user);
	}

	@Override
	public List<Area> getcity(String name) {
		// TODO Auto-generated method stub
		return userMapper.getcity(name);
	}

	@Override
	public List<Area> getcounty(String name) {
		// TODO Auto-generated method stub
		return userMapper.getcounty(name);
	}

	@Override
	public List<Role> getallrole() {
		// TODO Auto-generated method stub
		return userMapper.getallrole();
	}

	
}
