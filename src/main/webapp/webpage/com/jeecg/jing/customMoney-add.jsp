<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>客户资金</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="customMoneyController.do?doAdd" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id"/>
		<div class="form-group">
			<label for="investmentTime" class="col-sm-3 control-label">投资时间：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="investmentTime" name="investmentTime" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入投资时间"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="customeNum" class="col-sm-3 control-label">客户量：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="customeNum" name="customeNum" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入客户量"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="zindex" class="col-sm-3 control-label">序号：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="zindex" name="zindex" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入序号"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="amount" class="col-sm-3 control-label">金额：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="amount" name="amount" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入金额"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="takeinId" class="col-sm-3 control-label">外键：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="takeinId" name="takeinId" type="text" maxlength="36" class="form-control input-sm" placeholder="请输入外键"  ignore="ignore" />
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