package com.zks.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zks.model.Area;
import com.zks.model.Role;
import com.zks.model.User;
import com.zks.service.UserService;

@Controller
@RequestMapping("/sys")
public class UserController {
	@Autowired
	private UserService userService;
	ServletRequest request;
	private List<User> u;
	/* 
	 * ��ȡ������Ϣ
	 * �û�
	 * ����ʡ
	 * */
	@RequestMapping("/getall")
	public String getall(Model model){
		List<User> users=userService.getall();
		model.addAttribute("users",users);
		List<Area> larea=userService.getarea();
		model.addAttribute("larea",larea);
		return "/index";
	}
	/* 
	 * �����û������ѯһ����Ϣ
	 * �����޸��û���Ϣ
	 * */
	@RequestMapping("/getone")
	public String getone(Model model,@RequestParam(value="user_code", required=true)String user_code){
		User user=userService.getone(user_code);
		model.addAttribute("users",user);
		
		List<Area> larea=userService.getarea();
		model.addAttribute("larea",larea);
		
		List<Role> rlist=userService.getallrole();
		model.addAttribute("rlist",rlist);
		/*System.out.println("��ѯ");
		System.out.println("��ѯ"+larea.size());*/
		return "/update";
	}
	/* 
	 * ��Ӳ���
	 * */
	@RequestMapping("/add")
	public String add(Model model,User user){
		userService.adduser(user);
		List<Area> larea=userService.getarea();
		model.addAttribute("larea",larea);
		JOptionPane.showMessageDialog(null, "��ӳɹ�","��ʾ",JOptionPane.CANCEL_OPTION);
		return "redirect:/sys/getall";
	}
	/* 
	 * ɾ������
	 * */
	@RequestMapping("/deleteuser")
	public String deleteuser(Model model,@RequestParam(value="user_name", required=true)String user_name){
		userService.deleteuser(user_name);
		/*JOptionPane.showMessageDialog(null, "ɾ���ɹ�","��ʾ",JOptionPane.CANCEL_OPTION);*/
		return "redirect:/sys/getall";
	}
	/* 
	 *�޸Ĳ���
	 * */
	@RequestMapping("/update")
	public String update(Model model,User user){
		userService.update(user);
		List<Role> rlist=userService.getallrole();
		model.addAttribute("rlist",rlist);
		return "redirect:/sys/getall";
	}
	/* 
	 *ģ����ѯ
	 * */
	@RequestMapping("/select")
	public String select(Model model,User user){
		
		u=userService.select(user);
		model.addAttribute("users",u);
		List<Area> larea=userService.getarea();
		model.addAttribute("larea",larea);
		return "/index";	
	}
	
	/* 
	 * ��ȡ��
	 * */
	@RequestMapping(value="/getcity/{province_name}",method=RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<Integer, Object> getcity(@PathVariable(value="province_name") String province_name,Model model){	
		List<Area> city=userService.getcity(province_name);
		Map<Integer, Object> cityMap=new HashMap<>();
		for(int i=0;i<city.size();i++){
			cityMap.put(i, city.get(i).getName());
		}
		List<Area> larea=userService.getarea();
		model.addAttribute("larea",larea);
		return cityMap;
	}
	
	
	/* 
	 * ��ȡ����
	 * */
	@RequestMapping(value="/getcounty/{city_name}",method=RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<Integer, Object> getcounty(@PathVariable(value="city_name") String city_name,Model model){	
		List<Area> county=userService.getcounty(city_name);
		Map<Integer, Object> countyMap=new HashMap<>();
		for(int i=0;i<county.size();i++){
			countyMap.put(i, county.get(i).getName());
		}
		List<Area> larea=userService.getarea();
		model.addAttribute("larea",larea);
		return countyMap;
	}
	/* 
	 * excel��������
	 * */
	@RequestMapping(value="/getex")
	public void export(HttpServletResponse response) {
		// �����µ�Excel������
		SXSSFWorkbook workbook = null;
		gongjv export = new gongjv();
		try {
			String excelName = "jq";
			OutputStream out = response.getOutputStream();
			excelName = new String(excelName.getBytes("GBK"), "UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + excelName + ".xlsx");
			if(u!=null){
				workbook = export.ulist(u);
			}else{
				workbook = export.ulist(userService.getall());
			}
			
			workbook.write(out);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
	} 		
	
	/* 
	 * ҳ����ת
	 * */
	@RequestMapping("/addt")
	public String addt(Model model,User user){
		List<Area> larea=userService.getarea();
		model.addAttribute("larea",larea);
		List<Role> rlist=userService.getallrole();
		model.addAttribute("rlist",rlist);
		return "/add";
	}
	
}
