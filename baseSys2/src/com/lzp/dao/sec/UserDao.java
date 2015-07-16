package com.lzp.dao.sec;

import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.lzp.common.hibernate.HibernateDao;
import com.lzp.dao.entity.SecRole;
import com.lzp.dao.entity.SecUser;
@Repository
public class UserDao extends HibernateDao<SecUser, String>{

	public Collection<String> findRoles(String currentUsername) {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append(" select r.role_code as roleCode from sec_user_role ur left join sec_user u ");
			sql.append(" on ur.user_id = u.user_id left join  ");
			sql.append(" sec_role r on ur.role_id =r.role_id ");
			sql.append(" where u.user_code='lzp' ");
			SQLQuery sqlQuery= createSQLQuery(sql.toString());
//			sqlQuery.addEntity(SecRole.class);
//			sqlQuery.addScalar("roleCode");
			List<String> list = sqlQuery.list();
			return list;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
