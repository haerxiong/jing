<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="zTakeinList" checkbox="false" pagination="true" fitColumns="true" title="客户信息"
    actionUrl="zTakeinController.do?datagrid&key=${key}&type=${type}&key2=${key2}" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户姓名"  field="customName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入金时间"  field="takeinTime" formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="电话"  field="phone"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="汇款账号"  field="bankAccount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="到期时间"  field="endTime" formatter="yyyy-MM-dd" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合计金额"  field="ext1"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户签字"  field="ext2"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="comment"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="150"></t:dgCol>
   <t:dgFunOpt funname="goud2(id)" title="修改"  urlclass="ace_button"  urlfont="fa-edit"></t:dgFunOpt>
   <%--<t:dgDelOpt title="删除" url="zTakeinController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zTakeinController.do?goUpdate" funname="update"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zTakeinController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zTakeinController.do?goUpdate" funname="detail"  width="800" height="500"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });

 function goud2(id) {
     createwindow('修改', 'zTakeinController.do?goUpdate&id='+id , 768, null);
 }
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zTakeinController.do?upload', "zTakeinList");
}

//导出
function ExportXls() {
	JeecgExcelExport("zTakeinController.do?exportXls&type=${type}","zTakeinList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("zTakeinController.do?exportXlsByT","zTakeinList");
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
