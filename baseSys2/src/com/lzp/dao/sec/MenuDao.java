package com.lzp.dao.sec;

import org.springframework.stereotype.Component;

import com.lzp.common.hibernate.HibernateDao;
import com.lzp.dao.entity.SecMenu;

@Component
public class MenuDao extends HibernateDao<SecMenu, String>{

}
