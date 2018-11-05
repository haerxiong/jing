<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="zTakeinWayList" checkbox="false" pagination="true" fitColumns="true" title="入金方式表" actionUrl="zTakeinWayController.do?datagrid" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="签单日期" formatter="yyyy-MM-dd"  field="createDate"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户姓名"  field="customName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入金时间" formatter="yyyy-MM-dd"  field="takeinTime"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="金额"  field="amount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="到期时间" formatter="yyyy-MM-dd"  field="endTime"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="付款方式"  field="zTakeinWayEntity.payType"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="zTakeinWayEntity.comment"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="150"></t:dgCol>
   <t:dgFunOpt funname="goud(id)" title="付款方式"  urlclass="ace_button"  urlfont="fa-edit"></t:dgFunOpt>
   <t:dgFunOpt funname="goud2(id)" title="客户信息"  urlclass="ace_button"  urlfont="fa-edit"></t:dgFunOpt>
   <%--<t:dgDelOpt title="删除" url="zTakeinWayController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="zTakeinWayController.do?goAdd" funname="add"  width="768"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zTakeinWayController.do?goUpdate" funname="update"  width="768"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zTakeinWayController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zTakeinWayController.do?goUpdate" funname="detail"  width="768"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });

 function goud(id) {
     createwindow('付款方式', 'zTakeinWayController.do?goUpdate&id='+id , 768, null);
 }
 function goud2(id) {
     createwindow('客户信息', 'zTakeinController.do?goUpdate&id='+id , 768, null);
 }

//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zTakeinWayController.do?upload', "zTakeinWayList");
}

//导出
function ExportXls() {
	JeecgExcelExport("zTakeinWayController.do?exportXls","zTakeinWayList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("zTakeinWayController.do?exportXlsByT","zTakeinWayList");
}

//bootstrap列表图片格式化
function btListImgFormatter(value,row,index){
	return listFileImgFormat(value,"image");
}
//bootstrap列表文件格式化
function btListFileFormatter(value,row,index){
	return listFileImgFormat(value);
}

</script>
