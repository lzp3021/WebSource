package com.lzp.web;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzp.common.BaseAction;
import com.lzp.dao.entity.SecAuthority;
import com.lzp.service.RoleAuthorityManager;

@Controller
@RequestMapping(value = "/roleAuthorityAction")
public class RoleAuthorityAction extends BaseAction{
	
	private static Logger logger = LoggerFactory.getLogger(RoleAuthorityAction.class);
	
	@Autowired
	private RoleAuthorityManager roleAuthorityManager;
	
	@RequestMapping(value = "/list")
	public String list() {
		return "sec/roleAuthority";
	}
	
	
	
	@RequestMapping(value = "/findAuthorityByRoleId")
	@ResponseBody
	public List<SecAuthority> findAuthorityByRoleId(String roleId){
		try {
			if(!StringUtils.isEmpty(roleId)){
				List<SecAuthority> list =roleAuthorityManager.findAuthorityByRoleId(roleId);
				return list;
			}else{
				return null;
			}
		} catch (Exception e) {
			logger.error("",e);
			return null;
		}
	}
	
	
	@RequestMapping(value = "/saveRoleAuthority")
	@ResponseBody
	public String saveRoleAuthority( String json,String roleId) {
		try {
			List<SecAuthority> authoritys = readJson(json, List.class, SecAuthority.class);
			roleAuthorityManager.saveRoleAuthority(roleId,authoritys);
			return SUCCESS;
		} catch (Exception e) {
			logger.error("",e);
			return FAIL;
		}
	}
	@RequestMapping(value = "/deleteResource")
	@ResponseBody
	public String deleteAuthority(String roleId,String authorityId) {
		try {
			roleAuthorityManager.deleteAuthority(roleId,authorityId);
			return SUCCESS;
		} catch (Exception e) {
			logger.error("",e);
			return FAIL;
		}
	}
	
}
