package com.zks.dao;

import java.util.List;

import com.zks.model.Area;
import com.zks.model.Role;
import com.zks.model.User;

public interface UserMapper {
	List<User> getall();//��ȡ�б�
	User getone(String user_code);//�����û��˺Ų�ѯ
	List<Area> getarea();//��ȡ����
	void adduser(User user);//���
	void deleteuser(String user_name);//ɾ���û�
	void update(User user);//�޸�
	List<User> select(User user);//ģ����ѯ
	List<Area> getcity(String name);//��ȡ����
	List<Area> getcounty(String name);//��ȡ����
	List<Role> getallrole();//��ȡ��ɫ�б�
	
}
