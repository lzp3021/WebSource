package com.lzp.dao.entity;

import java.math.BigDecimal;

/**
 * SysRolefunction entity. @author MyEclipse Persistence Tools
 */
public class SecRolefunction extends AbstractSecRolefunction implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public SecRolefunction() {
	}

	/** minimal constructor */
	public SecRolefunction(BigDecimal rolefunctionid, BigDecimal roleid,
			BigDecimal functionid, BigDecimal isgray) {
		super(rolefunctionid, roleid, functionid, isgray);
	}

	/** full constructor */
	public SecRolefunction(BigDecimal rolefunctionid, BigDecimal roleid,
			BigDecimal functionid, String operationtype, BigDecimal isgray) {
		super(rolefunctionid, roleid, functionid, operationtype, isgray);
	}

}
