$(document).ready(function(){
	// 최대 수익자 4명의 프로필 관련 이벤트
	$('.profile-img').on('mouseenter',function(){
		$(this).parent().find('.profile-img').css('filter','brightness(40%)');
		$(this).parent().find('.view-pro').css('display','block');
	});
	$('.profile-img').on('mouseleave',function(){
		
		$(this).parent().find('.view-pro').css('display','none');
		$(this).parent().find('.profile-img').css('filter','none');

		$('.view-pro').on('mouseenter',function(){
			$(this).parent().find('.view-pro').css('display','block');
		});
	});
	// 최대 수익자 4명의 프로필 관련 이벤트중 버튼 이벤트
	$('.view-pro').on('mouseenter',function(){
		$(this).parent().find('.profile-img').css('filter','brightness(40%)');
	});
	
	// 이건 로그인 액션이다
	$('#log-in').on('click',function(){
		var modal = $('#modal-body');
		
		var userId = modal.find('#userId').val();
		var password = modal.find('#password').val();
				
		var actionUrl = $('form[id=loginForm]').attr('action');
		
		var data = {'userId':userId,'password':password};
	
		$.ajax({
			type:'POST',
			url:actionUrl,
			data:data,
			success:function(data){
				if(data.error){
					$('#userId').css('border','1px solid red');
					$('#password').css('border','1px solid red');
				} else if(data.success){
					location.replace(contextPath+"/jsp/login-main.jsp");
				}
			}
		});
		
	});
});

// 프로필 보여주기
function view_profile(me){
	var id = $(me).parent().find('input[name=for_view]').val();
	
	$.ajax({
		type:'post',
		url:'/WebClass/redirect.run',
		data:{'id':id,'view':'true'},
		success:function(data){
			if(data.success){
				location.replace(contextPath+'/jsp/profile.jsp');
			} else{
				alert("실패함ㅜ");
			}
		}
	});
}