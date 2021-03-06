<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>销售表</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="zSaleController.do?doAdd" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id"/>
		<div class="form-group">
			<label for="isDel" class="col-sm-3 control-label">是否删除：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="isDel" name="isDel" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入是否删除"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="takeinId" class="col-sm-3 control-label">外键指向takein表：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="takeinId" name="takeinId" type="text" maxlength="36" class="form-control input-sm" placeholder="请输入外键指向takein表"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="signTime" class="col-sm-3 control-label">签单时间：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="signTime" name="signTime" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入签单时间"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="yearTotal" class="col-sm-3 control-label">年化合计：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="yearTotal" name="yearTotal" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入年化合计"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="total" class="col-sm-3 control-label">合计：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="total" name="total" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入合计"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="performance" class="col-sm-3 control-label">业绩年化：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="performance" name="performance" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入业绩年化"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="comment" class="col-sm-3 control-label">备注：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="comment" name="comment" type="text" maxlength="256" class="form-control input-sm" placeholder="请输入备注"  ignore="ignore" />
				</div>
			</div>
		</div>
	</form>
	</div>
 </div>
<script type="text/javascript">
var subDlgIndex = '';
$(document).ready(function() {
	//单选框/多选框初始化
	$('.i-checks').iCheck({
		labelHover : false,
		cursor : true,
		checkboxClass : 'icheckbox_square-green',
		radioClass : 'iradio_square-green',
		increaseArea : '20%'
	});
	
	//表单提交
	$("#formobj").Validform({
		tiptype:function(msg,o,cssctl){
			if(o.type==3){
				validationMessage(o.obj,msg);
			}else{
				removeMessage(o.obj);
			}
		},
		btnSubmit : "#btn_sub",
		btnReset : "#btn_reset",
		ajaxPost : true,
		beforeSubmit : function(curform) {
		},
		usePlugin : {
			passwordstrength : {
				minLen : 6,
				maxLen : 18,
				trigger : function(obj, error) {
					if (error) {
						obj.parent().next().find(".Validform_checktip").show();
						obj.find(".passwordStrength").hide();
					} else {
						$(".passwordStrength").show();
						obj.parent().next().find(".Validform_checktip").hide();
					}
				}
			}
		},
		callback : function(data) {
			var win = frameElement.api.opener;
			if (data.success == true) {
				frameElement.api.close();
			    win.reloadTable();
			    win.tip(data.msg);
			} else {
			    if (data.responseText == '' || data.responseText == undefined) {
			        $.messager.alert('错误', data.msg);
			        $.Hidemsg();
			    } else {
			        try {
			            var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
			            $.messager.alert('错误', emsg);
			            $.Hidemsg();
			        } catch (ex) {
			            $.messager.alert('错误', data.responseText + "");
			            $.Hidemsg();
			        }
			    }
			    return false;
			}
		}
	});
		
});
</script>
</body>
</html>