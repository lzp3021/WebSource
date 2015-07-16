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
 * AbstractSecRoleAuthority entity provides the base persistence definition of
 * the SecRoleAuthority entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractSecRoleAuthority implements java.io.Serializable {

	// Fields

	private String roleAuthorityId;
	private SecAuthority secAuthority;
	private SecRole secRole;

	// Constructors

	/** default constructor */
	public AbstractSecRoleAuthority() {
	}

	/** full constructor */
	public AbstractSecRoleAuthority(SecAuthority secAuthority, SecRole secRole) {
		this.secAuthority = secAuthority;
		this.secRole = secRole;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ROLE_AUTHORITY_ID", unique = true, nullable = false, length = 32)
	public String getRoleAuthorityId() {
		return this.roleAuthorityId;
	}

	public void setRoleAuthorityId(String roleAuthorityId) {
		this.roleAuthorityId = roleAuthorityId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUTHORITY_ID", nullable = false)
	public SecAuthority getSecAuthority() {
		return this.secAuthority;
	}

	public void setSecAuthority(SecAuthority secAuthority) {
		this.secAuthority = secAuthority;
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