<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>新客户添加</title>
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
					beforeSubmit:function(){
						var ppattern = /^1[34578]\d{9}$/; 
						var phone=$("#phone").val().trim();
						var ipattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
						var id=$("#idNum").val().trim();
						if ($("#name").val().trim() == "") {
							alert("请输入姓名");
							return false;
						}
						if (phone == "") {
							alert("请输入手机号码");
							return false;
						}
						if (id == "") {
							alert("请输入身份证号");
							return false;
						}
						if (!ppattern.test(phone)) {
							alert("请输入正确格式的手机号");
							return false;
						}
						if (!ipattern.test(id)) {
							alert("请输入正确格式的身份证号");
							return false;
						}
					},
					success:function(data,textStatus){
						if (data.success) {
							alert("添加成功");
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
		
	</script>
		
	</head>

	<body>
		<div class="qfjm">
			<table cellspacing="0" cellpadding="10px" style="margin: auto;margin-top: 20px;">
				<form id="form1" method="post" action="add">
					<tr>
						<td>姓名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="name" name="name" type="text" style="height:20px;width:300px">&nbsp;*</td>
					</tr>
					<tr>
						<td>电话：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="phone" name="phone" type="text" style="height:20px;width:300px">&nbsp;*</td>
					</tr>
					<tr>
						<td>身份证号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="idNum" name="idNum" type="text" style="height:20px;width:300px">&nbsp;*</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="submit" type="submit" value="确定" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="取消"></td>
					</tr>
				</form>
			</table>
		</div>
	</body>
	
	
</html>