package com.jeecg.jing.controller;
import com.jeecg.jing.entity.ZTakeinEntity;
import com.jeecg.jing.entity.ZTakeinWayEntity;
import com.jeecg.jing.service.ZTakeinWayServiceI;

import java.text.SimpleDateFormat;
import java.util.*;
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
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * @Title: Controller  
 * @Description: 入金方式表
 * @author onlineGenerator
 * @date 2018-11-05 14:21:28
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/zTakeinWayController")
public class ZTakeinWayController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(ZTakeinWayController.class);

	@Autowired
	private ZTakeinWayServiceI zTakeinWayService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 入金方式表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/jing/zTakeinWayList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ZTakeinWayEntity zTakeinWay,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//		CriteriaQuery cq = new CriteriaQuery(ZTakeinWayEntity.class, dataGrid);
		CriteriaQuery cq = new CriteriaQuery(ZTakeinEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zTakeinWay, request.getParameterMap());
		try{
		//自定义追加查询条件
			String takeinTime = request.getParameter("takeinTime");
			if(StringUtil.isNotEmpty(takeinTime)) {
				SimpleDateFormat start = new SimpleDateFormat("yyyy-MM-dd");
				Date startDate = start.parse(takeinTime);
				Date endDate = new Date(startDate.getTime() + 24*3600*1000);
				cq.ge("takeinTime", startDate);
				cq.lt("takeinTime", endDate);
			}
			cq.notEq("status", "3");
			cq.getDetachedCriteria().createCriteria("zTakeinWayEntity", JoinType.LEFT_OUTER_JOIN);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zTakeinWayService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除入金方式表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ZTakeinWayEntity zTakeinWay, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		zTakeinWay = systemService.getEntity(ZTakeinWayEntity.class, zTakeinWay.getId());
		message = "入金方式表删除成功";
		try{
			zTakeinWayService.delete(zTakeinWay);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "入金方式表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除入金方式表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "入金方式表删除成功";
		try{
			for(String id:ids.split(",")){
				ZTakeinWayEntity zTakeinWay = systemService.getEntity(ZTakeinWayEntity.class, 
				id
				);
				zTakeinWayService.delete(zTakeinWay);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "入金方式表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加入金方式表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ZTakeinWayEntity zTakeinWay, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "入金方式表添加成功";
		try{
			zTakeinWayService.save(zTakeinWay);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "入金方式表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新入金方式表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ZTakeinWayEntity zTakeinWay, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "入金方式表更新成功";
		try {
			if(StringUtils.isEmpty(zTakeinWay.getId())) {
				zTakeinWayService.save(zTakeinWay);
			} else {
				ZTakeinWayEntity t = zTakeinWayService.get(ZTakeinWayEntity.class, zTakeinWay.getId());
				MyBeanUtils.copyBeanNotNull2Bean(zTakeinWay, t);
				zTakeinWayService.saveOrUpdate(t);
			}
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "入金方式表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 入金方式表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ZTakeinWayEntity zTakeinWay, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zTakeinWay.getId())) {
			zTakeinWay = zTakeinWayService.getEntity(ZTakeinWayEntity.class, zTakeinWay.getId());
			req.setAttribute("zTakeinWay", zTakeinWay);
		}
		return new ModelAndView("com/jeecg/jing/zTakeinWay-add");
	}
	/**
	 * 入金方式表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ZTakeinWayEntity zTakeinWay, HttpServletRequest req) {
		String takeinId = zTakeinWay.getId();
		if (StringUtil.isNotEmpty(zTakeinWay.getId())) {
//			zTakeinWay = zTakeinWayService.getEntity(ZTakeinWayEntity.class, zTakeinWay.getId());
			List<ZTakeinWayEntity> s = zTakeinWayService.findByProperty(ZTakeinWayEntity.class, "takeinId", takeinId);
			zTakeinWay = s.size() > 0 ? s.get(0) : new ZTakeinWayEntity();
			zTakeinWay.setTakeinId(takeinId);
			req.setAttribute("zTakeinWay", zTakeinWay);
		}
		return new ModelAndView("com/jeecg/jing/zTakeinWay-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","zTakeinWayController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(ZTakeinWayEntity zTakeinWay,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(ZTakeinWayEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zTakeinWay, request.getParameterMap());
		List<ZTakeinWayEntity> zTakeinWays = this.zTakeinWayService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"入金方式表");
		modelMap.put(NormalExcelConstants.CLASS,ZTakeinWayEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("入金方式表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,zTakeinWays);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ZTakeinWayEntity zTakeinWay,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"入金方式表");
    	modelMap.put(NormalExcelConstants.CLASS,ZTakeinWayEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("入金方式表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<ZTakeinWayEntity> listZTakeinWayEntitys = ExcelImportUtil.importExcel(file.getInputStream(),ZTakeinWayEntity.class,params);
				for (ZTakeinWayEntity zTakeinWay : listZTakeinWayEntitys) {
					zTakeinWayService.save(zTakeinWay);
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
