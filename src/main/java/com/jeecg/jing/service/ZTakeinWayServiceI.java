package com.jeecg.jing.service;
import com.jeecg.jing.entity.ZTakeinWayEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZTakeinWayServiceI extends CommonService{
	
 	public void delete(ZTakeinWayEntity entity) throws Exception;
 	
 	public Serializable save(ZTakeinWayEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZTakeinWayEntity entity) throws Exception;
 	
}
