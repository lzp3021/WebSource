package com.lzp.dao.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * SecResource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEC_RESOURCE")
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer", "$$_javassist" })
public class SecResource extends AbstractSecResource implements
		java.io.Serializable {

	// 资源所属权限列表（多对多关联）
	private List<SecAuthority> authorities = new ArrayList<SecAuthority>();

	// Constructors

	/** default constructor */
	public SecResource() {
	}

	@ManyToMany(mappedBy = "resources", fetch = FetchType.EAGER)
	@JsonIgnore
	public List<SecAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<SecAuthority> authorities) {
		this.authorities = authorities;
	}

}
