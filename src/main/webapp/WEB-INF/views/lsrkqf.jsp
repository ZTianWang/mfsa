<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>临时入库签封</title>
		<style type="text/css">
			.qfjm {
				width: 600px;
				height: 500px;
				border: 1px solid #F00;
				margin: 200px auto;
				height-align: middle;
				;
			}
		</style>
		<script type="text/javascript" src="../js/jquery-1.9.1.min.js" ></script>
		<script type="text/javascript" src="../js/jquery.form.min.js.js" ></script>
		<script type="text/javascript">
			$(function(){
				
				$('#form1').unbind();
				$('#form1').submit(function(e){
					var options={
					url:"add",
					type:"post",
					dataType:"json",
					success:function(data,textStatus){
						if (data.success) {
							alert("签封入库成功");
							window.location.href="../user"
						} else{
							alert(data.errorMsg);
						}
					},
					error:function(data,textStatus){
						alert("服务器响应错误");
					},
				}
				$(this).ajaxSubmit(options);
				e.preventDefault();
			}); 
			
		});
		
//		function today(){
//		    var today=new Date();
//		    var h=today.getFullYear();
//		    var m=today.getMonth();
//		    var d=today.getDate();
//		    return h+"-"+m+"-"+d;
//		}
		
		$(function(){
			var date = new Date();
		    var seperator1 = "-";
		    var year = date.getFullYear();
		    var nyear = date.getFullYear()+1;
		    var month = date.getMonth() + 1;
		    var strDate = date.getDate();
		    if (month >= 1 && month <= 9) {
		        month = "0" + month;
		    }
		    if (strDate >= 0 && strDate <= 9) {
		        strDate = "0" + strDate;
		    }
		    var today = year + seperator1 + month + seperator1 + strDate;
		    var dqDate = nyear + seperator1 + month + seperator1 + strDate;
		    var qfd=document.getElementById("qianfengDate");
		    qfd.setAttribute("value",today);
		    var dqd=document.getElementById("daoqiDate");
		    dqd.setAttribute("value",dqDate);
		})
		
	</script>
		
	</head>

	<body>
		<table width=100% height="50px" border="1px" cellspacing="0px" cellpadding="">
			<tr>
				<th width=10%><a href="../rksl/access">入库受理</a></th>
				<th width=10%><a href="../cksl/access">出库受理</a></th>
				<th width=10%><a href="../lsrkqf/access">临时入库签封</a></th>
				<th width=10%><a href="../jjcksl/access">紧急出库受理</a></th>
				<th width=10%><a>查询</a></th>
				<th width=10%><a>查库</a></th>
				<th width=10%><a href="../account/logout">签退</a></th>
			</tr>
		</table>
		<div class="qfjm">
			<table cellspacing="0" cellpadding="10px" style="margin: auto;margin-top: 20px;">
				<form id="form1" method="post" action="add">
					<tr>
						<td>档案袋编号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="fileNum" name="fileNum" type="text" style="height:20px;width:300px">&nbsp;*</td>
					</tr>
					<tr>
						<td>文件编号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="danganNum" name="danganNum" type="text" style="height:20px;width:300px">&nbsp;*</td>
					</tr>
					<tr>
						<td>部门名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<select id="bumenId" name="bumenId" style="height:20px;width:295px">
								<option value="1">部门A</option>
								<option value="2">部门B</option>
							</select> &nbsp;*
						</td>
					</tr>
					<tr>
						<td>签封日期：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="qianfengDate" name="qianfengDate" type="date" style="height:20px;width:300px" disabled="disabled">&nbsp;*</td>
					</tr>
					<tr>
						<td>到期日：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="daoqiDate" name="daoqiDate" type="date" style="height:20px;width:300px" >&nbsp;*</td>
					</tr>
					<tr>
						<td>封存物品名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<select id="wupinId" name="wupinId" style="height:20px;width:295px">
							<option value="1">二手房屋抵押合同</option>
							<option value="2">二手汽车抵押合同</option>
						</select> &nbsp;*</td>
					</tr>
					<tr>
						<td>负责人：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="fuzeren" name="fuzeren" type="text" style="height:20px;width:300px"></td>
					</tr>
					<tr>
						<td>客户经理：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="kehujingli" name="kehujingli" type="text" style="height:20px;width:300px"></td>
					</tr>
					<tr>
						<td>电话：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="dianhua" name="dianhua" type="text" style="height:20px;width:300px"></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="submit" type="submit" value="确认签封入库" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="取消"></td>
					</tr>
				</form>
			</table>
		</div>
	</body>
	
	
</html>