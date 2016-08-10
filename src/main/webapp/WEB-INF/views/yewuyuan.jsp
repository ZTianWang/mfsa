<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>业务员</title>
    </head>
    <body>
    	<table width=100% height="50px" border="1px" cellspacing="0px" cellpadding="">
			<tr>
				<th width=10%><a href="../qianfeng/access">档案签封</a></th>
				<th width=10%><a href="../rksq/access">申请入库</a></th>
				<th width=10%><a>申请出库</a></th>
				<th width=10%><a>出入库查询</a></th>
				<th width=10%><a>档案信息查询</a></th>
				<th width=10%><a>业务员信息</a></th>
			</tr>
		</table>
		<p>业务员：${sessionScope.realName}</p>
		<p>${success}</p>
 	</body>
</html>