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
				height: 150px;
				width: 600px;
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
			

			/* function act3() {
				document.form2.action = "urgency";
				if ($('#tb2 :checked').size()!=0) {
					document.form2.submit();
				} else{
					alert("请选择文件");					
				}
			} */
			
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
						<td style="height: 200px; width: 600px;">
							<div class="daxx">
								<table width=95%; border="1px" style="margin: auto;" >
									<thead>
										<th>文件编号</th>
										<th>所属人</th>
										<th>文件名</th>
										<th>签封日期</th>
										<th>选择</th>
									</thead>
									<!-- 文件列开始  -->
									<tbody id="tb1">
										<script type="text/html" id="list1">
											{{each paper as p}}
												<tr>
													<td>{{p.fileNum}}</td>
													<td>{{p.custName}}</td>
													<td>{{p.fileName}}</td>
													<td>{{p.qianfengDate}}</td>
													<td>
														<input type="checkbox" name="fileNums" value={{p.fileNum}} />
													</td>
												</tr>
											{{/each}}
										</script>
									</tbody>
								</table>
							</div>
						</td>
					</tr>
				</table>
				<input style="margin-left: 120px; margin-top: 10px;" id="add-btn" type="button" value="添加"  />
			</div>
			<div style="margin-left: 30%;margin-top: 10px;">流水号：<span id="sNum">${serial}</span> </div>
			<div style="margin-left: 30%; margin-top: 10px;">已添加: <span id="count">0</span> 份</div>
			<div id="gdiv" class="qfjm2">
				<table border="1px" cellspacing="0px" cellpadding="" style="margin: 10px auto;">
					<tr>
						<td>
							<div class="daxx2">
								<form id="form2" method="post" action="query">
									<input type="hidden" name="serial" value='${serial}'/>
									<table width=95%; border="1px" style="margin: auto;">
										<thead>
											<th>文件编号</th>
											<th>所属人</th>
											<th>文件名</th>
											<th>签封日期</th>
											<th>选择</th>
										</thead>
										<tbody id="tb2">
										</tbody>
									</table>
								</form>
							</div>
						</td>
					</tr>
				</table>
				<input id="check-all" style="margin-left: 120px; margin-top: 10px;" type="checkbox" onclick="selectGroup()" />全选 &nbsp;
				<input style="margin-left: 20px; margin-top: 10px;" type="button" id="subbtn" value="申请出库" " />
				<!--<input style="margin-left: 20px; margin-top: 10px;" type="button" value="紧急出库" onclick="act3();" />-->
				<input style="margin-left: 20px; margin-top: 10px;" id="remove-btn" type="button" value="移除"  />
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
								in1=$('#tb1 input');
								in2=$('#tb2 input');
								tr1=in1.parent().parent();
								in1.each(function(i,item1){
//									alert(item1.value);
									in2.each(function(j,item2){
										if (item1.value==item2.value) {
											tr1[i].remove();
										}
									}); 
								});
							} else{
								alert(data.errorMsg);
							}
						},
					}
					$(this).ajaxSubmit(options);
					e.preventDefault();
				});
				
				$("#subbtn").click(function(){
					$('#form2').unbind();
					$('#form2').submit(function(e){
						var options={
							url:"apply",
							type:"post",
							dataType:"json",
							beforeSubmit:function(){
								if ($('#tb2 :checked').size()==0) {
									alert("请选择文件");
									return false;
								} 
							},
							success:function(data,textStatus){
								if (data.success) {
									alert("申请出库成功");
									window.location.href="../ywy"
								} else{
									alert(data.errorMsg);
								}
							},
							error:function(data,textStatus){
								alert("服务器未响应");
							},
						}
						$(this).ajaxSubmit(options);
						e.preventDefault();
					}); 
					$('#form2').submit();
				});
				
				$('#add-btn').click(function(){
					var trs = $('#tb1 :checked').parent().parent();
					$('#tb1 :checked').attr("checked",false);
					$('#tb2').append(trs);
					$('#count').html($('#tb2 tr').size());
				});
				
				$('#remove-btn').click(function(){
					var trs = $('#tb2 :checked').parent().parent();
					$('#tb2 :checked').attr("checked",false);
					$('#tb1').append(trs);
					$('#count').html($('#tb2 tr').size());
				})
				
			});
		</script>
	</body>

</html>