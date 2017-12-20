<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./layouts/layout.jsp" %>
<script src="${ contextPath }/js/my_profile.js"></script>
<link href="${ contextPath }/css/my_profile.css" rel="stylesheet">

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
		          <a class="dropdown-item toDashboard" >나만의 UI 만들기</a>
		          <a class="dropdown-item" href="${ contextPath }/logout.run">로그아웃</a>
		        </div>
	     	 </li>
	     	 </c:if>
		</nav>
		<article>
			<section class="row in_article">
				<div class="col-md-4 vivify popInTop">
					<div class="card" >
						<c:if test="${ empty view }">
						  <img class="card-img-top" src="${ contextPath }/upload/${ user.profileImage }" alt="Card image cap">
						</c:if>
						<c:if test="${ !empty view }">
						  <img class="card-img-top" src="${ contextPath }/upload/${ visitor.profileImage }" alt="Card image cap">
						</c:if>
						  <div class="card-body">
						    <h4 class="card-title">
						    	<c:if test="${ empty view }">
		        					${ user.nickname }
	        					</c:if>
	        					<c:if test="${ !empty view }">
	        						${ visitor.nickname }
	        					</c:if>
						    </h4>
					  </div>
			  			 <c:if test="${ empty view }">
						  	<ul class="list-group list-group-flush mkdash">
							    <li class="list-group-item profile_content">프로필 내용</li>
							    <li class="list-group-item"><a class="toDashboard link" >대쉬보드 만들기!</a></li>
							    <li class="list-group-item"><a class="link" >하하하</a></li>
							    <li class="list-group-item"><a class="link" >히히히힣!</a></li>
							    <li class="list-group-item"><a class="link" >지지지지!</a></li>
		    						<input id="id" type="hidden" value="${ user.id }" />
						  	</ul>
					  	</c:if>
					</div>
				</div>
				<div class="col-md-8" id="right">
					<div class="right-side">
						<c:forEach var="dashboard" items="${ dashboards }">
							<div class="dashboard_container vivify popIn card">
								${ dashboard.content }						
							</div>	
						</c:forEach>	
					</div>
				</div>
			</section>
		</article>
		<%-- 이것은 추후에 업데이트 예정인 녀석 --%>		
		<%-- <article>
			<!-- <header>
				
			</header> -->
		</article>
		
		<%@ include file="./layouts/footer.jsp" %> --%>
		
	</body>
</html>