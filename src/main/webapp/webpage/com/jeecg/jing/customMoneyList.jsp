<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="customMoneyList" checkbox="false" pagination="true" fitColumns="true" title="客户资金" actionUrl="customMoneyController.do?datagrid" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="销售姓名"  field="saleName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户姓名"  field="customName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="电话"  field="phone"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="汇款账号"  field="bankAccount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="idCard"  queryMode="single"  width="120"></t:dgCol>

   <t:dgCol title="投资时间"  field="customMoneyEntity.investmentTime"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户量"  field="customMoneyEntity.customeNum"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="序号"  field="customMoneyEntity.zindex"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="金额"  field="customMoneyEntity.amount"  queryMode="single"  width="120"></t:dgCol>

   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="customMoneyController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="customMoneyController.do?goAdd" funname="add"  width="768"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="customMoneyController.do?goUpdate" funname="update"  width="768"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="customMoneyController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="customMoneyController.do?goUpdate" funname="detail"  width="768"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'customMoneyController.do?upload', "customMoneyList");
}

//导出
function ExportXls() {
	JeecgExcelExport("customMoneyController.do?exportXls","customMoneyList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("customMoneyController.do?exportXlsByT","customMoneyList");
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
