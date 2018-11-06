<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="zTakeinList" checkbox="false" pagination="true" fitColumns="true" title="客户信息" actionUrl="zTakeinController.do?datagrid&key=${key}&type=${type}" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否删除"  field="isDel" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同编号"  field="contract"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收据编号"  field="receipt"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="销售姓名"  field="saleName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户姓名"  field="customName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="idCard" hidden="${(empty type || 'huizong' eq type)?false:true}" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入金时间"  field="takeinTime" formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入金时间"  field="takeinTime2" formatter="yyyy-MM-dd" query="${'yue' eq key ? true : false}" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="金额"  field="amount" hidden="${('lixi' eq key)?true:false}" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="期限"  field="timeLimit" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="利率"  field="rate" hidden="${('lixi' eq key)?true:false}"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="电话"  field="phone"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="汇款账号"  field="bankAccount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="到期时间"  field="endTime" formatter="yyyy-MM-dd" hidden="${('huizong' eq type)?true:false}" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="comment"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="出金时间"  field="endTime1" formatter="yyyy-MM-dd" hidden="${('daoqi' eq type)?false:true}" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <%--<t:dgDelOpt title="删除" url="zTakeinController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zTakeinController.do?goUpdate" funname="update"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zTakeinController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zTakeinController.do?goUpdate" funname="detail"  width="800" height="500"></t:dgToolBar>--%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <c:if test="${empty type ? true : false}">
    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
    <t:dgToolBar title="excel模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
    <t:dgToolBar title="录入" icon="icon-add" url="zTakeinController.do?goAdd" funname="add"  width="800" height="500"></t:dgToolBar>
   </c:if>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
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
