<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>修改</title>
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
				$(".city").html('<option value="">'+data[0]+'</option>');		
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
					$(".county").html('<option value="">'+data[0]+'</option>');		
					county=data; 
						for(var key in county){
							$(".county").append('<option>'+county[key]+'</option>');
						}
					},
					/* success: function(data){
						alert(data);
					}, */
				
			});

	}
	
</script>
</head>
<body>
	
    <form action='<c:url value="/sys/update"></c:url>' method="post">
    
    	账号:<input type="hidden" name="user_code" value="${users.user_code }">  <p>
    		<input type="text" name="user_code" value="${users.user_code }" disabled="disabled"><p>
    	性名： <input type="text" name="user_name" value="${users.user_name }">  <p>
    	性别:<input type="radio" name="sex" value="1">男
    	<input type="radio" name="sex" value="0">女<p>
    	电话：<input type="text" name="tele_phone" value="${users.tele_phone}"><p>
    	邮箱：<input type="email" name="mail" value="${users.mail }"><p>
    	角色:<select name="role_name">
    			<c:forEach items="${rlist}" var="rlist" >
    					<option value="${rlist.role_name }" >${rlist.role_name }</option>
    			</c:forEach>
    		</select><p>
    	工号：<input type="text" name="job_num" value="${users.job_num }"><p>
    	创建时间：<input type="text" name="create_time" value="${users.create_time }"><p>
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
			 </select><p>
    	<input type="submit" value="修改" >
  		<input type="reset" value="重置">
    </form>
</body>
</html>

