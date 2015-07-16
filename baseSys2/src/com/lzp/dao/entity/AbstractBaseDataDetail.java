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
 * AbstractBaseDataDetail entity provides the base persistence definition of the BaseDataDetail entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractBaseDataDetail  implements java.io.Serializable {


    // Fields    

     private String dataDetailId;
     private BaseData baseData;
     private String dataDetailCode;
     private String dataDetailName;
     private Boolean isValid;


    // Constructors

    /** default constructor */
    public AbstractBaseDataDetail() {
    }

    
    /** full constructor */
    public AbstractBaseDataDetail(BaseData baseData, String dataDetailCode, String dataDetailName, Boolean isValid) {
        this.baseData = baseData;
        this.dataDetailCode = dataDetailCode;
        this.dataDetailName = dataDetailName;
        this.isValid = isValid;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="guid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="DATA_DETAIL_ID", unique=true, nullable=false, length=32)

    public String getDataDetailId() {
        return this.dataDetailId;
    }
    
    public void setDataDetailId(String dataDetailId) {
        this.dataDetailId = dataDetailId;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="DATA_ID")

    public BaseData getBaseData() {
        return this.baseData;
    }
    
    public void setBaseData(BaseData baseData) {
        this.baseData = baseData;
    }
    
    @Column(name="DATA_DETAIL_CODE", length=32)

    public String getDataDetailCode() {
        return this.dataDetailCode;
    }
    
    public void setDataDetailCode(String dataDetailCode) {
        this.dataDetailCode = dataDetailCode;
    }
    
    @Column(name="DATA_DETAIL_NAME", length=60)

    public String getDataDetailName() {
        return this.dataDetailName;
    }
    
    public void setDataDetailName(String dataDetailName) {
        this.dataDetailName = dataDetailName;
    }
    
    @Column(name="IS_VALID", precision=1, scale=0)

    public Boolean getIsValid() {
        return this.isValid;
    }
    
    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }
   








}