package com.lzp.dao.sec;

import java.util.List;

import org.hibernate.SQLQuery;

import com.lzp.common.hibernate.HibernateDao;
import com.lzp.dao.entity.TreeView;

public class TreeViewDao extends HibernateDao<TreeView, String>{
	public List<TreeView> queryTree(String roleid, String id) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select f.functionid as id, f.functionname as text, f.parents as pid,s.checked ");
		sql.append(" from sys_function f ");
		sql.append(" left join (select f.functionid,f.functionname,'1' as checked from sys_role r ");
		sql.append("            left join sys_rolefunction rf on r.roleid = rf.roleid ");
		sql.append("            left join sys_function f  on f.functionid = rf.functionid ");
		sql.append("            where r.roleid = '"+roleid+"' ) s ");
		sql.append(" on s.functionid = f.functionid ");
		sql.append(" where 1 = 1 ");
		sql.append(" and f.parents =  " + id);
		sql.append(" order by f.functioncode ");
		SQLQuery sqlQuery= createSQLQuery(sql.toString());
		List<TreeView> list = sqlQuery.list();
		return list;
	}
}
