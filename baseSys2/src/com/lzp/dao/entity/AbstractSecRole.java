package com.lzp.dao.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

/**
 * AbstractSecRole entity provides the base persistence definition of the
 * SecRole entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractSecRole implements java.io.Serializable {

	// Fields

	private String roleId;
	private String roleCode;
	private String roleName;

	// Constructors

	/** default constructor */
	public AbstractSecRole() {
	}

	/** full constructor */
	public AbstractSecRole(String roleCode, String roleName) {
		this.roleCode = roleCode;
		this.roleName = roleName;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ROLE_ID", unique = true, nullable = false, length = 32)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "ROLE_CODE", length = 32)
	public String getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	@Column(name = "ROLE_NAME", length = 60)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}