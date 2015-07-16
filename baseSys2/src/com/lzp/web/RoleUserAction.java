package com.lzp.web;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzp.common.BaseAction;
import com.lzp.dao.entity.SecUser;
import com.lzp.service.RoleUserManager;

@Controller
@RequestMapping(value = "/roleUserAction")
public class RoleUserAction extends BaseAction{
	
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(RoleUserAction.class);
	
	@Autowired
	private RoleUserManager roleUserManager;
	
	@RequestMapping(value = "/list")
	public String list() {
		return "sec/roleUser";
	}
	
	@RequestMapping(value = "/findUserByRoleId")
	@ResponseBody
	public List<SecUser> findUserByRoleId(String roleId){
		try {
			if(!StringUtils.isEmpty(roleId)){
				List<SecUser> list =roleUserManager.findUserByRoleId(roleId);
				return list;
			}else{
				return null;
			}
		} catch (Exception e) {
			logger.error("",e);
			return null;
		}
	}
	
	
	@RequestMapping(value = "/saveRoleUser")
	@ResponseBody
	public String saveRoleUser( String json,String roleId) {
		try {
			List<SecUser> authoritys = readJson(json, List.class, SecUser.class);
			roleUserManager.saveRoleUser(roleId,authoritys);
			return SUCCESS;
		} catch (Exception e) {
			logger.error("",e);
			return FAIL;
		}
	}
	
	@RequestMapping(value = "/deleteResource")
	@ResponseBody
	public String deleteUser(String roleId,String userId) {
		try {
			roleUserManager.deleteUser(roleId,userId);
			return SUCCESS;
		} catch (Exception e) {
			logger.error("",e);
			return FAIL;
		}
	}
	
}
