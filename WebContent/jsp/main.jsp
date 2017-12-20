<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./layouts/layout.jsp" %>
	<script src="${ contextPath }/js/main.js"></script>
	<link rel="stylesheet" href="${ contextPath }/css/main.css">
	<title>WebDressing</title>
</head>
<body>
	<c:if test="${ !empty user }">
		<%
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/login-main.jsp");
			rd.forward(request,response);
		%>
	</c:if>
	<% session.invalidate(); %>
	<nav class="navbar navbar-dark bg-dark justify-content-between">
		 <a class="navbar-brand" href="${ contextPath }/main.run">
		   <img src="${ contextPath }/img/logo.png" width="30" height="30" alt="Logo">
		   	WebDressing
		 </a>
	 	<button id="login" class="btn btn-dark" type="button"  data-toggle="modal" data-target="#login-modal">로그인</button>
	</nav>
	<header>
		<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
		  <ol class="carousel-indicators">
		    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="bg active"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="1" class="bg"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="2" class="bg"></li>
		  </ol>
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img class="d-block w-100" src="${ contextPath }/img/first.png" alt="First slide">
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="${ contextPath }/img/second.png" alt="Second slide">
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="${ contextPath }/img/third.png" alt="Third slide">
		    </div>
		  </div>
		  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon " aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div>
	</header>
	<article>
		<div class="container" id="article-container">
			<div class="row">
				<c:forEach var="data" items='${ data }' begin='0' end='3' step='1' varStatus="status">
				<fmt:parseNumber var="i" type="number" value='${ data.earn }' />
				<c:set var="earn" value="${ i }" />
					<div class="col-md-3">
						<div class="card">
							<div class="dish">
								<img class="card-img-top profile-img" src="${ contextPath }/upload/${ data.profileImage }" alt="Card image cap">
						  		<button onclick="view_profile(this)" type="button" class="btn btn-dark view-pro vivify popIn">프로필 보기</button>
						  		<input type="hidden" value="${ status.count }" name="for_view">
							</div>
						  <div class="card-body">
						  	<h4 class="card-title">${ status.count}. ${ data.nickname }</h4>
						    <p class="card-text">총 수익 : <fmt:formatNumber type="currency" value = "${ earn }" pattern="###,###"/></p>
						    <p class="card-text">${ data.profile_content }</p>
						  </div>
						</div>
					</div>
				</c:forEach>
				
			</div>
		</div>
		<%@ include file="./layouts/footer.jsp" %>
	</article>
	<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">로그인</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body" id="modal-body">
		      <div class="container">
		      	<form class="row" action="${ contextPath }/login.run" id="loginForm" method="post">
			      	<div class="input-group">
			      		<input name="userId" id="userId" type="text" class="form-control log" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
			      	</div>
			      	<br>
			      	<div class="input-group">
						<input name="password" id="password" type="password" class="form-control log" placeholder="Password" aria-label="Password" aria-describedby="basic-addon1">		      	
			      	</div>
					<div class="input-group">
						<a href="${ contextPath }/jsp/signup.jsp" id="toSignUp">아직 회원이 아니신가요?</a>
					</div>
	      		</form>
		      </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
	        <button id="log-in" type="button" class="btn btn-primary">로그인</button>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>