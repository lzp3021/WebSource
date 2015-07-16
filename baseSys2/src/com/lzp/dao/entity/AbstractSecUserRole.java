package com.lzp.dao.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

/**
 * AbstractSecUserRole entity provides the base persistence definition of the
 * SecUserRole entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractSecUserRole implements java.io.Serializable {

	// Fields

	private String userRoleId;
	private SecUser secUser;
	private SecRole secRole;

	// Constructors

	/** default constructor */
	public AbstractSecUserRole() {
	}

	/** full constructor */
	public AbstractSecUserRole(SecUser secUser, SecRole secRole) {
		this.secUser = secUser;
		this.secRole = secRole;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "USER_ROLE_ID", unique = true, nullable = false, length = 32)
	public String getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	public SecUser getSecUser() {
		return this.secUser;
	}

	public void setSecUser(SecUser secUser) {
		this.secUser = secUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID", nullable = false)
	public SecRole getSecRole() {
		return this.secRole;
	}

	public void setSecRole(SecRole secRole) {
		this.secRole = secRole;
	}

}