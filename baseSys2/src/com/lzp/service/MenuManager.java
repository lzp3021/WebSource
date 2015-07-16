package com.lzp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lzp.dao.entity.SecMenu;
import com.lzp.dao.entity.SecResource;
import com.lzp.dao.sec.MenuDao;
import com.lzp.dao.sec.ResourceDao;

@Component
public class MenuManager {
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private ResourceDao resourceDao;

	public List<SecMenu> findMenuTree(String menuId) {
		DetachedCriteria dc =DetachedCriteria.forClass(SecMenu.class);
		dc.add(Restrictions.eq("parentId", menuId));
		dc.addOrder(Order.asc("menuCode"));
		List<SecMenu> menus = menuDao.find(dc);
		findChildren(menus);
		return menus;
	}

	private void findChildren( List<SecMenu> menus){
		for (SecMenu secMenu : menus) {
			DetachedCriteria dc =DetachedCriteria.forClass(SecMenu.class);
			dc.add(Restrictions.eq("parentId", secMenu.getMenuId()));
			dc.addOrder(Order.asc("menuCode"));
			List<SecMenu> children = menuDao.find(dc);
			if(!children.isEmpty()){
				secMenu.setState(SecMenu.CLOSED);
			}else{
				secMenu.setState(SecMenu.OPEN);
			}
//			secMenu.setChildren(children);
		}
	}

	public void menuSave(SecMenu secMenu) {
		if(!StringUtils.isEmpty(secMenu.getMenuId())){
			menuDao.update(secMenu);
		}else{
			menuDao.save(secMenu);
			SecResource secResource = new SecResource();
			secResource.setResourceCode(secMenu.getMenuCode());
			secResource.setResourceContent(secMenu.getMenuUrl());
			secResource.setResourceType("01");
			secResource.setIsValid(true);
			secResource.setSecMenu(secMenu);
			resourceDao.save(secResource);
		}
	}

	public void menuRemove(String menuId) {
		menuDao.delete(menuId);
		List<SecResource> list = resourceDao.findBy("secMenu.menuId", menuId);
		for (SecResource secResource : list) {
			resourceDao.delete(secResource);
		}
	}
}
