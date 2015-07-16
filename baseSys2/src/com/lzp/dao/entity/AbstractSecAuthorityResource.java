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
 * AbstractSecAuthorityResource entity provides the base persistence definition
 * of the SecAuthorityResource entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractSecAuthorityResource implements
		java.io.Serializable {

	// Fields

	private String userRoleId;
	private SecAuthority secAuthority;
	private SecResource secResource;

	// Constructors

	/** default constructor */
	public AbstractSecAuthorityResource() {
	}

	/** full constructor */
	public AbstractSecAuthorityResource(SecAuthority secAuthority,
			SecResource secResource) {
		this.secAuthority = secAuthority;
		this.secResource = secResource;
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
	@JoinColumn(name = "AUTHORITY_ID", nullable = false)
	public SecAuthority getSecAuthority() {
		return this.secAuthority;
	}

	public void setSecAuthority(SecAuthority secAuthority) {
		this.secAuthority = secAuthority;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RESOURCE_ID", nullable = false)
	public SecResource getSecResource() {
		return this.secResource;
	}

	public void setSecResource(SecResource secResource) {
		this.secResource = secResource;
	}

}