<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>客户信息</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
	<style>
		@media print {
			.inner,.inner>tr,.inner>tr>td {
				border:none;
			}
		}
	</style>
</head>
<body style="overflow:hidden;overflow-y:auto;">
<!--startprint-->
<div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body" style="font-size: 14px">
		<table class="table table-bordered" style="margin-bottom: 0px">
			<caption style="text-align: center;color: black"><b style="font-size: 20px">宝华睿鑫客户回单</b></caption>
			<caption>
				<img width="150px" src='<c:url value="/baohua.png"/>'>
				<span style="float: right;line-height: 37px;">
				入账日期
				<span style="text-decoration: underline"><fmt:formatDate pattern='yyyy' type='date' value='${zTakein.takeinTime}'/></span>年
				<span style="text-decoration: underline"><fmt:formatDate pattern='MM' type='date' value='${zTakein.takeinTime}'/></span>月
				<span style="text-decoration: underline"><fmt:formatDate pattern='dd' type='date' value='${zTakein.takeinTime}'/></span>日
				</span>
			</caption>
			<tbody>
			<tr>
				<td width="10%">付款人</td>
				<td width="40%">青岛宝华睿鑫投资基金管理有限公司</td>
				<td width="10%">收款人</td>
				<td width="40%">${zTakein.customName}</td>
			</tr>
			<tr>
				<td colspan="4">
					<table style="width: 100%" class="inner">
						<tr>
							<td><span>入金时间:<fmt:formatDate pattern='yyyy-MM-dd' type='date' value='${zTakein.takeinTime}'/></span></td>
							<td style="text-align: center;"><span>电话：${zTakein.phone}</span></td>
							<td style="text-align: right"><span>到期时间：<fmt:formatDate pattern='yyyy-MM-dd' type='date' value='${zTakein.endTime}'/></span></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-right: none;">金额：<span id="da" style="text-decoration: underline"></span>元整</td>
				<td colspan="2" style="border-left: none;">（小写）￥：<span style="text-decoration: underline">&nbsp${zTakein.amount*10000}&nbsp</span></td>
			</tr>
			<tr>
				<td colspan="2" style="border-right: none;">结算方式：现金/转账/</td>
				<td colspan="2" style="border-left: none;">用途：利息支付/出金</td>
			</tr>
			</tbody>
		</table>
		<table class="table table-bordered">
			<caption>
				<span style="">打印时间：<fmt:formatDate pattern='yyyy-MM-dd HH:mm:ss' type='date' value='${now}'/></span>
				<span style="float:right;text-decoration: underline">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
				<span style="float:right">客户签字：</span>
			</caption>
			<caption>
				<img src='<c:url value="/zhang.gif"/>' style="float: right;width: 150px"/>
			</caption>
		</table>

	</div>
</div>
<!--endprint-->
<form role="form" id="formobj" method="POST" style="height: 10px;">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
</form>
<script type="text/javascript">
	$(function(){
		var n = ${zTakein.amount*10000};
		$("#da").html(" " + smalltoBIG(n).replace('元整', '') + " ");

        function doPrint() {
            bdhtml=window.document.body.innerHTML;
            sprnstr="<!--startprint-->";
            eprnstr="<!--endprint-->";
            prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17);
            prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));
            window.document.body.innerHTML=prnhtml;
            window.print();
        }

        //表单提交
        $("#formobj").Validform({
            btnSubmit : "#btn_sub",
            beforeSubmit : function(curform) {
                var t = $(parent.document).find(".ui_buttons>input:nth-child(2)").parents("div");
                $(t[t.length-1]).hide();
                $(parent.document).find("#ldg_lockmask").hide();
                doPrint();
            }
        });
        $("#Validform_msg").hide();
    });
    /** 数字金额大写转换(可以处理整数,小数,负数) */
    function smalltoBIG(n) {
        var fraction = ['角', '分'];
        var digit = ['零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'];
        var unit = [ ['元', '万', '亿'], ['', '拾', '佰', '仟']  ];
        var head = n < 0? '欠': '';
        n = Math.abs(n);

        var s = '';

        for (var i = 0; i < fraction.length; i++)
        {
            s += (digit[Math.floor(n * 10 * Math.pow(10, i)) % 10] + fraction[i]).replace(/零./, '');
        }
        s = s || '整';
        n = Math.floor(n);

        for (var i = 0; i < unit[0].length && n > 0; i++)
        {
            var p = '';
            for (var j = 0; j < unit[1].length && n > 0; j++)
            {
                p = digit[n % 10] + unit[1][j] + p;
                n = Math.floor(n / 10);
            }
            s = p.replace(/(零.)*零$/, '').replace(/^$/, '零')  + unit[0][i] + s;
        }
        return head + s.replace(/(零.)*零元/, '元').replace(/(零.)+/g, '零').replace(/^整$/, '零元整');
    }
</script>
</body>
</html>