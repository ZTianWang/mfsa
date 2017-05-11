<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>紧急出库受理</title>
<style type="text/css">
.qfjm1 {
	width: 800px;
	height: 400px;
	border: 1px solid #F00;
	margin: 100px auto 0px;
}

.qfjm2 {
	width: 1024px;
	height: 200px;
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
		var eles = document.getElementsByName("serialNum");
		for (var i = 0; i < eles.length; i++) {
			if (eles[i].disabled == false)
				eles[i].checked = grp.checked;
		}
	}
</script>
<script type="text/javascript" src="../js/jquery-1.9.1.min.js" ></script>
<script type="text/javascript" src="../js/jquery.form.min.js.js" ></script>
<script type="text/javascript" src="../js/template.js" ></script>
<script type="text/javascript">
	$(function(){
		
		$("#xqcx").click(function(){
			$('#form1').unbind();
			$('#form1').submit(function(e){
				var options={
					url:"query",
					type:"post",
					dataType:"json",
					success:function(data,textStatus){
						if (data.success) {
							$('#paperCount').html(data.paperCount);
							$("#tb").html(template('list',{paper:data.paperInfos}));
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
			$('#form1').submit(); 
		});
		
		$("#qrck").click(function(){
			$('#form1').unbind();
			$('#form1').submit(function(e){
				var options={
					url:"accept",
					type:"post",
					dataType:"json",
					success:function(data,textStatus){
						if (data.success) {
							alert("确认出库成功");
							window.location.href="access"
						} else{
							alert(data.errorMsg);
						}
					},
					error:function(data,textStatus){
						alert("服务器未响应");
					},
					beforeSubmit:function(){
						alert("确认出库？");
					},
				}
				$(this).ajaxSubmit(options);
				e.preventDefault();
			}); 
			$('#form1').submit(); 
		});
		
		$('#jjsq').click(function(){
			window.location.href="../account/login"
		})
		
	});
	
</script>
</head>

<body>

	<!--标题栏-->
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

	<div class="qfjm1">
		<div style="margin-top: 30px"></div>
		<div style="height: 30px;"></div>
		<table style="margin: auto;">
			<tr>
				<td>出库文件总数：<span id="count">${tote}</span>份</td>
			</tr>
			<tr>
				<td>
					<table border="1" style="margin: auto;" cellspacing="0px" cellpadding="">
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
						<tr>
							<td>
								<div class="daxx">
									<table width=100% border="0" cellspacing="0px" cellpadding="">
										<!-- 流水号列开始  -->
										<tbody>
											<form id="form1" >
												<c:forEach var="serial" items="${serialList}">
													<tr>
														<td>${serial.serialNum}</td>
														<td>${serial.bumenName}</td>
														<td>${serial.count}</td>
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
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<input id="check-all" type="checkbox" onclick="selectGroup()" />全选 &nbsp; &nbsp; &nbsp;
					<input id="qrck" type="button" value="确认出库"  /> &nbsp; &nbsp; 
					<input id="jjsq" type="button" value="拒绝申请"  /> &nbsp; &nbsp;
					<input id="xqcx" type="button" value="查询详情" style="width: 80px;"/>
				</td>
			</tr>
		</table>
	</div>
	<div style="margin-left: 30%; margin-top: 10px;">档案详情:</div>
	<div class="qfjm2">
		文件数：<span id="paperCount">0</span>份
		<div class="daxx2">
			<table style="margin: auto; width: 950px;" border="1px" cellspacing="0px" cellpadding="">
				<tr>
					<td>
						<table border="1px" style="margin: auto;"  cellspacing="0px" cellpadding="">
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
								<table width=100% border="1" cellspacing="0px" cellpadding="">
									<!-- 流水号列开始  -->
									<tbody id="tb">
										<script type="text/html" id="list">
											{{each paper as p i}}
											<tr>
												<td>{{p.danganNum}}</td>
												<td>{{p.bumenName}}</td>
												<td>{{p.wupinName}}</td>
												<td>{{p.qianfengDate}}</td>
												<td>{{p.daoqiDate}}</td>
												<td>{{p.fuzeren}}</td>
												<td>{{p.kehujingli}}</td>
												<td>{{p.dianhua}}</td>
											</tr>
											{{/each}}
										</script>
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