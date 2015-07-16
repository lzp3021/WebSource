package com.lzp.web.base;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzp.common.DatagridMsg;
import com.lzp.common.EasyPage;
import com.lzp.dao.entity.BaseData;
import com.lzp.dao.entity.BaseDataDetail;
import com.lzp.service.base.BaseDataManager;
import com.lzp.web.AuthorityResourceAction;

@Controller
@RequestMapping("baseDataAction")
public class BaseDataAction {
	private static Logger logger = LoggerFactory.getLogger(AuthorityResourceAction.class);
	
	@Autowired
	private BaseDataManager baseDataManager;
	@RequestMapping(value = "/list")
	public String list() {
		return "base/baseData";
	}
	
	@RequestMapping(value = "/findBaseDataPage")
	@ResponseBody
	public EasyPage<BaseData> findBaseDataPage(EasyPage<BaseData> easyPage,BaseData baseData) {
		return baseDataManager.findBaseDataPage(easyPage, baseData);
	}
	
	
	@RequestMapping(value = "/findBaseDataDetailPage")
	@ResponseBody
	public EasyPage<BaseDataDetail> findBaseDataDetailPage(EasyPage<BaseDataDetail> easyPage
			,BaseData baseData,BaseDataDetail baseDataDetail) {
		return baseDataManager.findBaseDataDetailPage(easyPage, baseData,baseDataDetail);
	}
	
	@RequestMapping(value = "/saveData")
	@ResponseBody
	public DatagridMsg saveData(BaseData baseData){
		try {
			baseDataManager.saveData(baseData);
			return new DatagridMsg();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new DatagridMsg(true,e.getMessage());
		}
	}
	
	@RequestMapping(value = "/updateData")
	@ResponseBody
	public DatagridMsg updateData(BaseData baseData){
		try {
			baseDataManager.updateData(baseData);
			return new DatagridMsg();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new DatagridMsg(true,e.getMessage());
		}
	}
	

	@RequestMapping(value = "/saveDataDetail")
	@ResponseBody
	public DatagridMsg saveDataDetail(BaseData baseData,BaseDataDetail baseDataDetail){
		try {
			baseDataDetail.setBaseData(baseData);
			baseDataManager.saveDataDetail(baseDataDetail);
			return new DatagridMsg();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new DatagridMsg(true,e.getMessage());
		}
	}
	
	@RequestMapping(value = "/updateDataDetail")
	@ResponseBody
	public DatagridMsg updateDataDetail(BaseData baseData,BaseDataDetail baseDataDetail){
		try {
			baseDataDetail.setBaseData(baseData);
			baseDataManager.updateDataDetail(baseDataDetail);
			return new DatagridMsg();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new DatagridMsg(true,e.getMessage());
		}
	}
	
	@RequestMapping(value = "/findCacheBaseData")
	@ResponseBody
	public List<BaseDataDetail> findCacheBaseData(BaseData baseData){
		return baseDataManager.findCacheBaseData(baseData);
	}
}
