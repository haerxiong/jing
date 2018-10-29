package com.jeecg.jing.service;
import com.jeecg.jing.entity.CustomMoneyEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface CustomMoneyServiceI extends CommonService{
	
 	public void delete(CustomMoneyEntity entity) throws Exception;
 	
 	public Serializable save(CustomMoneyEntity entity) throws Exception;
 	
 	public void saveOrUpdate(CustomMoneyEntity entity) throws Exception;
 	
}
