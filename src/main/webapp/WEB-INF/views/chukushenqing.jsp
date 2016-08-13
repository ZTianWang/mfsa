<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>批量出库申请</title>
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
				width: 600px;
				overflow: scroll;
				background: #EEEEEE;
				margin: auto;
			}
			
			.daxx2 {
				height: 80px;
				width: 600px;
				overflow: scroll;
				background: #EEEEEE;
				margin: auto;
			}
			
			.a {
				display: inline;
			}
		</style>

		<script type="text/javascript">

			function selectGroup() {
				var div = document.getElementById("gdiv");
				var grp = document.getElementById("check-all");
				var eles = div.getElementsByTagName("input");
//				var eles = gdiv.getElementsByName("danganId");
				for (var i = 0; i < eles.length; i++) {
					if (eles[i].disabled == false) eles[i].checked = grp.checked;
				}
			}
			
			function act1() {
				document.form2.action = "apply"
				document.form2.submit();
			}

			function act2() {
				document.form2.action = "remove";
				document.form2.submit();
			}
			
		</script>

	</head>

	<body>
		<div>
			<!--标题栏-->
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

			<div class="qfjm1">
				<div style="margin-top: 30px"></div>
				<form id="search" method="post" action="query">
					<div class="a" style="margin-left: 100px; margin-top: 50px;">
						档案编号：<input name="danganNum" type="text" style="width: 80px" />
					</div>
					<div class="a" style="margin-left: 150px; margin-top: 10px;">
						签封时间：<input name="qianfengDateF" type="date" style="width: 120px" />-<input name="qianfengDateL" type="date" style="width: 120px" />
					</div>
					<div style="margin-top: 30px"></div>
					<div class="a" style="margin-left: 185px; margin-top: 10px;">
						<input type="submit" value="搜索" style="width: 80px;" />
					</div>
					<div class="a" style="margin-left: 150px; margin-top: 10px;">
						到期时间：<input name="daoqiDateF" type="date" style="width: 120px" />-<input name="daoqiDateL" type="date" style="width: 120px" />
					</div>
				</form>
				<div style="margin-top: 30px"></div>
				<table border="1px" cellspacing="0px" cellpadding="" style="margin: auto;">
					<tr>
						<td>
							<table width="60%">
								<tbody>
									<th>档案编号</th>
									<th>部门名称</th>
									<th>签封日期</th>
									<th>选择</th>
								</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<td style="height: 200px; width: 600px;">
							<div class="daxx">
								<table width=80%; border="0px" cellspacing="0px" cellpadding="">
									<!-- 文件列开始  -->
									<form id="form1" method="post" action="add">
										<tbody>
											<c:forEach var="Paper" items="${pageViews}">
												<tr>
													<td>${Paper.danganNum}</td>
													<td>${Paper.bumenName}</td>
													<td>${Paper.qianfengDate}</td>
													<td>
														<input type="checkbox" name="danganId" value='${Paper.danganId}' />
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</form>
								</table>
							</div>
						</td>
					</tr>
				</table>
				<input style="margin-left: 120px; margin-top: 10px;" type="button" value="添加" onclick="document.getElementById('form1').submit();" />
			</div>
			<div style="margin-left: 30%;margin-top: 10px;">流水号：${serial} </div>
			<div style="margin-left: 30%; margin-top: 10px;">已添加: ${count} 份</div>
			<div id="gdiv" class="qfjm2">
				<table border="1px" cellspacing="0px" cellpadding="" style="margin: 10px auto;">
					<tr>
						<td>
							<table width="60%">
								<th>档案编号</th>
								<th>部门名称</th>
								<th>签封日期</th>
							</table>
						</td>

					</tr>
					<tr>
						<td>
							<div class="daxx2">
								<table width=80%; border="0px" cellspacing="0px" cellpadding="">
									<!-- 文件列开始  -->
									<form name="form2" method="post" action="">
										<tbody>
											<c:forEach var="Paper" items="${pageList}">
												<tr>
													<td>${Paper.danganNum}</td>
													<td>${Paper.bumenName}</td>
													<td>${Paper.qianfengDate}</td>
													<td>
														<input type="checkbox" name="danganId" value='${Paper.danganId}' />
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</form>
								</table>
							</div>
						</td>
					</tr>
				</table>
				<input id="check-all" style="margin-left: 120px; margin-top: 10px;" type="checkbox" onclick="selectGroup()" />全选 &nbsp;
				<input style="margin-left: 20px; margin-top: 10px;" type="button" value="申请出库" onclick="act1();" />
				<input style="margin-left: 20px; margin-top: 10px;" type="button" value="移除" onclick="act2();" />
			</div>
		</div>
	</body>

</html>