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
    
    <title>My JSP 'update.jsp' starting page</title>
    
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
   <form action="contact/${cinfo.id}" method="post">
    联系人类型：<select name="contactType.typeId">
    <c:forEach items="${list}" var="ct">
   
    <option value="${ct.typeId}"  <c:if test="${ct.typeId==cinfo.contactType.typeId}"> selected="selected"</c:if>>${ct.typeName}</option>
    </c:forEach> 
    </select>
     联系人姓名：<input type="text" name="name" value="${cinfo.name }">
  手机：<input type="text" name="mobile" value="${cinfo.mobile }">
   email：<input type="email" name="email" value="${cinfo.email }"> 
   <input type="hidden" name="id" value="${cinfo.id}">   
    <input type="submit" value="修改" >
    </form>
  </body>
</html>
