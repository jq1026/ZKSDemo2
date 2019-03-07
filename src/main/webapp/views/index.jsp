<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>登陆</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/views/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function loadcity(){
		/* alert("测试位置一"); */
		var province_name=$(".pro").val();
		$(".city").html('<option value="">请选择</option>');
		var cityList=null;
		$.ajax({
			 url: "/ZKSDemo2/sys/getcity/"+province_name, 
			type: "POST",
			dataType: "json",
			contentType:"application/json",
			success: function(data){
				$(".city").html('<option value="">请选择</option>');		
				 cityList=data; 
					for(var key in cityList){
						$(".city").append('<option onclick="loadcounty()">'+cityList[key]+'</option>');
					}
				},
		});
	}
	function loadcounty(){
		 var city_name =$(".city").val();  
		 var county=null;
		 $(".county").html('<option value="">请选择</option>');
			$.ajax({
				url : "/ZKSDemo2/sys/getcounty/"+city_name, 
				type : "post", 
				dataType : "json",
				contentType:"application/json",
				success : function(data){
					$(".county").html('<option value="">请选择</option>');		
					county=data; 
						for(var key in county){
							$(".county").append('<option>'+county[key]+'</option>');
						}
					},		
			});
	}
	
</script>

</head>
<body>
	<form action="<c:url value="/sys/select"/>" method="post"  style="margin:0px;display:inline;">
		用户姓名：<input type="text" name="user_name" >
		电话：<input type="text" name="tele_phone">
			区域：<select class="pro" name="province_name">
				
    			 	<option value="">请选择</option>
    			 	<c:forEach items="${larea}" var="larea" >
    					<option value="${larea.name }" onclick="loadcity()">${larea.name }</option>
    				</c:forEach>
    			
			 </select>
			 <select id="city_name" name="city_name" class="city" >
				<option value="" >请选择</option>
			 </select>
			 <select id="county_name" name="county_name" class="county">
				<option value="">请选择</option>
			 </select>
		<input type="reset" value="清空">
		<input type="submit" value="查询">	
	</form>
	<a href="addt"><button>新增</button></a>
	<a href="getex"><button>excel导出</button></a>
	<table  border="2" style="width: 90%">
		<tr>
			<td>序号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>电话</td>
			<td>邮箱</td>
			<td>角色</td>
			<td>工号</td>
			<td>创建时间</td>
			<td>省</td>
			<td>市</td>
			<td>区/县</td>
			<td colspan="2">&nbsp;&nbsp;&nbsp;操作</td>
		</tr>
	     <c:if test="${!empty users}">
	         <c:forEach items="${users}" var="user" varStatus="status">
	        	 	<tr>
	                    <td>${status.index+1 }</td>
	                    <td>${user.user_name }</td>
	                    <td><c:if test="${user.sex==1 }">男</c:if><c:if test="${user.sex==0 }">女</c:if></td>
	                    <td>${user.tele_phone }</td>
	                    <td>${user.mail }</td>
	                    <td>${user.role_name }</td>
	                    <td>${user.job_num }</td>
	                    <td>${user.create_time }</td> 
	                    <td>${user.province_name }</td> 
	                    <td>${user.city_name }</td> 
	                    <td>${user.county_name }</td> 
	                    <td><a href="deleteuser?user_name=${user.user_name }" onclick="return confirm('确定删除？');">删除</a></td>
	                    <td><a href="getone?user_code=${user.user_code }">修改</a></td>
	                </tr>
	        </c:forEach>
	    </c:if>
    </table>
  
   <!--  <a href="addt"><button>添加</button></a> -->
</body>
</html>

