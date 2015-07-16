package com.lzp.dao.entity;

import java.beans.Transient;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * BaseDataDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="BASE_DATA_DETAIL"
    ,schema="CASIT"
)
public class BaseDataDetail extends AbstractBaseDataDetail implements java.io.Serializable {

	private String dataCode;
    // Constructors

    /** default constructor */
    public BaseDataDetail() {
    }

    
    /** full constructor */
    public BaseDataDetail(BaseData baseData, String dataDetailCode, String dataDetailName, Boolean isValid) {
        super(baseData, dataDetailCode, dataDetailName, isValid);        
    }

    @Transient
	public String getDataCode() {
		return dataCode;
	}


	public void setDataCode(String dataCode) {
		this.dataCode = dataCode;
	}
   
}
