package com.lzp.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzp.common.EasyPage;
import com.lzp.dao.entity.SecResource;
import com.lzp.dao.sec.ResourceDao;

@Service
public class ResourceManager {
	@Autowired
	private ResourceDao resourceDao;
	
	public List<SecResource> getAll() {
		List<SecResource>  resources = resourceDao.getAll();
		return resources;
	}

	public EasyPage<SecResource> findEasyPage(EasyPage<SecResource> easyPage,
			SecResource resource) {
		DetachedCriteria dc = DetachedCriteria.forClass(SecResource.class);
		dc.createAlias("secMenu", "menu", JoinType.LEFT_OUTER_JOIN);
		return resourceDao.findEasyPage(easyPage,dc);
	}

	public String saveForm(SecResource resource) {
		if(StringUtils.isEmpty(resource.getResourceId())){
			resourceDao.save(resource);
		}else{
			resourceDao.update(resource);
		}
		return resource.getResourceId();
	}

	public void delete(String resourceId) {
		resourceDao.delete(resourceId);
	}
}
