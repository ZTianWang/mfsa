<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>文件信息查询</title>
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
				width: 740px;
				overflow: scroll;
				background: #EEEEEE;
				margin: auto;
			}
			
			.daxx2 {
				height: 80px;
				width: 800px;
				overflow: scroll;
				background: #EEEEEE;
				margin: auto;
			}
			
			.a {
				display: inline;
			}
		</style>
		<script type="text/javascript" src="../js/jquery-1.9.1.min.js" ></script>
		<script type="text/javascript" src="../js/jquery.form.min.js.js" ></script>
		<script type="text/javascript" src="../js/template.js" ></script>
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
				if ($('#tb2 :checked').size()!=0) {
					document.form2.submit();
				} else{
					alert("请选择文件");					
				}
			}

			function act3() {
				document.form2.action = "urgency";
				if ($('#tb2 :checked').size()!=0) {
					document.form2.submit();
				} else{
					alert("请选择文件");					
				}
			}
			
		</script>

	</head>

	<body>
		<div>

			<div class="qfjm1">
				<div style="margin-top: 30px"></div>
				<form id="search" method="post" action="query">
					<div class="a" style="margin-left: 100px; margin-top: 50px;">
						文件编号：<input name="fileNum" type="text" style="width: 80px" />
					</div>
					<div class="a" style="margin-left: 50px; margin-top: 50px;">
						所属人：<input name="custName" type="text" style="width: 120px" />
					</div>
					<div class="a" style="margin-left: 50px; margin-top: 50px;">
						文件名：<input name="fileName" type="text" style="width: 120px" />
					</div>
					<div style="margin-top: 30px"></div>
					<div class="a" style="margin-left: 100px; margin-top: 10px;">
						签封日期：<input name="qianfengDateF" type="date" style="width: 120px" />-<input name="qianfengDateL" type="date" style="width: 120px" />
					</div>
					<div class="a" style="margin-left: 185px; margin-top: 10px;">
						<input type="submit" value="搜索" style="width: 80px;" />
					</div>
				</form>
				<div style="margin-top: 30px"></div>
				<table border="1px" cellspacing="0px" cellpadding="" style="margin: auto;">
					<tr>
						<td style="height: 200px; width: 800px;">
							<div class="daxx">
								<table width=100%; border="1px" style="margin: auto;" >
									<thead>
										<th>文件编号</th>
										<th>所属人</th>
										<th>文件名</th>
										<th>客户经理</th>
										<th>所属部门</th>
										<th>签封日期</th>
										<th>受理人</th>
										<th>是否在库</th>
										<th>库存位置</th>
									</thead>
									<!-- 文件列开始  -->
									<tbody id="tb1">
										<script type="text/html" id="list1">
											{{each paper as p}}
												<tr>
													<td>{{p.fileNum}}</td>
													<td>{{p.custName}}</td>
													<td>{{p.fileName}}</td>
													<td>{{p.mName}}</td>
													<td>{{p.bumenName}}</td>
													<td>{{p.dateStr}}</td>
													<td>{{p.ywyName}}</td>
													<td>
														{{if p.kucunState==1}}
														是
														{{else}}
														否
														{{/if}}
													</td>
													<td>{{p.position}}</td>
												</tr>
											{{/each}}
										</script>
									</tbody>
								</table>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<script type="text/javascript">
			
			$(function(){
				
				$('#search').submit(function(e){
					var options={
						url:"query",
						type:"post",
						dataType:"json",
						success:function(data,textStatus){
							if (data.success) {
								$('#tb1').html(template('list1',{paper:data.pageViews}));
							} else{
								alert(data.errorMsg);
							}
						},
					}
					$(this).ajaxSubmit(options);
					e.preventDefault();
				});
				
				
			});
		</script>
	</body>

</html>