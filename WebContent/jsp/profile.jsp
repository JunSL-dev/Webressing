<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./layouts/layout.jsp" %>
<script src="${ contextPath }/js/my_profile.js"></script>
<link href="${ contextPath }/css/my_profile.css" rel="stylesheet">
<script>
	var whichTab = "${ whichFunc }";
</script>

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
        				<input id="id" class="id" type="text" value="${ user.id }" hidden>
		        </a>
		        
		        <div class="dropdown-menu vivify popIn" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item toDashboard" >나만의 UI 만들기</a>
		          <a class="dropdown-item" href="${ contextPath }/logout.run">로그아웃</a>
		        </div>
	     	 </li>
	     	 </c:if>
		</nav>
		<article>
			<div class="row whole-profile">
				<div class="w-100 ">
					<div class="profile_nav">
						<div class="profile_container">
							<div class="profile_image inline border" style="background:url('../upload/${ result.profileImage }')"></div>
							<div class="profile_content inline border">
								<div class="profile_content_container">
									<div class="simple_info">
										<h3 class="names"><i class="fa fa-mars"></i>${ result.name }<span>(${ result.nickname })</span></h3>
										<h3 class="e-mail">${ result.email }</h3>
									</div>
									<div class="content_info">
										<p>${ result.profile_content }</p>
									</div>
									<div class="income_info">
										<h3>수입 : ${ result.earn }</h3>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="w-100 dish">
					<div class="main_dish">
						<div	 class="tabs border">
							<ul class="tabs_lists">
							<c:if test="${ whichFunc eq 'modify-profile'}">
								<li class="tab tab_active" title="modify-profile">프로필 수정하기</li>
							</c:if>
							<c:if test="${! (whichFunc eq 'modify-profile')}">
								<li class="tab" title="modify-profile">프로필 수정하기</li>
							</c:if>
							<c:if test="${ whichFunc eq 'UI'}">
								<li class="tab tab_active" title="UI">구매한 UI</li>
							</c:if>
							<c:if test="${ !(whichFunc eq 'UI')}">
								<li class="tab" title="UI">구매한 UI</li>
							</c:if>
							<c:if test="${ whichFunc eq 'beSeller'}">
								<li class="tab tab_active" title="beSeller">내가 만든 UI / 판매하기</li>
							</c:if>
							<c:if test="${ !(whichFunc eq 'beSeller')}">
								<li class="tab" title="beSeller">내가 만든 UI / 판매하기</li>
							</c:if>
							</ul>
						</div>
						<div class="tab_view border">
							<div class="view_container">
								<div class="view vivify fadeIn" title="modify-profile">
									modify
								</div>
								<div class="view vivify fadeIn" title="UI">
									UI
								</div>
								<div class="view vivify fadeIn" title="beSeller">
									<c:forEach var="item" items="${ dashboard }" varStatus="status">
										<c:if test="${ (status.count % 3) == 1 }">
											<div class="storages">
										</c:if>
											<div class="dashboard_storage">
												${ item.content }
											</div>
										<c:if test="${ (status.count % 3) == 0 }">
											</div>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</article>
		
	</body>
</html>