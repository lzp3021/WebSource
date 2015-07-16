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
 * AbstractSecUserAuthority entity provides the base persistence definition of
 * the SecUserAuthority entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractSecUserAuthority implements java.io.Serializable {

	// Fields

	private String userAuthortyId;
	private SecAuthority secAuthority;
	private SecUser secUser;

	// Constructors

	/** default constructor */
	public AbstractSecUserAuthority() {
	}

	/** full constructor */
	public AbstractSecUserAuthority(SecAuthority secAuthority, SecUser secUser) {
		this.secAuthority = secAuthority;
		this.secUser = secUser;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "USER_AUTHORTY_ID", unique = true, nullable = false, length = 32)
	public String getUserAuthortyId() {
		return this.userAuthortyId;
	}

	public void setUserAuthortyId(String userAuthortyId) {
		this.userAuthortyId = userAuthortyId;
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
	@JoinColumn(name = "USER_ID", nullable = false)
	public SecUser getSecUser() {
		return this.secUser;
	}

	public void setSecUser(SecUser secUser) {
		this.secUser = secUser;
	}

}