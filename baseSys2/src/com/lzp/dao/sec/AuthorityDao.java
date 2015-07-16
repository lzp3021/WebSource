package com.lzp.dao.sec;

import org.springframework.stereotype.Repository;

import com.lzp.common.hibernate.HibernateDao;
import com.lzp.dao.entity.SecAuthority;

@Repository
public class AuthorityDao  extends HibernateDao<SecAuthority, String>{

}
