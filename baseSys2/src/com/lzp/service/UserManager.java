package com.lzp.service;

import java.util.Collection;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzp.common.EasyPage;
import com.lzp.dao.entity.SecUser;
import com.lzp.dao.sec.UserDao;

@Service
public class UserManager {

	@Autowired
	private UserDao userDao;

	public void saveUser(SecUser user) {
		user.setUserId(null);
		userDao.save(user);
	}

	public EasyPage<SecUser> findEasyPage(EasyPage<SecUser> page, SecUser user) {
		DetachedCriteria dc = DetachedCriteria.forClass(SecUser.class);
		return userDao.findEasyPage(page, dc);
	}

	public void del(String userid) {
		userDao.delete(userid);
	}

	public Collection<String> findRoles(String currentUsername) {
		return userDao.findRoles(currentUsername);
	}

	public SecUser findUserByCode(String userCode) {
		return userDao.findUniqueBy("userCode", userCode);
	}

	@SuppressWarnings("unchecked")
	public List<String> getAuthoritiesCode(String userId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select a.authority_code ");
		sql.append(" from sec_user u ");
		sql.append(" left outer join sec_user_role ur ");
		sql.append(" on u.user_id = ur.user_id ");
		sql.append(" left outer join sec_role r ");
		sql.append(" on ur.role_id = r.role_id ");
		sql.append(" left outer join sec_role_authority ra ");
		sql.append(" on r.role_id = ra.role_id ");
		sql.append(" left outer join sec_authority a ");
		sql.append(" on ra.authority_id = a.authority_id ");
		sql.append(" where u.user_id = ? ");
		SQLQuery query = userDao.createSQLQuery(sql.toString(), userId);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<String> getRolesCode(String userId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select r.role_code as roleCode ");
		sql.append(" from sec_user u ");
		sql.append(" left outer join sec_user_role ur ");
		sql.append(" on u.user_id = ur.user_id ");
		sql.append(" left outer join sec_role r ");
		sql.append(" on ur.role_id = r.role_id ");
		sql.append(" where u.user_id = ? ");
		SQLQuery query = userDao.createSQLQuery(sql.toString(), userId);
		return query.list();
	}
}
