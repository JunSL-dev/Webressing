<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./layouts/layout.jsp" %>
<link href="${ contextPath }/css/dashboard.css" rel="stylesheet">
<script src="${ contextPath }/js/dashboard.js"></script>
<title>Dash Board</title>
</head>
<body>
	<%-- <c:if test="${ empty user }">
		<% 
			RequestDispatcher rd = request.getRequestDispatcher("/main.run");
			rd.forward(request,response);
		%>
	</c:if> --%>
	<header>
		<div class="window">
			<div class="close">
				<i class="fa fa-close"></i>
			</div>
			<div class="save">
				<span action="${ contextPath }/dashboardsave.run" id="submit">저장하기</span>
				<input id="id" type="hidden" value="${ id }">
			</div>
		</div>
		<div class="dashboard">
			<ul id="storyboard">
			</ul>
		</div>
		<div class="choose">
			<input id="isLayout" type="checkbox" value="isLayout">
			<label for="isLayout">Layout</label>	
		</div>
	</header>
	<article>
		<section id="tool-box" class="inline box">
			<div class="tools">
				<ul>
					<li id="move" class="tool"><i class="fa fa-arrows" aria-hidden="true"></i></li>
					<li id="mkfigure" class="tool"><i class="fa fa-square-o" aria-hidden="true"></i></li>
					<li class="tool"><i class="fa fa-snowflake-o" aria-hidden="true"></i></li>
					<li id="mktext" class="tool"><i class="fa fa-font" aria-hidden="true"></i></li>
				</ul>
			</div>
		</section>
		<section id="work-field" class="inline">
		 	
		</section>
		<section id="bool-box" class="inline box">
		
		</section>
	</article>
</body>
</html>