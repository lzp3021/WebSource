package com.lzp.service;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzp.common.EasyPage;
import com.lzp.dao.entity.SecAuthority;
import com.lzp.dao.entity.SecAuthorityResource;
import com.lzp.dao.entity.SecResource;
import com.lzp.dao.sec.AuthorityDao;
import com.lzp.dao.sec.AuthorityResourceDao;
import com.lzp.dao.sec.ResourceDao;

@Service
public class AuthorityResourceManager {
	@Autowired
	private ResourceDao resourceDao;
	@Autowired
	private AuthorityDao authorityDao;
	@Autowired
	private AuthorityResourceDao authorityResourceDao;
	
	public EasyPage<SecResource> findResourcePage(EasyPage<SecResource> easyPage,
			SecResource resource) {
		DetachedCriteria dc = DetachedCriteria.forClass(SecResource.class);
//		dc.createAlias("secAuthority", "menu", JoinType.LEFT_OUTER_JOIN);
		return resourceDao.findEasyPage(easyPage,dc);
	}
	
	public List<SecResource> findResourcesByAuthorityId(String authorityId) {
		DetachedCriteria dc = DetachedCriteria.forClass(SecAuthorityResource.class);
//		dc.createAlias("secAuthorityResources", "ar", JoinType.LEFT_OUTER_JOIN);
		dc.createAlias("secResource", "r", JoinType.LEFT_OUTER_JOIN);
		dc.add(Property.forName("secAuthority.authorityId").eq(authorityId));
		List<SecAuthorityResource> list = authorityResourceDao.find(dc);
		List<SecResource> resList = new LinkedList<SecResource>();
		for (SecAuthorityResource ar : list) {
			resList.add(ar.getSecResource());
		}
		return resList;
	}
	
	
	public EasyPage<SecAuthority> findAuthorityPage(
			EasyPage<SecAuthority> easyPage, SecAuthority authority) {
		DetachedCriteria dc = DetachedCriteria.forClass(SecAuthority.class);
		return authorityDao.findEasyPage(easyPage, dc);
	}

	public void saveAuthorityResource(String authorityId,
			List<SecResource> resources) {
		String sql = "delete from sec_authority_resource ar where ar.authority_id =?";
		int count = authorityResourceDao.createSQLQuery(sql, authorityId).executeUpdate();
		System.out.println("del:"+count);
		for (SecResource secResource : resources) {
			SecAuthorityResource ar = new SecAuthorityResource();
			ar.setSecResource(secResource);
			ar.setSecAuthority(authorityDao.get(authorityId));
			authorityResourceDao.save(ar);
		}
	}

	public void saveAuthority(SecAuthority authority) {
		authorityDao.save(authority);
	}

	public void updateAuthority(SecAuthority authority) {
		authorityDao.update(authority);
	}

	public void deleteResource(String authorityId, String resourceId) {
		String sql = "delete from sec_authority_resource ar where ar.authority_id =? and ar.resource_id=?";
		int count = authorityResourceDao.createSQLQuery(sql, authorityId,resourceId).executeUpdate();
		System.out.println("del:"+count);
	}

}
