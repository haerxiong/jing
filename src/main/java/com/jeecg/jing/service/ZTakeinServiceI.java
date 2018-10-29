package com.jeecg.jing.service;
import com.jeecg.jing.entity.ZTakeinEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZTakeinServiceI extends CommonService{
	
 	public void delete(ZTakeinEntity entity) throws Exception;
 	
 	public Serializable save(ZTakeinEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZTakeinEntity entity) throws Exception;
 	
}
