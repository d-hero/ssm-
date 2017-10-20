<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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
    <form action="contact" method="post">
    联系人类型：<select name="contactType.typeId">
    <c:forEach items="${list}" var="ct">
    <option value="${ct.typeId}">${ct.typeName}</option>
    </c:forEach> 
    </select>
     联系人姓名：<input type="text" name="name">
  手机：<input type="text" name="mobile" >
   email：<input type="email" name="email" >    
    <input type="submit" value="新增" >
    </form>
  </body>
</html>
