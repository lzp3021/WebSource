package com.lzp.web;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzp.common.BaseAction;
import com.lzp.dao.entity.SecMenu;
import com.lzp.service.MenuManager;

@Controller
@RequestMapping(value = "/menuAction")
public class MenuAction extends BaseAction{
	@Autowired
	private MenuManager menuService;
	
	@RequestMapping(value = "/list")
	public String list(){
		return "sec/menu";
	}
	
	@RequestMapping(value = "/menuTree")
	@ResponseBody()
	public List<SecMenu> menuTree(String id ) {
		try {
			if(StringUtils.isEmpty(id)){
				id="0";
			}
			List<SecMenu> list =menuService.findMenuTree(id);
			return  list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping(value = "/menuSave")
	@ResponseBody
	public String menuSave(SecMenu secMenu){
		try{
			menuService.menuSave(secMenu);
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return FAIL;
		}
	}
	
	@RequestMapping(value = "/menuRemove")
	@ResponseBody
	public String menuRemove(String menuId){
		try{
			menuService.menuRemove(menuId);
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return FAIL;
		}
	}
	
	@RequestMapping(value = "/appendMenu")
	@ResponseBody
	public String appendMenu(){
		return FAIL;
	}
}
