<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>档案签封</title>
		<style type="text/css">
			.qfjm {
				width: 600px;
				height: 500px;
				border: 1px solid #F00;
				margin: 200px auto;
				height-align: middle;
				;
			}
		</style>
		
		<!-- <script>
		$(document).ready(function(){
		    initAreaOption();
		});
	
		function initAreaOption() {
		    $('#submit').onclick(function(){
		        var danganId = document.getElementsById("danganId").value;
		        var bumenId = document.getElementsById("bumenId").value;
		        var wupinId = document.getElementsById("wupinId").value;
		        var fuzeren = document.getElementsById("fuzeren").value;
		        var kehujingli = document.getElementsById("kehujingli").value;
		        var dianhua = document.getElementsById("dianhua").value;
		        $.ajax({
		            dataType: 'json',
		            type : 'post',
		            url : "/Game/area",
		            data: {
		            	gameId: gameId
		            },
		            success : function(data){
		                if(data.success){
		                	var areas = data.areas;
		                	for (var i in areas) {
		                    	$("#area").append("<option value =" + areas[i].id +">" + areas[i].name + "</option>");
		                	}
		                }else {
		                    alert(data.success);
		                }
		            },
		            error:function(XMLHttpRequest ,errMsg){
		                alert("网络连接失败");
		            }
		        });
		    });
		}
	</script> -->
		
	</head>

	<body>
		<div class="qfjm">
			<table cellspacing="0" cellpadding="10px" style="margin: auto;margin-top: 20px;">
				<form method="post" action="add">
					<tr>
						<td>档案袋编号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="fileNum" name="fileNum" type="text" style="height:20px;width:300px">&nbsp;*</td>
					</tr>
					<tr>
						<td>档案编号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="danganNum" name="danganNum" type="text" style="height:20px;width:300px">&nbsp;*</td>
					</tr>
					<tr>
						<td>部门名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<select id="bumenId" name="bumenId" style="height:20px;width:295px">
								<option value="1">部门A</option>
								<option value="2">部门B</option>
							</select> &nbsp;*
						</td>
					</tr>
					<tr>
						<td>签封日期：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="qianfengDate" name="qianfengDate" type="text" style="height:20px;width:300px" disabled="true" >&nbsp;*</td>
					</tr>
					<tr>
						<td>到期日：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="daoqiDate" name="daoqiDate" type="text" style="height:20px;width:300px" disabled="true" >&nbsp;*</td>
					</tr>
					<tr>
						<td>封存物品名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<select id="wupinId" name="wupinId" style="height:20px;width:295px">
							<option value="1">二手房屋抵押合同</option>
							<option value="2">二手汽车抵押合同</option>
						</select> &nbsp;*</td>
					</tr>
					<tr>
						<td>负责人：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="fuzeren" name="fuzeren" type="text" style="height:20px;width:300px"></td>
					</tr>
					<tr>
						<td>客户经理：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="kehujingli" name="kehujingli" type="text" style="height:20px;width:300px"></td>
					</tr>
					<tr>
						<td>电话：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="dianhua" name="dianhua" type="text" style="height:20px;width:300px"></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="submit" type="submit" value="确定" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="取消"></td>
					</tr>
				</form>
			</table>
		</div>
	</body>
	<script type="text/javascript">
		function today(){
		    var today=new Date();
		    var h=today.getFullYear();
		    var m=today.getMonth()+1;
		    var d=today.getDate();
		    return h+"年"+m+"月"+d+"日";
		}
		document.getElementById("qianfengDate").value = today();
	</script>
	
	<script type="text/javascript">
		function daoqiDate(){
		    var today=new Date();
		    var h=today.getFullYear()+1;
		    var m=today.getMonth()+1;
		    var d=today.getDate();
		    return h+"年"+m+"月"+d+"日";
		}
		document.getElementById("daoqiDate").value = daoqiDate();
	</script>
	
</html>