package com.lzp.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * SecRoleMenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="SEC_ROLE_MENU"
    ,schema="TEST"
)
public class SecRoleMenu extends AbstractSecRoleMenu implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public SecRoleMenu() {
    }

    
    /** full constructor */
    public SecRoleMenu(SecMenu secMenu, SecRole secRole) {
        super(secMenu, secRole);        
    }
   
}
