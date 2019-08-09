<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		<c:forEach var="rb" items="${books}">
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='${pageContext.request.contextPath}/book/queryOne?id=${rb.id}&key=${rb.id}' target='_blank'>
					<img class="book-cover" src="${pageContext.request.contextPath}/back/img/${rb.cover}" width=70 border=0 /> 
				</a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='${pageContext.request.contextPath}/book/queryOne?id=${rb.id}&key=${rb.id}' target='_blank' title='输赢'>${rb.name}</a>
				</h3>
				<h4>
					作者：${rb.author} 著
					<br />
					出版社：${rb.press}&nbsp;&nbsp;&nbsp;&nbsp;
					出版时间：<fmt:formatDate value="${rb.press_date}" pattern="yyyy-MM-dd"/>
				</h4>
				<h5>
					${rb.content_abstract}
				</h5>
				<h6>
					定价：￥${rb.price}&nbsp;&nbsp;
					当当价：￥${rb.dprice}
					销量：<font color="red">${rb.sale}</font>
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
		</c:forEach>
	</div>
</div>
