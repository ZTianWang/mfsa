<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>入库申请</title>
		<style type="text/css">
			.qfjm {
				width: 1000px;
				height: 700px;
				border: 1px solid #F00;
				margin: 200px auto;
				height-align: middle;
			}
			
			.daxx {
				margin: auto;
				height: 500px;
				width: 800px;
				overflow: scroll;
				background: #EEEEEE;
			}
		</style>
		<script type="text/javascript">
			function selectGroup() {
				var grp = document.getElementById("check-all");
				var eles = document.getElementsByName("danganNum");
				for (var i = 0; i < eles.length; i++) {
					if (eles[i].disabled == false) eles[i].checked = grp.checked;
				}
			}
		</script>
	</head>

	<body>
    	<table width=100% height="50px" border="1px" cellspacing="0px" cellpadding="">
			<tr>
				<th width=10%><a href="../qianfeng/access">档案签封</a></th>
				<th width=10%><a href="../rksq/access">申请入库</a></th>
				<th width=10%><a href="../cksq/access">申请出库</a></th>
				<th width=10%><a>出入库查询</a></th>
				<th width=10%><a>档案信息查询</a></th>
				<th width=10%><a href="../account/logout">签退</a></th>
			</tr>
		</table>
		<div class="qfjm">
			<div style="margin: 80px auto 10px 130px;">
				全选<input id="check-all" type="checkbox" onclick="selectGroup()" /> &nbsp;
				<!--取消选择<input name="pick" type="radio" value="" />-->
				<span style="margin-left: 250px;">流水号：    ${serial} </span>
			</div>
			<form method="post" action="apply">
			<div class="daxx">
				<table border="1"  style="margin: auto;width: 700px;">
					<thead>
						<tr>
							<th>档案编号</th>
							<th>部门名称</th>
							<th>签封日期</th>
							<th>选择</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="Paper" items="${pageView}">
							<tr>
	                			<td>${Paper.danganNum}</td>
	                			<td>${Paper.bumenName}</td>
	                			<td>${Paper.qianfengDate}</td>
	                			<td>
								<input type="checkbox" name="danganNum" value='${Paper.danganNum}' />
								</td>
	           				 </tr>
						</c:forEach>
<!-- 					<tr>
							<td>档案编号1</td>
							<td>部门1</td>
							<td>xxxx-xx-xx</td>
							<td>
								<input type="checkbox" name="danganId" value="" />
							</td>
						</tr> -->
					</tbody>
				</table>
			</div>
				<input style="margin-left: 120px;margin-top: 20px;" type="submit" value="确认" />
				<input style="margin-left: 150px;margin-top: 20px;" type="button" value="取消" />
				<input style="margin-left: 150px;margin-top: 20px;" type="button" value="打印" />
			</form>
		</div>
	</body>

</html>