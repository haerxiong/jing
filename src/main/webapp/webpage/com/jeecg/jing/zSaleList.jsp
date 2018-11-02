<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="zSaleList" checkbox="false" pagination="true" fitColumns="true" title="销售表" actionUrl="zSaleController.do?datagrid" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="zSaleEntity.id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="销售主键"  field="zSalemanEntity.id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="团队"  field="zSalemanEntity.teamName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="销售姓名"  field="saleName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入职时间"  field="zSalemanEntity.joinTime"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="签单时间"  field="zSaleEntity.signTime"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户姓名"  field="customName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="签单金额"  field="amount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同期限"  field="timeLimit"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="年化合计"  field="zSaleEntity.yearTotal"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合计"  field="zSaleEntity.total"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="业绩年化"  field="zSaleEntity.performance"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="zSaleEntity.comment"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="zSaleController.do?doDel&id={zSaleEntity.id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <%--<t:dgToolBar title="录入" icon="icon-add" url="zSaleController.do?goAdd" funname="add"  width="768"></t:dgToolBar>
   --%><t:dgToolBar title="编辑" icon="icon-edit" url="zSaleController.do?goUpdate" funname="update"  width="768"></t:dgToolBar>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="zSaleController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zSaleController.do?goUpdate" funname="detail"  width="768"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zSaleController.do?upload', "zSaleList");
}

//导出
function ExportXls() {
	JeecgExcelExport("zSaleController.do?exportXls","zSaleList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("zSaleController.do?exportXlsByT","zSaleList");
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
