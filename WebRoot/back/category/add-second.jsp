<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>index.html</title>
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=GBK">
    <link rel="stylesheet" href="../css/btn.css" />
    <style type="text/css">
		body{
			text-align: center;
		}
		select{
			width:173px;
		}
    </style>
    <script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
  </head>
  
  <body style="background-color: #f0f9fd;">
  	<div style="text-align:center ;font-size:18px">添加商品类别</div><hr/>
  	
  	<form action="${pageContext.request.contextPath}/category/addSecondCategory" method="post">
		所属一级类别:		
		<select name="cate.parentId" class="el-select__inner">
		<c:forEach var="ls" items="${lists}">
			<option value="${ls.id}">${ls.name}</option> 
		</c:forEach>
		</select>
  		<br/><br/>
  		二级类别名:<input class="el-input__inner" type="text" name="cate.name" id="sname"/><br/><br/>
  		<input class="button btn-p" type="submit" value="提交"/>&emsp;
		<input class="button btn-p" type="button" value="返回上级" onclick="history.go(-1);"/>
  	</form>
  
    	
  </body>
</html>
