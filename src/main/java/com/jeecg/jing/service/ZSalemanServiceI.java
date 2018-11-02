package com.jeecg.jing.service;
import com.jeecg.jing.entity.ZSalemanEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZSalemanServiceI extends CommonService{
	
 	public void delete(ZSalemanEntity entity) throws Exception;
 	
 	public Serializable save(ZSalemanEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZSalemanEntity entity) throws Exception;
 	
}
