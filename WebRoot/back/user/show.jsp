<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/back/css/btn.css" />
	</head>
	<body style="background-color: #f0f9fd;">
		<div align=center style="font-size:25px">用户管理</div><hr/>
		<table bordercolor='#898E90' align='center' border='3px' cellpadding='10px' cellspacing="0px">
			<tr bgcolor='lightblue' align='center'>
				<td>Id</td>
				<td>昵称</td>
				<td>邮箱</td>
				<td>状态</td>
				<td>激活码</td>
				<td>操作</td>
			</tr>
			<c:forEach var="u" items="${users }">
			<tr align='center'>
				<td>${u.id }</td>
				<td>${u.nickname }</td>
				<td>${u.email }</td>
				<td>${u.status }</td>
				<td>${u.code }</td>
				<td>
					<input class="button" onclick="location.href='${pageContext.request.contextPath}/admin/modifyStatus?id=${u.id}'" value="修改 &raquo;" />
				</td>
			</tr>
			</c:forEach>
		</table>
	</body>  
</html>



