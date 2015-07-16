package com.lzp.service.base;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lzp.common.EasyPage;
import com.lzp.dao.base.BaseDataDao;
import com.lzp.dao.base.BaseDataDetailDao;
import com.lzp.dao.entity.BaseData;
import com.lzp.dao.entity.BaseDataDetail;

@Service
public class BaseDataManager {
	@Autowired
	private BaseDataDao baseDataDao;
	@Autowired
	private BaseDataDetailDao baseDataDetailDao;

	public EasyPage<BaseData> findBaseDataPage(EasyPage<BaseData> page,
			BaseData baseData) {
		DetachedCriteria dc = DetachedCriteria.forClass(BaseData.class);
		return baseDataDao.findEasyPage(page, dc);
	}

	public EasyPage<BaseDataDetail> findBaseDataDetailPage(
			EasyPage<BaseDataDetail> page, BaseData baseData,
			BaseDataDetail baseDataDetail) {
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDataDetail.class);
		if(StringUtils.isNotEmpty(baseData.getDataId())){
			dc.add(Property.forName("baseData.dataId").eq(baseData.getDataId()));
		}
		return baseDataDetailDao.findEasyPage(page, dc);
	}

	@CacheEvict(value="mobileCache",allEntries=true) 
	public void saveData(BaseData baseData) {
		baseDataDao.save(baseData);
	}
	
	@CacheEvict(value="mobileCache",allEntries=true) 
	public void updateData(BaseData baseData) {
		baseDataDao.update(baseData);
	}

	@CacheEvict(value="mobileCache",allEntries=true) 
	public void saveDataDetail(BaseDataDetail baseDataDetail) {
		baseDataDetailDao.save(baseDataDetail);
	}

	@CacheEvict(value="mobileCache",allEntries=true) 
	public void updateDataDetail(BaseDataDetail baseDataDetail) {
		baseDataDetailDao.update(baseDataDetail);
	}

	@Cacheable(value="mobileCache",key="#baseData.dataCode")  
	public List<BaseDataDetail> findCacheBaseData(BaseData baseData) {
		System.out.println("test");
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDataDetail.class);
		dc.createAlias("baseData", "baseData");
		dc.add(Property.forName("baseData.dataCode").eq(baseData.getDataCode()));
		return baseDataDetailDao.find(dc);
	}

}
