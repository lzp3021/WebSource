package com.lzp.service;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzp.dao.entity.SecAuthority;
import com.lzp.dao.entity.SecRoleAuthority;
import com.lzp.dao.sec.RoleAuthorityDao;
import com.lzp.dao.sec.RoleDao;

@Service
public class RoleAuthorityManager {
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private RoleAuthorityDao roleAuthorityDao;
	

	public List<SecAuthority> findAuthorityByRoleId(String roleId) {
		DetachedCriteria dc = DetachedCriteria.forClass(SecRoleAuthority.class);
		dc.createAlias("secAuthority", "a", JoinType.LEFT_OUTER_JOIN);
		dc.add(Property.forName("secRole.roleId").eq(roleId));
		List<SecRoleAuthority> list = roleAuthorityDao.find(dc);
		List<SecAuthority> autList = new LinkedList<SecAuthority>();
		for (SecRoleAuthority ra : list) {
			autList.add(ra.getSecAuthority());
		}
		return autList;
	}
	
	public void saveRoleAuthority(String roleId, List<SecAuthority> authoritys) {
		String sql = "delete from sec_role_authority ra where ra.role_id =?";
		int count = roleAuthorityDao.createSQLQuery(sql, roleId).executeUpdate();
		System.out.println("del:"+count);
		for (SecAuthority secAuthority : authoritys) {
			SecRoleAuthority ra = new SecRoleAuthority();
			ra.setSecAuthority(secAuthority);
			ra.setSecRole(roleDao.get(roleId));
			roleAuthorityDao.save(ra);
		}
	}

	public void deleteAuthority(String roleId, String authorityId) {
		String sql = "delete from sec_role_authority ra where ra.roleId =? and ra.authorityId=?";
		int count = roleAuthorityDao.createSQLQuery(sql,roleId,authorityId).executeUpdate();
		System.out.println("del:"+count);
	}


}
