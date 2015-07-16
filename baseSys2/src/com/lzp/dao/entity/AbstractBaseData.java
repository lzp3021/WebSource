package com.lzp.dao.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;


/**
 * AbstractBaseData entity provides the base persistence definition of the BaseData entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractBaseData  implements java.io.Serializable {


    // Fields    

     private String dataId;
     private String dataCode;
     private String dataName;
     private Boolean isValid;


    // Constructors

    /** default constructor */
    public AbstractBaseData() {
    }

    
    /** full constructor */
    public AbstractBaseData(String dataCode, String dataName, Boolean isValid) {
        this.dataCode = dataCode;
        this.dataName = dataName;
        this.isValid = isValid;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="guid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="DATA_ID", unique=true, nullable=false, length=32)

    public String getDataId() {
        return this.dataId;
    }
    
    public void setDataId(String dataId) {
        this.dataId = dataId;
    }
    
    @Column(name="DATA_CODE", length=32)

    public String getDataCode() {
        return this.dataCode;
    }
    
    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }
    
    @Column(name="DATA_NAME", length=60)

    public String getDataName() {
        return this.dataName;
    }
    
    public void setDataName(String dataName) {
        this.dataName = dataName;
    }
    
    @Column(name="IS_VALID", precision=1, scale=0)

    public Boolean getIsValid() {
        return this.isValid;
    }
    
    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }
   








}