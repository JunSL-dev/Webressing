$(document).ready(function(){
	// db아뒤값, 어떤 기능인지 받아옵시다
	var DBid = $('#id').val();
	var whichFunc;
	
	// dashboard로 가봅시다
	$('.toDashboard').on('click',function(){
		var data = {
				"id":DBid
		};
		
		$.ajax({
			type:'POST',
			data:data,
			url:contextPath+"/dashboard.run",
			success:function(data){
				if(data.success){
					location.replace(contextPath+'/jsp/dashboard.jsp');
				}
			}
		});
		
	});
	
	// 프로필수정
	$('.modify-profile').on('click',function(){
		whichFunc = "modify-profile";
		
		var data = {
			"id":DBid,
			"whichFunc":whichFunc
		};
		
		$.ajax({
			type:'POST',
			data:data,
			url:contextPath+"/profile.run",
			success:function(data){
				if(data.success){
					location.replace(contextPath+"/jsp/profile.jsp");
				}
			}
		});
	});
	
	// 구매한 UI
	$('.UI').on('click',function(){
		whichFunc = "UI";
		
		var data = {
			"id":DBid,
			"whichFunc":whichFunc
		};
		
		$.ajax({
			type:'POST',
			data:data,
			url:contextPath+"/profile.run",
			success:function(data){
				if(data.success){
					location.replace(contextPath+"/jsp/profile.jsp");
				}
			}
		});
	});
	
	// 판매 시작하기
	$('.beSeller').on('click',function(){
		whichFunc = "beSeller";
		
		var data = {
			"id":DBid,
			"whichFunc":whichFunc
		};
		
		$.ajax({
			type:'POST',
			data:data,
			url:contextPath+"/profile.run",
			success:function(data){
				if(data.success){
					location.replace(contextPath+"/jsp/profile.jsp");
				}
			}
		});
	});
	
	// 3D 무빙
	$('.sale_list').on('mousemove',function(e){
		
		var posX = (e.pageX - $(this).offset().left - 1) - $(this).width()/2;
		var posY = (e.pageY - $(this).offset().top - 1) - $(this).height()/2;
		
		var rotateX = -posX*0.04;
		var rotateY = -posY*0.04;
		
		console.log(posX+"\n"+posY);
		
		$(this).css('transform','perspective(1000px) scale(1.07) rotateX('+rotateY+'deg) rotateY('+rotateX+'deg)');
	});
	$('.sale_list').on('mouseleave',function(){
		$(this).css('transform','none');
	});
});

$(window).resize(function(){
	// 마찬가지로 16:9 비율을 맞추어 볼까요~
	var padding = $('.dashboard_container').width()/100*56.25;
	$('.dashboard_container').css("padding-top",padding+"px");
});