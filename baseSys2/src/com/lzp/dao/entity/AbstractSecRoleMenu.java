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
 * AbstractSecRoleMenu entity provides the base persistence definition of the SecRoleMenu entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractSecRoleMenu  implements java.io.Serializable {


    // Fields    

     private String roleMenuId;
     private SecMenu secMenu;
     private SecRole secRole;


    // Constructors

    /** default constructor */
    public AbstractSecRoleMenu() {
    }

    
    /** full constructor */
    public AbstractSecRoleMenu(SecMenu secMenu, SecRole secRole) {
        this.secMenu = secMenu;
        this.secRole = secRole;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="guid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="ROLE_MENU_ID", unique=true, nullable=false, length=32)

    public String getRoleMenuId() {
        return this.roleMenuId;
    }
    
    public void setRoleMenuId(String roleMenuId) {
        this.roleMenuId = roleMenuId;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="MENU_ID")

    public SecMenu getSecMenu() {
        return this.secMenu;
    }
    
    public void setSecMenu(SecMenu secMenu) {
        this.secMenu = secMenu;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="ROLE_ID")

    public SecRole getSecRole() {
        return this.secRole;
    }
    
    public void setSecRole(SecRole secRole) {
        this.secRole = secRole;
    }
   








}