package com.jeecg.jing.service;
import com.jeecg.jing.entity.ZReturnEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZReturnServiceI extends CommonService{
	
 	public void delete(ZReturnEntity entity) throws Exception;
 	
 	public Serializable save(ZReturnEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZReturnEntity entity) throws Exception;
 	
}
