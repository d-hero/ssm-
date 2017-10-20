<%@ page language="java" import="java.util.*,entity.*,dao.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function delemp(id){
	if (confirm("确认删除该项?")) {
					location.href="contactdelet?id="+id;			
				}
}
</script>
  </head>
  
  <body>
  <input type="button" value="新增" onclick="window.location.href='contact'">
  <table border="1" cellpadding="10" cellspacing="0" width="50%">
	<tr>
	<th>联系人姓名</th>
	<th>电话</th>
	<th>email</th>
	<th>类型</th>
	<th>操作1</th>
	<th>操作2</th>
	</tr>
	<c:forEach items="${list}" var="ci">
	<tr><td>${ci.name }</td><td>${ci.mobile }</td><td>${ci.email }</td><td>${ci.contactType.typeName}</td>
	<td><a href="javascript:delemp(${ci.id})">删除</a></td>
	<td><a href="contact/detail/${ci.id }">修改</a></td></tr>
	</c:forEach>

	</table>
  </body>
</html>
