package com.jeecg.jing.controller;
import com.jeecg.jing.entity.*;
import com.jeecg.jing.service.ZSalemanServiceI;
import com.jeecg.jing.service.ZTakeinServiceI;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Subqueries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
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
 * @Description: 客户信息
 * @author onlineGenerator
 * @date 2018-11-01 09:53:32
 * @version V1.0
 *
 */
@Controller
@RequestMapping("/zTakeinController")
public class ZTakeinController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(ZTakeinController.class);

	@Autowired
	private ZTakeinServiceI zTakeinService;
	@Autowired
	private SystemService systemService;

	/**
	 * 客户信息列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String type = request.getParameter("type");
		String key = request.getParameter("key");

		String viewName = "com/jeecg/jing/zTakeinList";
		if("huizong".equals(type)) {
			viewName = "com/jeecg/jing/zTakeinList_huizong";
		}

		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("type", type);
		modelAndView.addObject("key", key);
		return modelAndView;
	}

	/**
	 * easyui AJAX请求数据
	 *
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ZTakeinEntity zTakein,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZTakeinEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zTakein, request.getParameterMap());
		try{
		//自定义追加查询条件
			selfSet(request, cq);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zTakeinService.getDataGridReturn(cq, true);

        Map<String, Map<String, Object>> map = new HashMap<String,Map<String,Object>>();
        List<String> rs = systemService.findListbySql("SELECT group_concat(r separator ',') from(SELECT CONCAT_WS('_', t.sale_name,count(1)) r from (SELECT DISTINCT a.sale_name, a.custom_name from z_takein a) t GROUP BY t.sale_name) a ");
        List<ZTakeinEntity> results = dataGrid.getResults();
        for (ZTakeinEntity z : results) {
            Map<String,Object> m = new HashMap<String,Object>();
            String s = "0";
            try {
                s = rs.get(0).split(z.getSaleName() + "_")[1].split(",")[0];
            } catch (Exception e) {
                e.printStackTrace();
            }
            m.put("count", s);
            map.put(z.getId(), m);
        }

		TagUtil.datagrid(response, dataGrid, map);
	}

	/*
	* 导出excel和查询公用方法
	**/
	private void selfSet(HttpServletRequest request, CriteriaQuery cq) {
		String type = request.getParameter("type");
		if(StringUtil.isNotEmpty(type)) {
            if("xianyou".equals(type)) {
                cq.notEq("status", "3");
            } else if("daoqi".equals(type)) {
                cq.eq("status", "2");
            } else if("huizong".equals(type)) {
                cq.eq("status", "1");
            }
        }

        // 月报表特殊处理
		String key = request.getParameter("key");
		String takeinTime = request.getParameter("takeinTime2");
		if("yue".equals(key) && StringUtil.isNotEmpty(takeinTime)) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date parse = format.parse(takeinTime);
				Calendar curMon = Calendar.getInstance();
				curMon.setTime(parse);
				curMon.set(Calendar.DAY_OF_MONTH, 1);
				Calendar nextMon = (Calendar) curMon.clone();
				nextMon.add(Calendar.MONTH, 1);
				cq.ge("takeinTime", curMon.getTime());
				cq.lt("takeinTime", nextMon.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 删除客户信息
	 *
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ZTakeinEntity zTakein, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		zTakein = systemService.getEntity(ZTakeinEntity.class, zTakein.getId());
		message = "客户信息删除成功";
		try{
			zTakeinService.delete(zTakein);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "客户信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除客户信息
	 *
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "客户信息删除成功";
		try{
			for(String id:ids.split(",")){
				ZTakeinEntity zTakein = systemService.getEntity(ZTakeinEntity.class,
				id
				);
				zTakeinService.delete(zTakein);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "客户信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加客户信息
	 *
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ZTakeinEntity zTakein, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "客户信息添加成功";
		try{
			zTakeinService.save(zTakein);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "客户信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 更新客户信息
	 *
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ZTakeinEntity zTakein, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "客户信息更新成功";
		if("2".equals(zTakein.getStatus())) {
			zTakein.setOutTime(new Date());
		}
		ZTakeinEntity t = zTakeinService.get(ZTakeinEntity.class, zTakein.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(zTakein, t);
			zTakeinService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "客户信息更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 客户信息新增页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ZTakeinEntity zTakein, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zTakein.getId())) {
			zTakein = zTakeinService.getEntity(ZTakeinEntity.class, zTakein.getId());
			req.setAttribute("zTakein", zTakein);
		}
		return new ModelAndView("com/jeecg/jing/zTakein-add");
	}
	/**
	 * 客户信息编辑页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ZTakeinEntity zTakein, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zTakein.getId())) {
			zTakein = zTakeinService.getEntity(ZTakeinEntity.class, zTakein.getId());
			req.setAttribute("zTakein", zTakein);
		}
		return new ModelAndView("com/jeecg/jing/zTakein-update");
	}

	/**
	 * 导入功能跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","zTakeinController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

	/**
	 * 导出excel
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(ZTakeinEntity zTakein,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(ZTakeinEntity.class, dataGrid);
		selfSet(request, cq);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zTakein, request.getParameterMap());
		List<ZTakeinEntity> zTakeins = this.zTakeinService.getListByCriteriaQuery(cq,false);

		List list = zTakeins;
		Class exportType = ZTakeinEntity.class;
		String type = request.getParameter("type");
		if(StringUtil.isNotEmpty(type)) {// 根据不同类型导出不同Excel模板
			list = new ArrayList();
			if("xianyou".equals(type)) {
				exportType = ZTakeinEntity_Xianyou.class;
			} else if("daoqi".equals(type)) {
				exportType = ZTakeinEntity_Daoqi.class;
			} else if("huizong".equals(type)) {
				exportType = ZTakeinEntity_Huizong.class;
			}
			Constructor constructor = exportType.getConstructors()[0];
			for(ZTakeinEntity z : zTakeins) {
				Object t = null;
				try {
					t = constructor.newInstance();
					BeanUtils.copyProperties(z, t, exportType);
					list.add(t);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		modelMap.put(NormalExcelConstants.FILE_NAME,"客户信息");
		modelMap.put(NormalExcelConstants.CLASS, exportType);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("客户信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST, list);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ZTakeinEntity zTakein,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"客户信息");
    	modelMap.put(NormalExcelConstants.CLASS,ZTakeinEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("客户信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<ZTakeinEntity> listZTakeinEntitys = ExcelImportUtil.importExcel(file.getInputStream(),ZTakeinEntity.class,params);
				for (ZTakeinEntity zTakein : listZTakeinEntitys) {
					zTakeinService.save(zTakein);
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
