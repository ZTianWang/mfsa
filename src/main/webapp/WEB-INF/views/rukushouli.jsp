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
				width: 350px;
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
				var eles = document.getElementsByName("danganId");
				for (var i = 0; i < eles.length; i++) {
					if (eles[i].disabled == false) eles[i].checked = grp.checked;
				}
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
			<div class="a" style="margin-left: 100px;margin-top:50px;">流水号：<input style="text; width:80px " /></div>
			<div class="a" style="margin-left: 30px;margin-top: 10px;"><input type="button" value="搜索" style="width: 80px;" onclick="document.getElementById('form1').submit();" /></div>
			<div style="height: 30px;"></div>
			<table style="margin: auto;">
				<!--<tr>
					<td><span>列表总数：  已选择：</span></td>
					<td><span>文件列表：</span></td>
				</tr>-->
				<tr>
					<td>
						<table border="1px" cellspacing="0px" cellpadding="" style="margin: auto;">
							<tr>
								<td>
									<table width="80%">
										<thead>
											<tr>
												<th>流水号</th>
												<th>文件数</th>
												<th>部门名称</th>
												<th>经办人</th>
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
													${serial.renyuanName}
												</td>
												<td>
													<input type="radio" name="serialNum" value="${serial.serialNum}" />
												</td>
											</tr>
											</c:forEach>
										</form>
										</tbody>
									</table>
									<!-- 流水号列结束 -->
								</div>
							</td>
				</tr>

				</table>
				</td>
				<td>
					<table border="1px" cellspacing="0px" cellpadding="" style="margin: auto;">
						<tr>
							<td>
								<table width="50%">
									<th>
										档案编号
									</th>
									<th>
										签封日期
									</th>

								</table>
							</td>
						</tr>
						<td>
							<div class="daxx">
								<table width=60%; border="0px" cellspacing="0px" cellpadding="">
									<!-- 文件列开始  -->
									<form id="form2" method="post" action="accept">
										<c:forEach  var="list" items="${paperInfo}">
											<tr>
											<td>
												${list.danganId}
											</td>
											<td>
												${list.qianfengDate}
											</td>
											<td>
												<input type="checkbox" name="danganId" value="${list.danganId}" />
											</td>
										</tr>
										</c:forEach>
									</form>
								</table>
								<!-- 文件列结束 -->
							</div>
						</td>
						</tr>

					</table>
				</td>
				</tr>
				<tr>
					<td></td>
					<td><input id="check-all" type="checkbox" onclick="selectGroup()"/>全选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="确认入库" onclick="document.getElementById('form2').submit();"/></td>
				</tr>
			</table>
		</div>
		<div style="margin-left: 30%;margin-top: 10px;">档案详情:</div>
		<div class="qfjm2">
				<div class="daxx2">
					<table border="1"  style="margin: auto;width: 950px;">
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
						<tbody>
							<c:forEach  var="paper" items="${paperInfo}">
								<tr>
									<td>${paper.danganId}</td>
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
					</table>
				</div>
		</div>
	</body>

</html>