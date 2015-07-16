package com.lzp.dao.sec;

import org.springframework.stereotype.Repository;

import com.lzp.common.hibernate.SimpleHibernateDao;
import com.lzp.dao.entity.SecRoleAuthority;

@Repository
public class RoleAuthorityDao extends SimpleHibernateDao<SecRoleAuthority, String>{

}
