package com.lzp.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * BaseData entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="BASE_DATA"
    ,schema="CASIT"
)
public class BaseData extends AbstractBaseData implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public BaseData() {
    }

    
    /** full constructor */
    public BaseData(String dataCode, String dataName, Boolean isValid) {
        super(dataCode, dataName, isValid);        
    }
   
}
