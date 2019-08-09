<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javaScript">
			function updateCount(id){
				var count = $("#"+id).val();
				if(count>0){
					window.location.href="${pageContext.request.contextPath}/cart/updateCart?id="+id+"&count="+count;
				}
			}
		</script>
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="../images/pic_myshopping.gif" />
		</div>
		
		<c:choose>
			<c:when test="${total==0 || sessionScope.cart==null}">
		<div id="div_no_choice">
			<div class="choice_title"></div>
			<div class="no_select">
				您还没有挑选商品[<a href="${pageContext.request.contextPath}/book/main"> 继续挑选商品&gt;&gt;</a>]
			</div>
		</div>
		</c:when>
		<c:otherwise>
		
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品
			</h2>
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>&nbsp;</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">当当价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_2">
							<span>变更数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>
					<tr class='objhide' over="no">
						<td colspan="8">
							&nbsp;
						</td>
					</tr>
					
					<!-- 购物列表开始 -->
					<c:forEach var="c" items="${sessionScope.cart}">
					<c:if test="${c.value.status==1 }">
					<tr class='td_no_bord'>
						<td style='display: none'>
							b12345
						</td>
						<td class="buy_td_6">
							<span class="objhide">
								<img src="" /> 
							</span>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/book/queryOne?id=${c.value.book.id}&key=${c.value.book.id}">${c.value.book.name }</a>
						</td>
						<td class="buy_td_5">
							<span class="c_gray">￥${c.value.book.price }</span>
						</td>
						<td class="buy_td_4">
							&nbsp;&nbsp;
							<span>￥${c.value.book.dprice }</span>
						</td>
						<td class="buy_td_1">
							&nbsp;&nbsp;${c.value.count}
						</td>

						<td >
							<input id="${c.key}" class="del_num" type="number" size="3" maxlength="4" />
							<a href="#" onClick="updateCount('${c.key}')">变更</a>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/cart/deleteCart?id=${c.key}">删除</a>
						</td>
					</tr>
					</c:if>
					</c:forEach>
				</table>

				<div class="choice_balance">
					<div class="select_merch">
						<a href="${pageContext.request.contextPath}/book/main"> 继续挑选商品>></a>
					</div>
					<div class="total_balance">
						<div class="save_total">
							您共节省：
							<span class="c_red"> ￥<span id="total_economy">${sessionScope.save}</span> </span>
							<span style="font-size: 14px">|</span>
							<span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥<span id='total_account'>${sessionScope.total}</span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='${pageContext.request.contextPath}/front/order/order_info.jsp' > 
								<img src="../images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		</c:otherwise>
		</c:choose>
		<!--  
		<div id="divCartItemsRemoved" class="del_merch">
			<div class="del_title">
				您已删除以下商品，如果想重新购买，请点击“恢复”
			</div>
			
			<table class=tabl_del id=del_table>
				<tbody>
				  <c:forEach items="${sessionScope.cart}" var="s">
                   <c:if test="${s.value.status==0}">
					<tr>
						<td width="58" class=buy_td_6>
							&nbsp;
						</td>
						<td width="365" class=t2>
							<a href="#">${s.value.book.name}</a>
						</td>
						<td width="106" class=buy_td_5>
							￥${s.value.book.price}
						</td>
						<td width="134" class=buy_td_4>
							<span>￥${s.value.book.dprice}</span>
						</td>
						<td width="56" class=buy_td_1>
							<a href="${pageContext.request.contextPath}/cart/recoverCart?id=${s.key}">恢复</a>
						</td>
						<td width="16" class=objhide>
							&nbsp;
						</td>
					</tr>
					<tr class=td_add_bord>
						<td colspan=8>
							&nbsp;
						</td>
					</tr>
					</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		-->
		<!-- 用户删除恢复区结束 -->
		<br />
		<br />
		<br />
		<br />
		<!--页尾开始 -->
		<div style="position:absolute;bottom: 10px;width:100%;">
			<%@include file="../common/foot.jsp"%>
		</div>
		<!--页尾结束 -->
	</body>
</html>



