<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath }/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/prototype-1.6.0.3.js"></script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="${pageContext.request.contextPath }/front/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='${pageContext.request.contextPath }/book/main'>当当图书</a> &gt;&gt;
			<font style='color:red'><strong>${firstCategory.name }</strong> </font>
			<c:forEach var="d" items="${firstCategory.second}">
			<c:if test="${sid==d.id}">
				 &gt;&gt;<font style='color:red'><strong>${d.name }</strong> </font>
			</c:if>
			</c:forEach>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
									<c:if test="${sid==null||sid==''}">
										<a href="${pageContext.request.contextPath }/book/subpage?id=${id }&currentPage=1"><frot style="color:red"><strong>&middot;全部&nbsp;</strong></frot></a>
									</c:if>
									<c:if test="${sid!=null&&sid!=''}">
										<a href="${pageContext.request.contextPath }/book/subpage?id=${id }&currentPage=1"><strong>&middot;全部&nbsp;</strong></a>
									</c:if>
									</div>
								</div>
							</li>
							<div class="clear"></div>
							<!--2级分类开始-->
							<c:forEach var="fd" items="${firstCategory.second }">
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
									<c:if test="${sid==fd.id}">
										<a href="${pageContext.request.contextPath}/book/subpage?sid=${fd.id}&id=${id }&currentPage=1"><font style="color:red"><strong>${fd.name }&nbsp;</strong></font></a>
									</c:if>
									<c:if test="${sid!=fd.id}">
										<a href="${pageContext.request.contextPath}/book/subpage?sid=${fd.id}&id=${id }&currentPage=1"><strong>${fd.name }&nbsp;</strong></a>
									</c:if>
									
									</div>
								</div>
							</li>
						    <div class="clear"></div>
							<div class="clear"></div>
							</c:forEach>
							<!--2级分类结束-->
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							
							<div class='list_r_title_text3a'>
								<a name=link_page_next href="${pageContext.request.contextPath}/book/subpage?id=${id}&sid=${sid }&currentPage=1">
									<img src='${pageContext.request.contextPath }/front/images/page_up.gif' /> 
								</a>
							</div>
	
							<div class='list_r_title_text3a'>
							<c:if test="${currentPage>1}">
								<a name=link_page_next href="${pageContext.request.contextPath}/book/subpage?id=${id}&sid=${sid }&currentPage=${currentPage-1}">
									<img src='${pageContext.request.contextPath }/front/images/page_up.gif' />
								</a>
							</c:if>
							<c:if test="${currentPage<=1}">
								<a name=link_page_next href="#">
									<img src='${pageContext.request.contextPath }/front/images/page_up_gray.gif' />
								</a>
							</c:if>
							</div>
				
							<div class='list_r_title_text3b'>
								第${currentPage }页/共${totalPage }页
							</div>
							
							<div class='list_r_title_text3a'>
								<c:if test="${currentPage<totalPage}">
								<a name=link_page_next href="${pageContext.request.contextPath}/book/subpage?id=${id}&sid=${sid }&currentPage=${currentPage+1}">
									<img src='${pageContext.request.contextPath }/front/images/page_down.gif' />
								</a>
							</c:if>
							<c:if test="${currentPage>=totalPage}">
								<a name=link_page_next href="#">
									<img src='${pageContext.request.contextPath }/front/images/page_down_gray.gif' />
								</a>
							</c:if>
							</div>
			
							<div class='list_r_title_text3a'>
								<a name=link_page_next href="${pageContext.request.contextPath}/book/subpage?id=${id}&sid=${sid }&currentPage=${totalPage}">
								<img src='${pageContext.request.contextPath }/front/images/page_down.gif' />
								</a>
							</div>

							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						<c:forEach var="book" items="${books }">
						<div class="list_r_list">
							<span class="list_r_list_book">
								<a name="link_prd_img" href='${pageContext.request.contextPath}/book/queryOne?id=${book.id}&key=${book.id}'>
									<img style="width:70px;height: 103px;" src="${pageContext.request.contextPath }/back/img/${book.cover}" /> 
								</a> 
							</span>
							<h2>
								<a name="link_prd_name" href='${pageContext.request.contextPath}/book/queryOne?id=${book.id}&key=${book.id}'>${book.name }</a>
							</h2>
							<h3></h3>
							<h4 class="list_r_list_h4">
								作 者:${book.author }
							</h4>
							<h4>
								出版社：${book.press }
							</h4>
							<h4>
								出版时间：<fmt:formatDate value="${book.press_date }" pattern="yyyy-MM-dd"/>
							</h4>
							<h4>
								销量：${book.sale }
							</h4>
							<h5>
								${book.content_abstract } 
							</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">￥${book.price }</span>
								<span class="red">￥${book.dprice }</span>
								节省：￥${book.price-book.dprice }
							</h6>
							<span class="list_r_list_button"> 
								<a href="${pageContext.request.contextPath}/cart/addCart?id=${book.id}"> 
									<img src='${pageContext.request.contextPath }/front/images/buttom_goumai.gif' />
								</a>
							</span>
						</div>
						<div class="clear"></div>
						</c:forEach>
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
