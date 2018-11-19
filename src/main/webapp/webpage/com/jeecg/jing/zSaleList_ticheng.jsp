<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="zSaleList" checkbox="false" pagination="true" fitColumns="true" title="销售表" onLoadSuccess="loadData"
   actionUrl="zSaleController.do?datagrid&type=${type}" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="团队"  field="zSalemanEntity.teamName" query="${not empty type ? true : false}" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="销售姓名"  field="saleName" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入职时间" formatter="yyyy-MM-dd"  field="zSalemanEntity.joinTime"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户姓名"  field="customName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="金额(万)"  field="amount"  queryMode="single"  width="120" align="right"></t:dgCol>
   <t:dgCol title="期限(月)"  field="timeLimit"  queryMode="single"  width="120" align="right"></t:dgCol>
   <t:dgCol title="业绩(万)"  field="sum_amount"  queryMode="single"  width="120" align="right"></t:dgCol>
   <t:dgCol title="提点"  field="percentages"  queryMode="single"  width="120" align="right"></t:dgCol>
   <t:dgCol title="总计"  field="sum_percentages"  queryMode="single"  width="120" align="right"></t:dgCol>
   <t:dgCol title="团队合计(万)"  field="sum_amount_team"  queryMode="single"  width="120" align="right"></t:dgCol>
   <t:dgCol title="备注"  field="comment"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="到期时间"  field="endTime" query="true" formatter="yyyy-MM-dd" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="到期日"  field="endTime2" formatterjs="getEnd" queryMode="single"  width="80" align="right"></t:dgCol>
   <t:dgCol title="编辑信息" field="opt"></t:dgCol>
   <%--<t:dgToolBar title="录入" icon="icon-add" url="zSaleController.do?goAdd" funname="add"  width="768"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zSaleController.do?goUpdate" funname="update"  width="768"></t:dgToolBar>--%>
   <%--<t:dgFunOpt funname="goud(id)" title="销售明细"  urlclass="ace_button"  urlfont="fa-edit"></t:dgFunOpt>--%>
   <t:dgFunOpt funname="goud2(id)" title="修改"  urlclass="ace_button"  urlfont="fa-edit"></t:dgFunOpt>
   <t:dgFunOpt funname="goud3(saleName)" title="销售员"  urlclass="ace_button"  urlfont="fa-edit"></t:dgFunOpt>
   <%--<t:dgDelOpt title="删除" url="zSaleController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zSaleController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zSaleController.do?goUpdate" funname="detail"  width="768"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){

 });

 function getEnd(value,row,index) {
     return row["endTime"].substring(8, 10);
 }

 function loadData(data) {
     combine_single(data, ["saleName"], ["sum_amount", "sum_percentages"]);
     combine_single(data, ["zSalemanEntity.teamName"], ["sum_amount_team"]);
 }

 function goud(id) {
     createwindow('销售明细', 'zSaleController.do?goUpdate&id='+id , 768, null);
 }

 function goud2(id) {
     createwindow('修改', 'zTakeinController.do?goUpdate&id='+id , 768, null);
 }

 function goud3(saleName) {
     createwindow('销售员', 'zSalemanController.do?goUpdate&saleName='+encodeURI(saleName) , 768, null);
 }

//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zSaleController.do?upload', "zSaleList");
}

//导出
function ExportXls() {
    var saleName = $("[name='saleName']").val();
	JeecgExcelExport("zSaleController.do?exportXls&type=ticheng&teamName=&saleName="+encodeURI(saleName),"zSaleList");
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
