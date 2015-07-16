package com.lzp.dao.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * SecMenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEC_MENU")
public class SecMenu extends AbstractSecMenu implements java.io.Serializable {
	public final static String OPEN = "open";
	public final static String CLOSED = "closed";

	private String id;
	private String text;
	private String iconCls;
	private Boolean checked;// Whether the node is checked.
	private String state;// The node state, 'open' or 'closed'.
	private String attributes;

	// Constructors

	/** default constructor */
	public SecMenu() {
	}

	@Transient
	public String getId() {
		return getMenuId() == null ? null : getMenuId();
	}

	public void setId(String id) {
		this.id = id;
	}

	@Transient
	public String getText() {
		return getMenuName() == null ? null : getMenuName();
	}

	public void setText(String text) {
		this.text = text;
	}

	@Transient
	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	@Transient
	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	@Transient
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Transient
	public String getAttributes() {
		return getMenuUrl() == null ? null : getMenuUrl();
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

}
