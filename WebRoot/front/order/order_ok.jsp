<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			 function delayURL() {
              var delay = document.getElementById("time").innerHTML;
              var t = setTimeout("delayURL()", 1000);
              if (delay > 0) {
                  delay--;
                  document.getElementById("time").innerHTML = delay;
              } else {
                  clearTimeout(t);
                  window.location.href = "${pageContext.request.contextPath}/book/main";
              }
          };
		</script>
	</head>
	<body onload="delayURL()">
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单步骤: 1.确认订单 > 2.填写送货地址 >
			<span class="red_bold">3.订单成功</span>
		</div>


		<div class="login_success">
			<div class="login_bj">
				<div class="succ">
					<img src="${pageContext.request.contextPath}/front/images/order_success.jpg" />
				</div>
				<h5>
					订单已经生成
				</h5>
				<h6>
					您刚刚生成的订单号是：<font color="red"><strong>${sessionScope.order_no }</strong></font>，
					金额总计<font color="red"><strong>${sessionScope.total}</strong></font>
				</h6>

				<ul>
					<li class="nobj">
						&nbsp;&nbsp;您还有<span style="color:red" id="time">5</span>秒进入首页
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/book/main">继续浏览并选购商品</a>
					</li>
				</ul>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

