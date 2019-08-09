<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
			 function delayURL() {
              var delay = document.getElementById("time").innerHTML;
              var t = setTimeout("delayURL()",0);
              if (delay > 0) {
                  delay--;
                  document.getElementById("time").innerHTML = delay;
              } else {
                  clearTimeout(t);
                  window.parent.location.href = "${pageContext.request.contextPath}/back/login.jsp";
              }
          };
	</script>
  </head>
  
  <body onload="delayURL()">
	<span style="color:red" id="time">1</span>
  </body>
</html>
