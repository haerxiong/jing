package com.jeecg.jing.service.impl;
import com.jeecg.jing.entity.ZSalemanEntity;
import com.jeecg.jing.service.ZSalemanServiceI;
import com.jeecg.jing.service.ZTakeinServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.jing.entity.ZTakeinEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

import org.jeecgframework.minidao.util.FreemarkerParseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.util.StringUtils;

@Service("zTakeinService")
@Transactional
public class ZTakeinServiceImpl extends CommonServiceImpl implements ZTakeinServiceI {

	@Autowired
	private ZSalemanServiceI zSalemanServiceI;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(ZTakeinEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(ZTakeinEntity entity) throws Exception{
 		Serializable t = super.save(entity);
		saveSaleman(entity);
		return t;
 	}

	private void saveSaleman(ZTakeinEntity entity) throws Exception {
		// 查询销售姓名是否存在，不存在，自动保存
		if(!StringUtils.isEmpty(entity.getSaleName())) {
			List<ZSalemanEntity> saleName = zSalemanServiceI.findByProperty(ZSalemanEntity.class, "saleName", entity.getSaleName());
			if(saleName.size() < 1) {
				ZSalemanEntity saleman = new ZSalemanEntity();
				saleman.setId(UUID.randomUUID().toString());
				saleman.setSaleName(entity.getSaleName());
				zSalemanServiceI.save(saleman);
			}
		}
	}

	public void saveOrUpdate(ZTakeinEntity entity) throws Exception{
		saveSaleman(entity);
 		super.saveOrUpdate(entity);
 	}
 	
}