package com.jeecg.jing.service;
import com.jeecg.jing.entity.ZSaleEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZSaleServiceI extends CommonService{
	
 	public void delete(ZSaleEntity entity) throws Exception;
 	
 	public Serializable save(ZSaleEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZSaleEntity entity) throws Exception;
 	
}
