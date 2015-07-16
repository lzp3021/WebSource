package com.lzp.dao.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

/**
 * AbstractSecUser entity provides the base persistence definition of the
 * SecUser entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractSecUser implements java.io.Serializable {

	// Fields

	private String userId;
	private String userCode;
	private String password;
	private String userName;

	// Constructors

	/** default constructor */
	public AbstractSecUser() {
	}

	/** full constructor */
	public AbstractSecUser(String userCode, String password, String userName) {
		this.userCode = userCode;
		this.password = password;
		this.userName = userName;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "USER_ID", unique = true, nullable = false, length = 32)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "USER_CODE", length = 50)
	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Column(name = "PASSWORD", length = 60)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "USER_NAME", length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}