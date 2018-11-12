package com.jeecg.jing.service.impl;
import com.jeecg.jing.entity.ZSalemanEntity;
import com.jeecg.jing.service.ZSalemanServiceI;
import com.jeecg.jing.service.ZTakeinServiceI;
import com.sun.javafx.binding.StringFormatter;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.jing.entity.ZTakeinEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
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
		beforeSave(entity);
		Serializable t = super.save(entity);
		saveSaleman(entity);
		return t;
 	}

	private void beforeSave(ZTakeinEntity entity) throws Exception {
		// 其他校验
		List<ZTakeinEntity> idCard = findByProperty(ZTakeinEntity.class, "idCard", entity.getIdCard());
		if(idCard.size() > 0 && entity.getSaleName() != null && entity.getSaleName().equals(idCard.get(0))) {
			throw new RuntimeException(StringFormatter.format("客户[%s]已由销售[%s]负责", entity.getCustomName(), entity.getSaleName()).get());
		}
		List<ZTakeinEntity> contract = findByProperty(ZTakeinEntity.class, "contract", entity.getContract());
		if(idCard.size() > 0) {
			throw new RuntimeException(StringFormatter.format("合同号[%s]已存在", entity.getContract()).get());
		}

		// 设置到期时间
		try {
			if(entity.getEndTime() == null && entity.getTakeinTime() != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(entity.getTakeinTime());
				cal.add(Calendar.MONTH, Integer.parseInt(entity.getTimeLimit()));
				entity.setEndTime(cal.getTime());
			}
		} catch (NumberFormatException e) {
			// 活期不设置到期时间
		}
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
		beforeSave(entity);
		super.saveOrUpdate(entity);
		saveSaleman(entity);
	}
}