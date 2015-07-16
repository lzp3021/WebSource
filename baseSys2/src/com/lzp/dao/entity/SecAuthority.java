package com.lzp.dao.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * SecAuthority entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEC_AUTHORITY")
public class SecAuthority extends AbstractSecAuthority implements
		java.io.Serializable {
	// 权限管辖的资源列表（多对多关联）
	private List<SecResource> resources = new ArrayList<SecResource>();
	private Boolean isError;
	private String msg;

	// Constructors

	/** default constructor */
	public SecAuthority() {
	}

	@JsonIgnore 
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SEC_AUTHORITY_RESOURCE", joinColumns = { @JoinColumn(name = "AUTHORITY_ID") }, inverseJoinColumns = { @JoinColumn(name = "RESOURCE_ID") })
	public List<SecResource> getResources() {
		return resources;
	}

	public void setResources(List<SecResource> resources) {
		this.resources = resources;
	}

	@Transient
	public Boolean getIsError() {
		return isError;
	}

	public void setIsError(Boolean isError) {
		this.isError = isError;
	}

	@Transient
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
