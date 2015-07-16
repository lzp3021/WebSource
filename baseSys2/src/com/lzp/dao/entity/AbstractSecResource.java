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
 * AbstractSecResource entity provides the base persistence definition of the
 * SecResource entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractSecResource implements java.io.Serializable {

	// Fields

	private String resourceId;
	private SecMenu secMenu;
	private String resourceCode;
	private String resourceContent;
	private String resourceType;
	private Boolean isValid;

	// Constructors

	/** default constructor */
	public AbstractSecResource() {
	}

	/** full constructor */
	public AbstractSecResource(SecMenu secMenu, String resourceCode,
			String resourceContent, String resourceType, Boolean isValid) {
		this.secMenu = secMenu;
		this.resourceCode = resourceCode;
		this.resourceContent = resourceContent;
		this.resourceType = resourceType;
		this.isValid = isValid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "RESOURCE_ID", unique = true, nullable = false, length = 32)
	public String getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MENU_ID")
	public SecMenu getSecMenu() {
		return this.secMenu;
	}

	public void setSecMenu(SecMenu secMenu) {
		this.secMenu = secMenu;
	}

	@Column(name = "RESOURCE_CODE", length = 32)
	public String getResourceCode() {
		return this.resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	@Column(name = "RESOURCE_CONTENT", length = 200)
	public String getResourceContent() {
		return this.resourceContent;
	}

	public void setResourceContent(String resourceContent) {
		this.resourceContent = resourceContent;
	}

	@Column(name = "RESOURCE_TYPE", length = 32)
	public String getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	@Column(name = "IS_VALID", precision = 1, scale = 0)
	public Boolean getIsValid() {
		return this.isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

}