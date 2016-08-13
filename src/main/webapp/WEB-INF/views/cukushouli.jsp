<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>入库申请受理</title>
		<style type="text/css">
			.qfjm1 {
				width: 800px;
				height: 400px;
				border: 1px solid #F00;
				margin: 100px auto 0px;
			}
			
			.qfjm2 {
				width: 1024px;
				height: 180px;
				border: 1px solid #F00;
				margin: 30px auto;
			}
			
			.daxx {
				height: 200px;
				width: 500px;
				overflow: scroll;
				background: #EEEEEE;
				margin: auto;
			}
			
			.daxx2 {
				height: 140px;
				width: 1000px;
				overflow: scroll;
				background: #EEEEEE;
				margin: 20px auto 0;
			}
			
			.a {
				display: inline;
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

			function f1() {
				document.form1.action = "";
				document.form1.submit();
			}

			function f2() {
				document.form1.action = "";
				document.form1.submit();
			}
		</script>
	</head>

	<body>

		<!--标题栏-->
		<table width=100% height="50px" border="1px" cellspacing="0px" cellpadding="">
			<tr>
				<th width=10%>入库受理</th>
				<th width=10%>出库受理</th>
				<th width=10%>查询</th>
				<th width=10%>查库</th>
				<th width=10%>库房整理</th>
				<th width=10%>手工存/取件</th>
				<th width=10%></th>
				<th width=10%>签退</th>
			</tr>
		</table>

		<div class="qfjm1">
			<div style="margin-top: 30px"></div>
			<div class="a" style="margin-left: 100px;margin-top:50px;">
				流水号：<input style="text; width:80px " />
			</div>
			<div class="a" style="margin-left: 30px;margin-top: 10px;">
				<input type="button" value="查询" style="width: 80px;" onclick="document.getElementById('form1').submit();" />
			</div>
			<div style="height: 30px;"></div>
			<table style="margin: auto; ">
				<tr>
					<td>出库文件总数：<span id="count"></span></td>
				</tr>
				<tr>
					<td>
						<table border="1px" cellspacing="0px" cellpadding="" style="margin: auto;">
							<tr>
								<td>
									<table width="80%">
										<thead>
											<tr>
												<th>流水号</th>
												<th>部门名称</th>
												<th>出库文件数量</th>
												<th>选择</th>
											</tr>
										</thead>
									</table>
								</td>
							</tr>
							<td>
								<div class="daxx">
									<table width=100%; border="0px" cellspacing="0px" cellpadding="">
										<!-- 流水号列开始  -->
										<tbody>
											<form id="form1" method="get" action="query">
												<c:forEach var="serial" items="${serialList}">
													<tr>
														<td>
															${serial.serialNum}
														</td>
														<td>
															${serial.count}
														</td>
														<td>
															${serial.bumenName}
														</td>
														<td>
															<input type="checkbox" name="serialNum" value="${serial.serialNum}" />
														</td>
													</tr>
												</c:forEach>
											</form>
										</tbody>
										<!-- 流水号列结束 -->
									</table>
								</div>
							</td>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" value="确认出库" onclick="f1()" />
						<input type="button" value="拒绝申请" onclick="f2()" />
					</td>
				</tr>
			</table>
		</div>
		<div style="margin-left: 30%;margin-top: 10px;">档案详情:</div>
		<div class="qfjm2">
			<div class="daxx2">
				<table border="0px" cellspacing="0px" cellpadding="" style="margin: auto;width: 950px;">
					<tr>
						<td>
							<table border="1px" cellspacing="0px" cellpadding="" style="margin: auto;">
								<tr>
									<td>
										<table width="80%">
											<thead>
												<tr>
													<th>档案编号</th>
													<th>部门名称</th>
													<th>物品名称</th>
													<th>签封日期</th>
													<th>到期日</th>
													<th>负责人</th>
													<th>客户经理</th>
													<th>电话</th>
												</tr>
											</thead>
										</table>
									</td>
								</tr>
								<td>
									<table width=100%; border="0px" cellspacing="0px" cellpadding="">
										<!-- 流水号列开始  -->
										<tbody>
											<c:forEach var="paper" items="${paperInfo.paperlist}">
												<tr>
													<td>${paper.danganNum}</td>
													<td>${paper.bumenName}</td>
													<td>${paper.wupinName}</td>
													<td>${paper.qianfengDate}</td>
													<td>${paper.daoqiDate}</td>
													<td>${paper.fuzeren}</td>
													<td>${paper.kehujingli}</td>
													<td>${paper.dianhua}</td>
												</tr>
											</c:forEach>
										</tbody>
										<!-- 流水号列结束 -->
									</table>
								</td>
							</table>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>

</html>