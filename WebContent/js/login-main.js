$(document).ready(function(){
//	// item에 올렸을때
//	$('.uitem').on('mouseenter',function(){
//		var uitem = $(this);
//		var owner_info = $(this).parent().find('.owner_info');
//		uitem.css('box-shadow','3px 3px 6px #343434');
//		owner_info.removeClass('fadeOut').addClass('duration-300').addClass('fadeIn').css('display','block');
//	});
//	$('.owner_info').on('mouseover',function(){
//		$(this).parent().find('.uitem').css('box-shadow','3px 3px 6px #343434');
//		$(this).css('display','block');
//	});
//	$('.owner_info').on('mouseleave',function(){
//		var uitem = $(this).parent().find('.uitem');
//		var owner_info = $(this);
//		uitem.css('box-shadow','3px 3px 8px #606060');
//		owner_info.removeClass('fadeIn').addClass('fadeOut');
//		setTimeout(function(){
//			owner_info.css('display','none');
//		},1000);
//	});
	
	// 마찬가지로 16:9 비율을 맞추어 볼까요~
	var padding = $('.dashboard_container').width()/100*56.25;
	$('.dashboard_container').css("padding-top",padding+"px");
	
	// 대시보드로 가봅시다
	$('.toDashboard').on('click',function(){
		var id = $('#id').val();
		
		var data = {'id':id};
		
		$.ajax({
			type:'post',
			url:'/WebClass/dashboard.run',
			data:data,
			success:function(data){
				if(data.success){
					location.replace("/WebClass/jsp/dashboard.jsp");
				}
			}
		});
	});
});

$(window).resize(function(){
	// 마찬가지로 16:9 비율을 맞추어 볼까요~
	var padding = $('.dashboard_container').width()/100*56.25;
	$('.dashboard_container').css("padding-top",padding+"px");
});