package com.lzp.dao.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

/**
 * AbstractSecAuthority entity provides the base persistence definition of the
 * SecAuthority entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractSecAuthority implements java.io.Serializable {

	// Fields

	private String authorityId;
	private String authorityCode;
	private String authorityName;

	// Constructors

	/** default constructor */
	public AbstractSecAuthority() {
	}

	/** full constructor */
	public AbstractSecAuthority(String authorityCode, String authorityName) {
		this.authorityCode = authorityCode;
		this.authorityName = authorityName;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "AUTHORITY_ID", unique = true, nullable = false, length = 32)
	public String getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	@Column(name = "AUTHORITY_CODE", length = 32)
	public String getAuthorityCode() {
		return this.authorityCode;
	}

	public void setAuthorityCode(String authorityCode) {
		this.authorityCode = authorityCode;
	}

	@Column(name = "AUTHORITY_NAME", length = 60)
	public String getAuthorityName() {
		return this.authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

}