<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<html>

	<head>
		<title>用户登录</title>
		<meta charset="utf-8">
		<style type="text/css">
			.qfjm1 {
				width: 1200px;
				height: 600px;
				border: 1px solid #F00;
				margin: 200px auto 0px;
			}
			
			.logo {
				width: 15%;
				height: 30%;
				border: 1px solid #F00;
				margin: 120px 120px;
				float: left;
			}
			
			.login {
				width: 500;
				height: 400;
				border: 1px solid #F00;
				margin: 120px 100px 120px;
				float: left;
			}
		</style>
	</head>

	<body>
		<div class="qfjm1">
			<div class="logo">
				<div style="TEXT-ALIGN: center;margin-top: 40%;">
					<h1>MFSA</h1>
				</div>
			</div>
			<div class="login">
				${loginError}
				<div style="height: 50px; border: 1px solid;">
					<table width="100%" height="100%" border= 1px; >
					<tr>
						<th>
						    业务员
						</th>
						<th>
						    库管员
						</th>
					</tr>
				</table>
				</div>
				<div style="width:300px ;height: 200px;margin:10% auto;">
					<form method="post" action="login">
						用户名：<input name="userName" type="text" /><br/>
						密&emsp;码：<input name="password" type="password" /><br/>
						<input type="submit" value="登录" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="取消" />
					</form>
				</div>
			</div>
		</div>
	</body>

</html>