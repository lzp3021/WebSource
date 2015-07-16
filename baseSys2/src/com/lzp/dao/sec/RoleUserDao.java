package com.lzp.dao.sec;

import org.springframework.stereotype.Repository;

import com.lzp.common.hibernate.SimpleHibernateDao;
import com.lzp.dao.entity.SecUserRole;

@Repository
public class RoleUserDao extends SimpleHibernateDao<SecUserRole, String>{

}
