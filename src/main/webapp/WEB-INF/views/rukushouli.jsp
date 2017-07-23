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
		
		<script type="text/javascript" src="../js/jquery-1.9.1.min.js" ></script>
		<script type="text/javascript" src="../js/jquery.form.min.js.js" ></script>
		<script type="text/javascript" src="../js/template.js" ></script>
		<script type="text/javascript">
			$(function(){
				
				$('#querybtn').click(function(){
					$('#form1').unbind();
					$('#form1').submit(function(e){
						var options={
							url:"query",
							type:"get",
							dataType:"json",
							beforeSubmit:function(){
								var val=$('input:radio:checked').val();
					            if(val==null){
					                alert("请选择文件!");
					                return false;
					            }
							},
							success:function(data,textStatus){
								if (data.success) {
									$('#count').html(data.count);
									$("#tb1").html(template('list1',{paper:data.paperInfo.paperlist}));
									$("#tb2").html(template('list2',{paper:data.paperInfo.paperlist}));
									$("#sNum").attr("value",data.serialNum);
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
				
				$('#accbtn').click(function(){
					$('#form2').unbind();
					$('#form2').submit(function(e){
						var options={
							url:"accept",
							type:"post",
							dataType:"json",
							success:function(data,textStatus){
								if (data.success) {
									alert(data.sucCount+"件入库成功");
									window.location.reload();
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
					$('#form2').submit();
				});
				
				$('#qrbtn').click(function(){
					var str = $('#ta').val();
					var arr = str.split('\n');
					var numarr=$('#form2 input');
					$.each(arr,function(i,strVal){
						$.each(numarr, function(i,numVal) {
							if (strVal==numVal.value) {
								numVal.checked=true;
							}
						});
					});
				});
				
			})
		</script>		

	</head>

	<body>
		<div class="qfjm1">
			<div style="margin-top: 30px"></div>
			<table style="margin: auto;">
				<tr>
					<td><span>申请列表档案总数：${tote}</span></td>
					<td>文件列表档案数：<span id="count">0</span></td>
				</tr>
				<tr>
					<td>
						<table border="1px" cellspacing="0px" cellpadding="" style="margin: auto;">
							<!-- <tr>
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
							</tr> -->
							<td>
								<div class="daxx">
									<table width=100%; border="1" style="margin: auto;" cellspacing="0px" cellpadding="">
										<thead>
											<tr>
												<th>流水号</th>
												<th>文件数</th>
												<th>部门名称</th>
												<th>经办人</th>
												<th>选择</th>
											</tr>
										</thead>
										<!-- 流水号列开始  -->
										<tbody>
											<form id="form1">
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
										<!-- 流水号列结束 -->
									</table>
								</div>
							</td>

						</table>
					</td>
					<td>
						<table border="1px" cellspacing="0px" cellpadding="" style="margin: auto;">
							<tr>
							<!-- 	<td>
									<table width="50%">
										<th>
											档案编号
										</th>
										<th>
											签封日期
										</th>

									</table>
								</td> -->
							</tr>
							<td>
								<div class="daxx">
									<form id="form2">
										<input type="hidden" id="sNum" name="serialNum" />
										<table width=60%; border="1" style="margin: auto;width:300px;"cellspacing="0px" cellpadding="">
											<thead>
												<th>
													档案袋编号
												</th>
												<th>
													签封日期
												</th>
											</thead>
											<tbody id="tb1">
												<script type="text/html" id="list1">
													{{each paper as p}}
														<tr>
															<td>{{p.fileNum}}</td>
															<td>{{p.dateStr}}<input type="hidden" name="fileNum" value='{{p.fileNum}}' />
															</td>
														</tr>
													{{/each}}
												</script>
											</tbody>
										</table>
									</form>
								</div>
							</td>
						</table>
					</td>
					<td>
						<tr>
							<td>
								<input id="querybtn" type="button" value="搜索" style="width: 80px;" />
							</td>
							<td>
								<!--<input id="check-all" type="checkbox" onclick="selectGroup()" />全选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-->
								<input type="button" id="accbtn" value="确认入库" />
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
							<th>档案名称</th>
							<th>客户姓名</th>
							<th>签封日期</th>
							<th>客户经理</th>
						</tr>
					</thead>
					<tbody id="tb2">
						<script type="text/html" id="list2">
							{{each paper as p}}
								<tr>
									<td>{{p.fileNum}}</td>
									<td>{{p.fileName}}</td>
									<td>{{p.custName}}</td>
									<td>{{p.dateStr}}</td>
									<td>{{p.mName}}</td>
								</tr>
							{{/each}}
						</script>
					</tbody>
				</table>
			</div>
		</div>
	</body>

</html>