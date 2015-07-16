package com.lzp.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class TreeView {
	private String id;
	private String pid;
	private String text;
	private String iconCls;
	private boolean checked;
	private Object attribute;
	private List<TreeView> children = new ArrayList<TreeView>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public Object getAttribute() {
		return attribute;
	}
	public void setAttribute(Object attribute) {
		this.attribute = attribute;
	}
	public List<TreeView> getChildren() {
		return children;
	}
	public void setChildren(List<TreeView> children) {
		this.children = children;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	
}
