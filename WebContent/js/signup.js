$(document).ready(function(){
	// 판매자입니까?
	var sellerCheck;
	// 폼 전송시 유효성 검사 후 보냄
	var validate;
	// 파일 업로드용 이름
	var fileName;
	// 현재 페이지용
	var current_page;

	// 현재 페이지가 무엇입니까아아아
	$('.sign_page').each(function(index){
        if(!$(this).attr('hidden')){
        	// 현재 페이지 입니다~~~~~
            current_page = $(this).attr('title');
		}
        move_page(current_page);
	});

	// 페이지 넘기기!!
	$('.next').on('click',function(){
		current_page = parseInt(current_page)+1;
        move_page(current_page);
    });

	$('.previous').on('click',function(){
		current_page = parseInt(current_page)-1;
		move_page(current_page);
	});

	// 판매자 여부 체크박스 이벤트
	$('#isSeller').on('click',function(){
		sellerCheck = $(this).is(':checked');
		
		if(sellerCheck){
			$('#account').val('');						
			$('#account-group').removeClass('fadeOutRight').addClass('fadeInRight');
			$('#account-group').css('visibility','visible');
		}else{
			$('#account-group').removeClass('fadeInRight').addClass('fadeOutRight');
			setTimeout(function(){
				$('#account-group').css('visibility','hidden');
			},1000);
		}
	});
	
	// 이미지 선택 처리
	$('input:file').change(function(){
		fileName = $(this).val().match(/[^\/\\]+$/);
		$('.custom-file-control').attr('title',fileName);
		loadPreview;
	});
	
	// 폼 서밋, ajax 
	$('#signUp').on('click',function(){		
		if(validate){		
			var actionUrl = $('form[id=new_member]').attr('action');
			var form = $('form[id=new_member]');
			var data = new FormData(form[0]);		
			
			var req = new XMLHttpRequest();
			
			$.ajax({
				type:'POST',
				enctype:'multipart/form-data',
				processData:false,
				contentType:false,
				data:data,
				url:actionUrl,
				success:function(data){
					if(data.duplicate){
						
					}
					if(data.login){
						location.replace(contextPath+"/main.run");
					}
				}
			});	
		} else{
			$('#validate-error').modal();
		}
	});
	
	// validate Check
	// 이름 조건 
	$('#name').on('keyup',function(){
		var content = $(this).val();
		var req = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
		
		if(req.test(content)){
			$(this).css('border','1px solid green');
		} else{
			$(this).css('border','1px solid red');			
		}
	});
	// 아이디 조건
	$('#userID').on('keyup',function(){
		var content = $(this).val();
		var req = /^[a-z0-9_]+$/;
		
		if(req.test(content)){
			$(this).css('border','1px solid green');
			validate = true;
		} else{
			$(this).css('border','1px solid red');	
			validate = false;
		}
	});
	// 비밀번호 조건
	$('#Password').on('keyup',function(){
		var content = $(this).val();
		var req = /^.*(?=.{8,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
		
		if(req.test(content)){
			$(this).css('border','1px solid green');
			validate = true;
		} else{
			$(this).css('border','1px solid red');	
			validate = false;
		}
	});
	// 비밀번호재확인 조건
	$('#pwdCheck').on('keyup',function(){
		var content = $(this).val();
		var req2 = $('#Password').val();
		var req = /^.*(?=.{8,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
		
		if(content==req2 && req.test(content)){
			$(this).css('border','1px solid green');
			validate = true;
		} else{
			$(this).css('border','1px solid red');	
			validate = false;
		}
		
	});
	// mail 조건
	$('#mail').on('keyup',function(){
		var content = $(this).val();
		var req = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		
		if(req.test(content)){
			$(this).css('border','1px solid green');
			validate = true;
		} else{
			$(this).css('border','1px solid red');			
			validate = false;
		}
	});
	// phone 조건 
	$('#phone').on('keyup',function(){
		var content = $(this).val();
		var req = /^01([0|1|6|7|8|9]?)([0-9]{3,4})([0-9]{4})$/;
		
		if(req.test(content)){
			$(this).css('border','1px solid green');
			validate = true;
		} else{
			$(this).css('border','1px solid red');		
			validate = false;
		}
	});
	// nickname 조건
	$('#nickname').on('keyup',function(){
		var content = $(this).val();
		var req = /^[가-힣a-zA-Z0-9]+$/;
		
		if(req.test(content)){
			$(this).css('border','1px solid green');
			validate = true;
		} else{
			$(this).css('border','1px solid red');		
			validate = false;
		}
	});
	// account 조건
	$('#account').on('keyup',function(){
		var content = $(this).val();
		var req = /^[0-9]{11,}$/;
		
		if(req.test(content)){
			$(this).css('border','1px solid green');
			validate = true;
		} else{
			$(this).css('border','1px solid red');			
			validate = false;
		}
	});
	
});

// 페이지 이동 함수
var move_page = function(current_page){
    if(current_page == 1){
        $('.previous').css('display','none');
    } else if(current_page == 4){
        $('.next').css('display','none');
        $('.sign').css('display','block');
    } else{
    	$('.previous').css('display','block');
    	$('.next').css('display','block');
        $('.sign').css('display','none');
    }

    $('.sign_page').attr('hidden','hidden');
    $('.sign_page[title='+current_page+']').removeAttr('hidden');

};

function loadPreview(e){
	var input = $(this);
	var inputFiles = input.files;
	
	var reader = new FileReader();
	reader.onload = function(event){
		$('#profile-image').attr('src',event.target.result);
	};
	
	reader.readAsDataURL(inputFiles);
	
}
