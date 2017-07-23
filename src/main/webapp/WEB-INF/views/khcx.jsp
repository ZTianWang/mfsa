<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>客户信息查询</title>
		<style type="text/css">
			.qfjm1 {
				width: 800px;
				height: 400px;
				border: 1px solid #F00;
				margin: 200px auto 0px;
			}
			
			.qfjm2 {
				width: 800px;
				height: 180px;
				border: 1px solid #F00;
				margin: 30px auto;
			}
			
			.daxx {
				height: 200px;
				width: 740px;
				overflow: scroll;
				background: #EEEEEE;
				margin: auto;
			}
			
			.daxx2 {
				height: 80px;
				width: 800px;
				overflow: scroll;
				background: #EEEEEE;
				margin: auto;
			}
			
			.a {
				display: inline;
			}
		</style>
		<script type="text/javascript" src="../js/jquery-1.9.1.min.js" ></script>
		<script type="text/javascript" src="../js/jquery.form.min.js.js" ></script>
		<script type="text/javascript" src="../js/template.js" ></script>
		<script type="text/javascript">

			
		</script>

	</head>

	<body>
		<div>

			<div class="qfjm1">
				<div style="margin-top: 30px"></div>
				<form id="search" method="post" action="query">
					<div class="a" style="margin-left: 100px; margin-top: 50px;">
						姓名：<input id="name" name="name" type="text" style="width: 80px" />
					</div>
					<div class="a" style="margin-left: 50px; margin-top: 50px;">
						电话：<input id="phone" name="phone" type="text" style="width: 120px" />
					</div>
					<div class="a" style="margin-left: 50px; margin-top: 50px;">
						身份证号：<input id="idNum" name="idNum" type="text" style="width: 120px" />
					</div>
					<div style="margin-top: 30px"></div>
					<div class="a" style="margin-left: 185px; margin-top: 10px;">
						<input type="submit" value="搜索" style="width: 80px;" />
					</div>
				</form>
				<div style="margin-top: 30px"></div>
				<table border="1px" cellspacing="0px" cellpadding="" style="margin: auto;">
					<tr>
						<td style="height: 200px; width: 800px;">
							<div class="daxx">
								<table width=100%; border="1px" style="margin: auto;" >
									<tbody >
										<tr>
											<td>姓名：</td>
											<td id="cname"></td>
										</tr>
										<tr>
											<td>电话：</td>
											<td id="cphone"></td>
										</tr>
										<tr>
											<td>身份证号：</td>
											<td id="cidNum"></td>
										</tr>
										<tr>
											<td>文件数：</td>
											<td id="count"></td>
										</tr>
									</tbody>
								</table>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<script type="text/javascript">
			
			$(function(){
				
				$('#search').submit(function(e){
					var options={
						url:"query",
						type:"post",
						dataType:"json",
						beforeSubmit:function(){
							var is=false;
							if ($("#name").val().trim() != "") {
								is=true;
							}
							if ($("#phone").val().trim() != "") {
								is=true;
							}
							if ($("#idNum").val().trim() != "") {
								is=true;
							}
							if (is==false) {
								alert("请至少输入一项");
								return false;
							}
						},
						success:function(data,textStatus){
							if (data.success) {
								$('#cname').html(data.cust.name);
								$('#cphone').html(data.cust.phone);
								$('#cidNum').html(data.cust.idNum);
								$('#count').html(data.cust.count);
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
	</body>

</html>