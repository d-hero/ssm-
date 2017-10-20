<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <!-- 这里要确保元素里面的name跟属性名称一样一样 -->
    <form action="doAdd3" method="get">
    商品类型：<select name="goodsTypeInfo.id">
    <option value="1">食品</option>
    <option value="2">冷冻</option>  
    </select>
     商品名称：<input type="text" name="gName">
   价格：<input type="text" name="price" >
   说明：<input type="text" name="remark" > 
    保质期：<input type="text" name="keepTime"  >
    <img src="img/a.jpg">
    <input type="submit" value="新增" >
    </form>
  </body>
</html>
