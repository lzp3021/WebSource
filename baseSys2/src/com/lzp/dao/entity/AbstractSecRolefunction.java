package com.lzp.dao.entity;

import java.math.BigDecimal;

/**
 * AbstractSysRolefunction entity provides the base persistence definition of
 * the SysRolefunction entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSecRolefunction implements java.io.Serializable {

	// Fields

	private BigDecimal rolefunctionid;
	private BigDecimal roleid;
	private BigDecimal functionid;
	private String operationtype;
	private BigDecimal isgray;

	// Constructors

	/** default constructor */
	public AbstractSecRolefunction() {
	}

	/** minimal constructor */
	public AbstractSecRolefunction(BigDecimal rolefunctionid,
			BigDecimal roleid, BigDecimal functionid, BigDecimal isgray) {
		this.rolefunctionid = rolefunctionid;
		this.roleid = roleid;
		this.functionid = functionid;
		this.isgray = isgray;
	}

	/** full constructor */
	public AbstractSecRolefunction(BigDecimal rolefunctionid,
			BigDecimal roleid, BigDecimal functionid, String operationtype,
			BigDecimal isgray) {
		this.rolefunctionid = rolefunctionid;
		this.roleid = roleid;
		this.functionid = functionid;
		this.operationtype = operationtype;
		this.isgray = isgray;
	}

	// Property accessors

	public BigDecimal getRolefunctionid() {
		return this.rolefunctionid;
	}

	public void setRolefunctionid(BigDecimal rolefunctionid) {
		this.rolefunctionid = rolefunctionid;
	}

	public BigDecimal getRoleid() {
		return this.roleid;
	}

	public void setRoleid(BigDecimal roleid) {
		this.roleid = roleid;
	}

	public BigDecimal getFunctionid() {
		return this.functionid;
	}

	public void setFunctionid(BigDecimal functionid) {
		this.functionid = functionid;
	}

	public String getOperationtype() {
		return this.operationtype;
	}

	public void setOperationtype(String operationtype) {
		this.operationtype = operationtype;
	}

	public BigDecimal getIsgray() {
		return this.isgray;
	}

	public void setIsgray(BigDecimal isgray) {
		this.isgray = isgray;
	}

}