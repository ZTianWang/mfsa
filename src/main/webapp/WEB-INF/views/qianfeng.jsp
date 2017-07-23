<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>档案签封</title>
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
				
				$('#sm').click(function(){
					var rand = Math.floor(Math.random () * 9000000000);
					var c="69";
					var num=c+rand;
					$("#fileNum").val(num);
					
				});
				
				$('#submit').click(function(){
					$('#form1').unbind();
					$('#form1').submit(function(e){
						var options={
							url:"add",
							type:"post",
							dataType:"json",
							beforeSubmit:function(){
								if ($("#fileNum").val().trim() == "") {
									alert("请输入档案袋编号");
									return false;
								}
								if ($("#custName").val().trim() == "") {
									alert("请输入客户姓名");
									return false;
								}
								if ($("#fileName").val().trim() == "") {
									alert("请输入文件名称");
									return false;
								}
							},
							success:function(data,textStatus){
								if (data.success) {
									alert("签封成功");
									window.location.href="../ywy"
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
				
				$('#resub').click(function(){
					$('#form1').unbind();
					$('#form1').submit(function(e){
						var options={
							url:"readd",
							type:"post",
							dataType:"json",
							beforeSubmit:function(){
								if ($("#fileNum").val().trim() == "") {
									alert("请输入档案袋编号");
									return false;
								}
							},
							success:function(data,textStatus){
								if (data.success) {
									alert("受理成功");
									window.location.href="../ywy"
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
			
			});
			
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
		<div class="qfjm">
			<table cellspacing="0" cellpadding="10px" style="margin: auto;margin-top: 20px;">
				<form id="form1" method="post" >
					<tr>
						<td>档案袋编号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="fileNum" name="fileNum" type="text" style="height:20px;width:300px">&nbsp;*<button id="sm" type="button">扫描</button></td>
					</tr>
					<tr>
						<td>客户姓名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="custName" name="custName" type="text" style="height:20px;width:300px">&nbsp;*</td>
					</tr>
					<tr>
						<td>部门名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<select id="bumenId" name="bumenId" style="height:20px;width:295px">
								<option value="1">丰台支行</option>
								<option value="2">大兴支行</option>
							</select> &nbsp;*
						</td>
					</tr>
					<tr>
						<td>文件名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="fileName" name="fileName" type="text" style="height:20px;width:300px">&nbsp;*</td>
					</tr>
					<tr>
						<td>签封日期：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="qianfengDate" name="qianfengDate" type="date" style="height:20px;width:300px" readonly="readonly">&nbsp;*</td>
					</tr>
					<tr>
						<td>客户经理：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="mName" name="mName" type="text" style="height:20px;width:300px"></td>
					</tr>
					<tr>
						<td>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input id="submit" type="submit" value="确定" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input id="resub" type="submit" value="旧文件入库" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" value="取消">
						</td>
					</tr>
				</form>
			</table>
		</div>
	</body>
	
	
</html>