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
import com.lzp.common.DatagridMsg;
import com.lzp.common.EasyPage;
import com.lzp.dao.entity.SecAuthority;
import com.lzp.dao.entity.SecResource;
import com.lzp.service.AuthorityResourceManager;

@Controller
@RequestMapping(value = "/authorityResourceAction")
public class AuthorityResourceAction extends BaseAction{
	
	private static Logger logger = LoggerFactory.getLogger(AuthorityResourceAction.class);
	
	@Autowired
	private AuthorityResourceManager authorityResourceManager;
	
	@RequestMapping(value = "/list")
	public String list() {
		return "sec/authorityResource";
	}
	
	@RequestMapping(value = "/findAuthorityPage")
	@ResponseBody
	public EasyPage<SecAuthority> findAuthorityPage(EasyPage<SecAuthority> easyPage,SecAuthority authority) {
		return authorityResourceManager.findAuthorityPage(easyPage, authority);
	}
	
	
	@RequestMapping(value = "/findResourcePage")
	@ResponseBody
	public EasyPage<SecResource> findResourcePage(EasyPage<SecResource> easyPage,SecResource resource) {
		return authorityResourceManager.findResourcePage(easyPage, resource);
	}
	
	@RequestMapping(value = "/findResourcesByAuthorityId")
	@ResponseBody
	public List<SecResource> findResourcesByAuthorityId(String authorityId){
		try {
			if(!StringUtils.isEmpty(authorityId)){
				List<SecResource> list =authorityResourceManager.findResourcesByAuthorityId(authorityId);
				return list;
			}else{
				return null;
			}
		} catch (Exception e) {
			logger.error("findResourcesByAuthorityId", e);
			return null;
		}
	}
	
	@RequestMapping(value = "/saveAuthority")
	@ResponseBody
	public DatagridMsg saveAuthority(SecAuthority authority){
		try {
			authorityResourceManager.saveAuthority(authority);
			return new DatagridMsg();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new DatagridMsg(true,e.getMessage());
		}
	}
	@RequestMapping(value = "/updateAuthority")
	@ResponseBody
	public DatagridMsg updateAuthority(SecAuthority authority){
		try {
			authorityResourceManager.updateAuthority(authority);
			authority.setIsError(true);
			authority.setMsg("error");
			return new DatagridMsg();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new DatagridMsg(true,e.getMessage());
		}
	}
	
	@RequestMapping(value = "/saveAuthorityResource")
	@ResponseBody
	public String saveAuthorityResource( String json,String authorityId) {
		try {
			List<SecResource> resources = readJson(json, List.class, SecResource.class);
			authorityResourceManager.saveAuthorityResource(authorityId,resources);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return FAIL;
		}
	}
	@RequestMapping(value = "/deleteResource")
	@ResponseBody
	public String deleteResource(String authorityId,String resourceId) {
		try {
			authorityResourceManager.deleteResource(authorityId,resourceId);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return FAIL;
		}
	}
	
}
