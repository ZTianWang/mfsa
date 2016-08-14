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
				height: 350px;
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
				var eles = document.getElementsByName("danganNum");
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
				<th width=10%><a href="../rksl/access">入库受理</a></th>
				<th width=10%><a href="../cksl/access">出库受理</a></th>
				<th width=10%><a>查询</a></th>
				<th width=10%><a>查库</a></th>
				<th width=10%><a>库房整理</a></th>
				<th width=10%><a>手工取件</a></th>
				<th width=10%><a href="../account/logout">签退</a></th>
			</tr>
		</table>
		<div class="qfjm2">
        <h2>请扫描确认档案入库：</h2>
        <form action=" " method=" ">
           <textarea cols="100" rows="3" id="contactus" name="contactus"></textarea></br>
         <input type="reset" />
                <input type="submit" />
        </form>
       
		</div>
		<div class="qfjm1">
			<div style="margin-top: 30px"></div>
			<table style="margin: auto;">
				<tr>
					<td><span>申请列表档案总数：${tote}</span></td>
					<td><span>文件列表档案数：${count}</span></td>
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
															${serial.ywyName}
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
											<c:forEach var="list" items="${paperInfo.paperlist}">
												<tr>
													<td>
														${list.danganNum}
													</td>
													<td>
														${list.qianfengDate}
													</td>
													<td>
														<input type="checkbox" name="danganNum" value="${list.danganNum}" />
													</td>
												</tr>
											</c:forEach>
										</form>
									</table>
									<!-- 文件列结束 -->
								</div>
							</td>
						</table>
					</td>
					<td>
						<tr>
							<td>
								<input type="button" value="搜索" style="width: 80px;" onclick="document.getElementById('form1').submit();" />
							</td>
							<td>
								<input id="check-all" type="checkbox" onclick="selectGroup()" />全选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="button" value="确认入库" onclick="document.getElementById('form2').submit();" />
							</td>
						</tr>
					</td>
				</tr>
			</table>
		</div>
		<div style="margin-left: 30%;margin-top: 10px;">档案详情:</div>
		<div class="qfjm2">
			<div class="daxx2">
				<table border="1" style="margin: auto;width: 950px;">
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
				</table>
			</div>
		</div>
	</body>

</html>