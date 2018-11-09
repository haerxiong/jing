package com.jeecg.jing.controller;
import com.jeecg.jing.entity.ZSaleEntity;
import com.jeecg.jing.entity.ZTakeinEntity;
import com.jeecg.jing.service.ZSaleServiceI;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.sql.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * @Title: Controller  
 * @Description: 销售表
 * @author onlineGenerator
 * @date 2018-11-02 09:27:55
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/zSaleController")
public class ZSaleController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(ZSaleController.class);

	@Autowired
	private ZSaleServiceI zSaleService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 销售表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/jing/zSaleList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ZSaleEntity zSale,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//		CriteriaQuery cq = new CriteriaQuery(ZSaleEntity.class, dataGrid);
		CriteriaQuery cq = new CriteriaQuery(ZTakeinEntity.class, dataGrid);

		ZTakeinEntity zTakein = new ZTakeinEntity();
		String saleName = request.getParameter("saleName");
		if(StringUtil.isNotEmpty(saleName)) {
			zTakein.setSaleName(saleName);
		}
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zTakein, request.getParameterMap());
		try{
		//自定义追加查询条件
			cq.notEq("status", "3");
//			cq.getDetachedCriteria().createCriteria("zSaleEntity", JoinType.LEFT_OUTER_JOIN);
			cq.getDetachedCriteria().createCriteria("zSalemanEntity", JoinType.LEFT_OUTER_JOIN);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zSaleService.getDataGridReturn(cq, true);

		// 扩展‘年化合计、合计、业绩年化’字段
		Map<String, Map<String, Object>> map = new HashMap<String,Map<String,Object>>();
		List<Object[]> rs = systemService.findListbySql("select sum(a.amount) sum_amount, sum(a.amount*a.year_result) sum_year, a.sale_name" +
				" from(select z.id, z.amount,z.time_limit,z.sale_name," +
				"case WHEN z.time_limit in('3','6','12') then round(z.time_limit/12,2)" +
				"ELSE '0.08' end 'year_result'" +
				"from z_takein z) a GROUP BY a.sale_name");
		List<ZTakeinEntity> results = dataGrid.getResults();
		for (ZTakeinEntity z : results) {
			Map<String,Object> m = new HashMap<String,Object>();
			String sum_amount = "0";
			String sum_year = "0";
			BigDecimal year_result = new BigDecimal(0.08);
			try {
				for(Object[] item : rs) {
					if(z.getSaleName().equals(item[2])) {
						sum_amount = item[0].toString();
						sum_year = item[1].toString();
						break;
					}
				}
				if("3".equals(z.getTimeLimit()) || "6".equals(z.getTimeLimit()) || "9".equals(z.getTimeLimit()) || "12".equals(z.getTimeLimit())) {
					BigDecimal bd = new BigDecimal(z.getTimeLimit());
					year_result = bd.divide(new BigDecimal(12));
					year_result.setScale(2);
				}
				year_result = year_result.multiply(z.getAmount());
			} catch (Exception e) {
				e.printStackTrace();
			}
			m.put("sum_amount", sum_amount);
			m.put("sum_year", sum_year);
			m.put("year_result", year_result);
			map.put(z.getId(), m);
		}

		TagUtil.datagrid(response, dataGrid, map);
	}
	
	/**
	 * 删除销售表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ZSaleEntity zSale, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		zSale = systemService.getEntity(ZSaleEntity.class, zSale.getId());
		message = "销售表删除成功";
		try{
			zSaleService.delete(zSale);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "销售表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除销售表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "销售表删除成功";
		try{
			for(String id:ids.split(",")){
				ZSaleEntity zSale = systemService.getEntity(ZSaleEntity.class, 
				id
				);
				zSaleService.delete(zSale);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "销售表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加销售表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ZSaleEntity zSale, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "销售表添加成功";
		try{
			zSaleService.save(zSale);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "销售表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新销售表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ZSaleEntity zSale, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "销售表更新成功";
		try {
			if(StringUtils.isEmpty(zSale.getId())) {
				zSaleService.save(zSale);
			} else {
				ZSaleEntity t = zSaleService.get(ZSaleEntity.class, zSale.getId());
				MyBeanUtils.copyBeanNotNull2Bean(zSale, t);
				zSaleService.saveOrUpdate(t);
			}
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "销售表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 销售表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ZSaleEntity zSale, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zSale.getId())) {
			zSale = zSaleService.getEntity(ZSaleEntity.class, zSale.getId());
			req.setAttribute("zSale", zSale);
		}
		return new ModelAndView("com/jeecg/jing/zSale-add");
	}
	/**
	 * 销售表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ZSaleEntity zSale, HttpServletRequest req) {
		String takeinId = zSale.getId();
		if (StringUtil.isNotEmpty(takeinId)) {
//			zSale = zSaleService.getEntity(ZSaleEntity.class, zSale.getId());
			List<ZSaleEntity> s = zSaleService.findByProperty(ZSaleEntity.class, "takeinId", takeinId);
			zSale = s.size() > 0 ? s.get(0) : new ZSaleEntity();
			zSale.setTakeinId(takeinId);
			req.setAttribute("zSale", zSale);
		}
		return new ModelAndView("com/jeecg/jing/zSale-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","zSaleController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(ZSaleEntity zSale,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(ZSaleEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zSale, request.getParameterMap());
		List<ZSaleEntity> zSales = this.zSaleService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"销售表");
		modelMap.put(NormalExcelConstants.CLASS,ZSaleEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("销售表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,zSales);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ZSaleEntity zSale,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"销售表");
    	modelMap.put(NormalExcelConstants.CLASS,ZSaleEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("销售表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<ZSaleEntity> listZSaleEntitys = ExcelImportUtil.importExcel(file.getInputStream(),ZSaleEntity.class,params);
				for (ZSaleEntity zSale : listZSaleEntitys) {
					zSaleService.save(zSale);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	
}
