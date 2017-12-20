<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./layouts/layout.jsp" %>
<script src="${ contextPath }/js/login-main.js"></script>
<link href="${ contextPath }/css/login-main.css" rel="stylesheet">

<title>Insert title here</title>
</head>
	<body>
	<%-- <c:if test="${ empty user }">
		<c:if test="${ empty view }">
			<% 
				RequestDispatcher rd = request.getRequestDispatcher("/main.run");
				rd.forward(request,response);
			%>
		</c:if>
	</c:if>
	<c:if test="${ !empty user }">
		<c:if test="${ !empty view }">
				<%
					session.setAttribute("visitor", session.getAttribute("user"));
					session.removeAttribute("user");
				%>
		</c:if>	
	</c:if> --%>
		<nav class="navbar navbar-dark bg-dark justify-content-between">
			 <a class="navbar-brand" href="${ contextPath }/main.run">
			   <img src="${ contextPath }/img/logo.png" width="30" height="30" alt="Logo">
			   	WebDressing
			 </a>
			 
			 <c:if test="${ empty view }">
			 <li class="nav-item dropdown" id="personal">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        				${ user.nickname }
		        </a>
		        
		        <div class="dropdown-menu vivify popIn" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item toDashboard" >프로필 수정</a>
		          <a class="dropdown-item toDashboard" >나만의 UI 만들기</a>
		          <a class="dropdown-item toDashboard" >내가 구매한 UI</a>
		          <a class="dropdown-item toDashboard" >판매 시작하기</a>
		          <a class="dropdown-item" href="${ contextPath }/logout.run">로그아웃</a>
		        </div>
	     	 </li>
	     	 </c:if>
		</nav>
		
		<article>
			<div class="container">
				<div class="row article-row">
					<div class="w-100 popular">
						<div class="blur"></div>
						<div class="text">
							<h3>가장 인기있는 UI는?</h3>
						</div>
					</div>
				</div>
				<div class="row justify-content-end arrange">
					<div class="btn-group arrange-dropdown">
					  <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					    Arrange
					  </button>
					  <div class="dropdown-menu">
					    <a class="dropdown-item">하이순</a>
					    <a class="dropdown-item">기마순</a>
					    <a class="dropdown-item">조리순</a>
					  </div>
					</div>
				</div>
				<div class="row sale_lists">
					<div class="item_container row">
						<div class="col-md-4 sale_list">
							<img src="${ contextPath }/img/sale_ex.jpg" class="uitem">
							<div class="owner_info vivify fadeIn duration-400">
								<div class="dish">
									<div class="ui_title">
										<h3>제목: 손쉬운 현대문학</h3>
									</div>
									<div class="ui_content">
										<p>
											이상의 거울, 그것도 있음, 그거 뭐지 이름, 사실 국어 못함 ㅎ
										</p>
									</div>
									<div class="ui_footer">
										<p>작가: 정은지</p>
										<p>가격: 5000원</p>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-4 sale_list">
							<img src="${ contextPath }/img/sale_ex.jpg" class="uitem">
							<div class="owner_info vivify fadeIn duration-400">
								<div class="dish">
									<div class="ui_title">
										<h3>제목: 손쉬운 현대문학</h3>
									</div>
									<div class="ui_content">
										<p>
											이상의 거울, 그것도 있음, 그거 뭐지 이름, 사실 국어 못함 ㅎ
										</p>
									</div>
									<div class="ui_footer">
										<p>작가: 정은지</p>
										<p>가격: 5000원</p>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-4 sale_list">
							<img src="${ contextPath }/img/sale_ex.jpg" class="uitem">
							<div class="owner_info vivify fadeIn duration-400">
								<div class="dish">
									<div class="ui_title">
										<h3>제목: 손쉬운 현대문학</h3>
									</div>
									<div class="ui_content">
										<p>
											이상의 거울, 그것도 있음, 그거 뭐지 이름, 사실 국어 못함 ㅎ
										</p>
									</div>
									<div class="ui_footer">
										<p>작가: 정은지</p>
										<p>가격: 5000원</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="item_container row">
						<div class="col-md-4 sale_list">
							<img src="${ contextPath }/img/sale_ex.jpg" class="uitem">
							<div class="owner_info vivify fadeIn duration-400">
								<div class="dish">
									<div class="ui_title">
										<h3>제목: 손쉬운 현대문학</h3>
									</div>
									<div class="ui_content">
										<p>
											이상의 거울, 그것도 있음, 그거 뭐지 이름, 사실 국어 못함 ㅎ
										</p>
									</div>
									<div class="ui_footer">
										<p>작가: 정은지</p>
										<p>가격: 5000원</p>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-4 sale_list">
							<img src="${ contextPath }/img/sale_ex.jpg" class="uitem">
							<div class="owner_info vivify fadeIn duration-400">
								<div class="dish">
									<div class="ui_title">
										<h3>제목: 손쉬운 현대문학</h3>
									</div>
									<div class="ui_content">
										<p>
											이상의 거울, 그것도 있음, 그거 뭐지 이름, 사실 국어 못함 ㅎ
										</p>
									</div>
									<div class="ui_footer">
										<p>작가: 정은지</p>
										<p>가격: 5000원</p>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-4 sale_list">
							<img src="${ contextPath }/img/sale_ex.jpg" class="uitem">
							<div class="owner_info vivify fadeIn duration-400">
								<div class="dish">
									<div class="ui_title">
										<h3>제목: 손쉬운 현대문학</h3>
									</div>
									<div class="ui_content">
										<p>
											이상의 거울, 그것도 있음, 그거 뭐지 이름, 사실 국어 못함 ㅎ
										</p>
									</div>
									<div class="ui_footer">
										<p>작가: 정은지</p>
										<p>가격: 5000원</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</article>
		
	</body>
</html>