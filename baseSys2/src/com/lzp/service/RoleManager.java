package com.lzp.service;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzp.common.EasyPage;
import com.lzp.dao.entity.SecRole;
import com.lzp.dao.sec.RoleDao;

@Service
public class RoleManager {
	@Autowired
	private RoleDao roleDao;
	
	
	public EasyPage<SecRole> findEasyPage(EasyPage<SecRole> page,SecRole role) {
		DetachedCriteria dc = DetachedCriteria.forClass(SecRole.class);
		return roleDao.findEasyPage(page,dc);
	}


	public void saveRole(SecRole role) {
		roleDao.save(role);
	}


	public void updateRole(SecRole role) {
		roleDao.update(role);
	}

}
