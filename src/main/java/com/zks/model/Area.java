package com.zks.model;

public class Area {
	private int id;
	private String code;//�������
	private String name;//��������
	private String parent_code;//���������
	private String full_name;//����ȫ��
	private int level_type;//����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParent_code() {
		return parent_code;
	}
	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public int getLevel_type() {
		return level_type;
	}
	public void setLevel_type(int level_type) {
		this.level_type = level_type;
	}
	
}
