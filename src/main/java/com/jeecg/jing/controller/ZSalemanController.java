package com.jeecg.jing.controller;
import com.jeecg.jing.entity.ZSalemanEntity;
import com.jeecg.jing.service.ZSalemanServiceI;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * @Description: 销售员
 * @author onlineGenerator
 * @date 2018-11-02 13:11:07
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/zSalemanController")
public class ZSalemanController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(ZSalemanController.class);

	@Autowired
	private ZSalemanServiceI zSalemanService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 销售员列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/jing/zSalemanList");
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
	public void datagrid(ZSalemanEntity zSaleman,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZSalemanEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zSaleman, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zSalemanService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除销售员
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ZSalemanEntity zSaleman, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		zSaleman = systemService.getEntity(ZSalemanEntity.class, zSaleman.getId());
		message = "销售员删除成功";
		try{
			zSalemanService.delete(zSaleman);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "销售员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除销售员
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "销售员删除成功";
		try{
			for(String id:ids.split(",")){
				ZSalemanEntity zSaleman = systemService.getEntity(ZSalemanEntity.class, 
				id
				);
				zSalemanService.delete(zSaleman);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "销售员删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加销售员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ZSalemanEntity zSaleman, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "销售员添加成功";
		try{
			zSalemanService.save(zSaleman);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "销售员添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新销售员
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ZSalemanEntity zSaleman, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "销售员更新成功";
		try {
			ZSalemanEntity t = null;
			if(!StringUtils.isEmpty(zSaleman.getId())) {
				t = zSalemanService.get(ZSalemanEntity.class, zSaleman.getId());
			} else if(!StringUtils.isEmpty(zSaleman.getSaleName())) {
				List<ZSalemanEntity> s = zSalemanService.findByProperty(ZSalemanEntity.class, "saleName", zSaleman.getSaleName());
				if(s.size() > 0) {
					t = s.get(0);
				}
			}

			if(t != null) {
				MyBeanUtils.copyBeanNotNull2Bean(zSaleman, t);
				zSalemanService.saveOrUpdate(t);
			} else {
				zSalemanService.save(zSaleman);
			}

			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "销售员更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 销售员新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ZSalemanEntity zSaleman, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zSaleman.getId())) {
			zSaleman = zSalemanService.getEntity(ZSalemanEntity.class, zSaleman.getId());
			req.setAttribute("zSaleman", zSaleman);
		}
		return new ModelAndView("com/jeecg/jing/zSaleman-add");
	}
	/**
	 * 销售员编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ZSalemanEntity zSaleman, HttpServletRequest req) {
		String saleName = zSaleman.getSaleName();
		if (StringUtil.isNotEmpty(zSaleman.getSaleName())) {
			try {
				saleName = new String(saleName.getBytes("iso-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			List<ZSalemanEntity> s = zSalemanService.findByProperty(ZSalemanEntity.class, "saleName", saleName);
			zSaleman = s.size() > 0 ? s.get(0) : new ZSalemanEntity();
			zSaleman.setSaleName(saleName);
//			zSaleman = zSalemanService.getEntity(ZSalemanEntity.class, zSaleman.getId());
			req.setAttribute("zSaleman", zSaleman);
		}
		return new ModelAndView("com/jeecg/jing/zSaleman-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","zSalemanController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(ZSalemanEntity zSaleman,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(ZSalemanEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zSaleman, request.getParameterMap());
		List<ZSalemanEntity> zSalemans = this.zSalemanService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"销售员");
		modelMap.put(NormalExcelConstants.CLASS,ZSalemanEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("销售员列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,zSalemans);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ZSalemanEntity zSaleman,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"销售员");
    	modelMap.put(NormalExcelConstants.CLASS,ZSalemanEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("销售员列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<ZSalemanEntity> listZSalemanEntitys = ExcelImportUtil.importExcel(file.getInputStream(),ZSalemanEntity.class,params);
				for (ZSalemanEntity zSaleman : listZSalemanEntitys) {
					zSalemanService.save(zSaleman);
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
