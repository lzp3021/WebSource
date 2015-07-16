package com.lzp.dao.base;

import org.springframework.stereotype.Repository;

import com.lzp.common.hibernate.HibernateDao;
import com.lzp.dao.entity.BaseData;

@Repository
public class BaseDataDao extends HibernateDao<BaseData, String>{

}
