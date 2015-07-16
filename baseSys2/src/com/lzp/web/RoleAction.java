package com.lzp.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzp.common.BaseAction;
import com.lzp.common.DatagridMsg;
import com.lzp.common.EasyPage;
import com.lzp.dao.entity.SecAuthority;
import com.lzp.dao.entity.SecRole;
import com.lzp.service.RoleManager;

@Controller
@RequestMapping(value = "/roleAction")
public class RoleAction extends BaseAction{
	@Autowired
	private RoleManager roleManager;

	@RequestMapping(value = "/list")
	public String list() {
		return "sec/role";
	}

	@RequestMapping(value = "/findEasyPage")
	@ResponseBody
	public EasyPage<SecRole> findEasyPage(EasyPage<SecRole> easyPage,SecRole role) {
		return roleManager.findEasyPage(easyPage, role);
	}
	
	@RequestMapping(value = "/saveRole")
	@ResponseBody
	public  DatagridMsg saveRole(SecRole role){
		try {
			roleManager.saveRole(role);
			return new DatagridMsg();
		} catch (Exception e) {
			e.printStackTrace();
			return new DatagridMsg(true,e.getMessage());
		}
	}
	@RequestMapping(value = "/updateRole")
	@ResponseBody
	public DatagridMsg updateRole(SecRole role){
		try {
			roleManager.updateRole(role);
			return new DatagridMsg();
		} catch (Exception e) {
			e.printStackTrace();
			return new DatagridMsg(true,e.getMessage());
		}
	}
	
}
