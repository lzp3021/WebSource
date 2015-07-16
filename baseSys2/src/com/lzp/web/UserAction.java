package com.lzp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzp.common.EasyPage;
import com.lzp.dao.entity.SecRole;
import com.lzp.dao.entity.SecUser;
import com.lzp.service.UserManager;

@Controller
@RequestMapping(value="/userAction")
public class UserAction {
	@Autowired
	private UserManager us;
	@RequestMapping(value = "/list")
	public String list(){
		return "sec/userMsg";
	}
	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(SecUser secUser){
		try{
			us.saveUser(secUser);
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	@RequestMapping(value = "/findEasyPage")
	@ResponseBody
	public EasyPage<SecUser> findEasyPage(EasyPage<SecUser> easyPage,SecUser user) {
		return us.findEasyPage(easyPage, user);
	}
	@RequestMapping(value = "/del")
	@ResponseBody
	public String del(String userId){
		try{
			us.del(userId);
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	
}
