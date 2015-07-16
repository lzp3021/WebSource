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
import com.lzp.dao.entity.SecUser;
import com.lzp.dao.entity.SecUserRole;
import com.lzp.dao.sec.RoleDao;
import com.lzp.dao.sec.RoleUserDao;

@Service
public class RoleUserManager {
	
	@Autowired
	private RoleUserDao roleUserDao;

	@Autowired
	private RoleDao roleDao;
	
	public List<SecUser> findUserByRoleId(String roleId) {
		DetachedCriteria dc = DetachedCriteria.forClass(SecUserRole.class);
		dc.createAlias("secUser", "u", JoinType.LEFT_OUTER_JOIN);
		dc.add(Property.forName("secRole.roleId").eq(roleId));
		List<SecUserRole> list = roleUserDao.find(dc);
		List<SecUser> userList = new LinkedList<SecUser>();
		for (SecUserRole ur : list) {
			userList.add(ur.getSecUser());
		}
		return userList;
	}

	public void saveRoleUser(String roleId, List<SecUser> users) {
		String sql = "delete from sec_user_role ra where ra.role_id =?";
		roleUserDao.createSQLQuery(sql, roleId).executeUpdate();
		for (SecUser user :  users) {
			SecUserRole ur = new SecUserRole();
			ur.setSecUser(user);
			ur.setSecRole(roleDao.get(roleId));
			roleUserDao.save(ur);
		}
	}

	public void deleteUser(String roleId, String userId) {
		String sql = "delete from sec_user_role ur where ur.role_id =? and ur.user_id=?";
		int count = roleUserDao.createSQLQuery(sql,roleId,userId).executeUpdate();
	}

}
