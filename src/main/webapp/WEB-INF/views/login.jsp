<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<html>

	<head>
		<title>用户登录</title>
		<meta charset="utf-8">
    	<link rel="stylesheet" type="text/css" href="../css/Login.css"/>  
	</head>

	<body>
		<h1 style="margin-top:17%; ">BIPT档案文件管理系统</h1>  
	    <div id="login">  
	        <form method="post" action="login">  
	            用户名:<input type="text" required="required" placeholder="用户名" name="userName"></input>  <br>
	            密码:<input type="password" required="required" placeholder="密码" name="password"></input>  
	            <button class="but" type="submit">登录</button>  
	        </form>  
	    </div> 
	</body>

</html>