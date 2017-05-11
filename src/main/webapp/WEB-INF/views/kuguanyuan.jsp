<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>库管员</title>
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
		<p>库管员：${sessionScope.realName}</p>
		<p>${success}</p>
 	</body>
</html>