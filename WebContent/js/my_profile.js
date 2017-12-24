$(document).ready(function(){		
	var DBid = $('#id').val();

	$('.view').css('display','none');
	$('.view[title='+whichTab+']').css('display','block');
	
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
	
	// 탭 변경
	$('.tab').on('click',function(){
		$('.tab').removeClass('tab_active');
		$(this).addClass('tab_active');
		
		whichTab = $(this).attr('title');
		
		$('.view').css('display','none');
		$('.view[title='+whichTab+']').css('display','block');
	});
	
	// 여기도 16:9 ㄲㄱ
	var storage_width = $('.dashboard_storage').width();
	var storage_height = storage_width/100*56.25;
	
	$('.dashboard_storage').height(storage_height);
	$('.storages').height(storage_height);
	
	// 3D 무빙 2
	$('.dashboard_storage').on('mousemove',function(e){
		
		var posX = (e.pageX - $(this).offset().left - 1) - $(this).width()/2;
		var posY = (e.pageY - $(this).offset().top - 1) - $(this).height()/2;
		
		var rotateX = -posX*0.04;
		var rotateY = -posY*0.04;
		
		console.log(posX+"\n"+posY);
		
		$(this).css('transform','perspective(1000px) scale(1.07) rotateX('+rotateY+'deg) rotateY('+rotateX+'deg)');
	});
	$('.dashboard_storage').on('mouseleave',function(){
		$(this).css('transform','none');
	});
});

$(window).resize(function(){
	// 여기도 16:9 ㄲㄱ
	var storage_width = $('.dashboard_storage').width();
	var storage_height = storage_width/100*56.25;
	
	$('.dashboard_storage').height(storage_height);
	$('.storages').height(storage_height);
})