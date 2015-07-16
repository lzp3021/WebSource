package com.lzp.dao.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

/**
 * AbstractSecMenu entity provides the base persistence definition of the
 * SecMenu entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractSecMenu implements java.io.Serializable {

	// Fields

	private String menuId;
	private String parentId;
	private String menuCode;
	private String menuName;
	private String menuUrl;
	private Boolean isLeaf;

	// Constructors

	/** default constructor */
	public AbstractSecMenu() {
	}

	/** full constructor */
	public AbstractSecMenu(String parentId, String menuCode, String menuName,
			String menuUrl, Boolean isLeaf) {
		this.parentId = parentId;
		this.menuCode = menuCode;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.isLeaf = isLeaf;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "MENU_ID", unique = true, nullable = false, length = 32)
	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	@Column(name = "PARENT_ID", length = 32)
	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name = "MENU_CODE", length = 32)
	public String getMenuCode() {
		return this.menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	@Column(name = "MENU_NAME", length = 60)
	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Column(name = "MENU_URL", length = 200)
	public String getMenuUrl() {
		return this.menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	@Column(name = "IS_LEAF", precision = 1, scale = 0)
	public Boolean getIsLeaf() {
		return this.isLeaf;
	}

	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

}