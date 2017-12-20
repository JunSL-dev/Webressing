<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./layouts/layout.jsp"%>
<script src="${ contextPath }/js/signup.js"></script>
<link href="${ contextPath }/css/signup.css" rel="stylesheet">
<title>가입하세요!</title>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark justify-content-between">
		 <a class="navbar-brand" href="${ contextPath }/main.run">
		   <img src="${ contextPath }/img/logo.png" width="30" height="30" alt="Logo">
		   	WebDressing
		 </a>
	</nav>
	<article>
		<div class="row">
			<div id="carouselExampleIndicators" class="carousel slide col-md-5" data-ride="carousel">
			  <ol class="carousel-indicators">
			    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="bg active"></li>
			    <li data-target="#carouselExampleIndicators" data-slide-to="1" class="bg"></li>
			    <li data-target="#carouselExampleIndicators" data-slide-to="2" class="bg"></li>
			  </ol>
			  <div class="carousel-inner vivify fadeInRight">
			    <div class="carousel-item active">
			      <img src="${ contextPath }/img/r_ex1.png" alt="First slide">
			    </div>
			    <div class="carousel-item">
			      <img src="${ contextPath }/img/r_ex2.png" alt="Second slide">
			    </div>
			    <div class="carousel-item">
			      <img src="${ contextPath }/img/r_ex3.png" alt="Third slide">
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
			<div class="col-md-7  vivify fadeInRight delay-200">
				<div class="row frame">
					<div class="w-100 sun9">
						<div class="container">
							<p>이용약관이얌</p>
						</div>
					</div>
					<div class="w-100 sun92">
						<div class="container">
							<form action="${ contextPath }/signup.run" id="new_member" method="POST" enctype="multipart/form-data">
								<div title="1" class="sign_page">
									<div class="form-group">
										<label for="name">이름</label>
										<input name="name" type="text" class="form-control" id="name" aria-describedby="nameHelp" placeholder="이름을 입력해주세요" required>
									</div>
									<div class="form-group">
										<label for="userID">아이디</label>
										<input name="userId" type="text" class="form-control" id="userID" aria-describedby="userIdHelp" placeholder="아이디를 입력해주세요" required>
									  </div>
									  <div class="form-group">
										<label for="Password">비밀번호</label>
										<input name="password" type="password" class="form-control" id="Password" placeholder="비밀번호를 입력해주세요" required>
										<small id="PasswordHelp" class="form-text text-muted">비밀번호는 8자 이상 영어에 숫자를 곁들여 주세욘</small>
									  </div>
									  <div class="form-group">
										<label for="pwdCheck">비밀번호 확인</label>
										<input name="passwordCheck" type="password" class="form-control" id="pwdCheck" required>
									  </div>
								</div>
								<div title="2" class="sign_page" hidden>
									<div class="form-group">
										<label for="file">이미지 정보</label>
										<br>
										<label class="custom-file">
											<input name="fileName" type="file" id="file" class="custom-file-input">
											<span class="custom-file-control" title="Choose file...."></span>
										</label>
										<img id="profile-image" src="#" />
										<small class="form-text text-muted">어떤 이미지로 보이고싶나요?</small>
									</div>
									<div class="form-group">
										<label for="nickname">별칭</label>
										<input name="nickname" type="text" class="form-control" id="nickname" required>
										<small id="nicknameHelp" class="form-text text-muted">저희 WebDressing에서 어떠한 별칭으로 불리고 싶나요?</small>
									</div>
									<div class="form-group">
										<label>성별</label>
										<div class="form-check">
											<label class="form-check-label">
												<input class="form-check-input" type="radio" name="maleR" id="male" value="male">
												male
											</label>
										</div>
										<div class="form-check">
											<label class="form-check-label">
												<input class="form-check-input" type="radio" name="femaleR" id="female" value="female">
												female
											</label>
										</div>
									</div>
									<div class="form-group">
										<label for="phone">전화번호</label>
										<input name="phone" type="tel" class="form-control" id="phone" aria-describedby="phoneHelp" placeholder="전화번호를 입력해주세요" required>
										<small id="phoneHelp" class="form-text text-muted">전화번호는 - 를 제외하고 입력해주세욘!</small>
									</div>
									<div class="form-group">
										<label for="mail">e-mail</label>
										<input name="email" type="email" class="form-control" id="mail" aria-describedby="mailHelp" placeholder="이메일을 입력해주세요" required>
									</div>
								</div>
								<div title="3" class="sign_page" hidden>
									<div class="form-check">
										<label class="form-check-label">
											<input name="isSeller" type="checkbox" class="form-check-input" id="isSeller" value="true">
											판매자 되기!
										</label>
									</div>
									<div class="form-group vivify" id="account-group">
										<label for="account">계좌번호</label>
										<input name="account" type="text" class="form-control" id="account">
										<small id="accountHelp" class="form-text text-muted">판매자가 되고 싶다면, 계좌번호를 입력해주세요</small>
									</div>
								</div>
								<div title="4" class="sign_page" hidden>
									<div class="form-group">
										<label for="profile-content">프로필 정보</label>
										<textarea id="profile-content" name="profile-content" class="form-control profile-content" placeholder="원하는 프로필 소개를 입력해주세요" rows="3"></textarea>
									</div>
								</div>
								<div class="below">
									<div class="form-group">
										<button type="button" class="btn btn-outline-dark previous">이전</button>
									</div>
									<div class="form-group">
										<button type="button" class="btn btn-outline-dark next">다음</button>
									</div>
									<div class="sign">
										<button type="button" class="btn btn-dark submit" id="signUp">회원가입</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	<div class="modal fade" tabindex="-1" role="dialog" id="validate-error">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Validate Error</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <p>유효한 정보를 입력해주세요!</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
	      </div>
	    </div>
	  </div>
	</div>
	</article>
	
</body>
</html>