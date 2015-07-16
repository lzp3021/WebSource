package com.lzp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzp.common.EasyPage;
import com.lzp.dao.entity.SecResource;
import com.lzp.service.ResourceManager;

@Controller
@RequestMapping(value = "/resourceAction")
public class ResourceAction {
	/**
	 * @Fields SUCCESS : 操作成功,返回页面公共属性 
	 */
	protected static final String SUCCESS = "success";
	/**
	 * @Fields FAIL : 操作失败,返回页面公共属性 
	 */
	protected static final String FAIL = "fail";
	@Autowired
	private ResourceManager resourceManager;

	@RequestMapping(value = "/list")
	public String list() {
		return "sec/resource";
	}
	
	@RequestMapping(value = "/findEasyPage")
	@ResponseBody
	public EasyPage<SecResource> findEasyPage(EasyPage<SecResource> easyPage,SecResource resource) {
		return resourceManager.findEasyPage(easyPage, resource);
	}
	@RequestMapping(value = "/saveForm")
	@ResponseBody
	public String saveForm(SecResource resource){
		 try {
			return resourceManager.saveForm(resource);
		} catch (Exception e) {
			e.printStackTrace();
			return FAIL;
		}
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public String delete(String resourceId) {
		try {
			resourceManager.delete(resourceId);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return FAIL;
		}
	}
}
