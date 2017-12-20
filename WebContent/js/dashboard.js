var textMode;

$(document).ready(function(){
	// 만약 먼가 불러올때라면 storyboard의 넓이를 조정할 필요가 있지
	var init_dashboard_width = $('.layers').length*$('#dashboard').width()/10;	
	$('#dashboard').css('width',init_dashboard_width);
	
	
	// 도형 레이아웃을 위한 무언가입니다.
	var mkcnt = 0;
	// 작업장이닷
	var workField = $('#work-field');
	
	// 작업장을 16:9 크기로 유지하기위함
	var workWidth = workField.width();
	var workHeight = workWidth/100*56.25;
	
	var top = "calc(50% - "+workHeight/2+"px)";
	// 16:9 비율을 유지하기 위함
	workField.css('padding-top',workHeight+"px");
	workField.css('top',top);

	$('#storyboard').sortable({
		start:function(event,ui){
			// 나랑 같은 아이를 찾자!!
			var title = ui.item.attr('title');
			
			$('.move').removeClass('chosen-box');
			$('div[title='+title+']').addClass('chosen-box');
			
			$('#storyboard').find('li').removeClass('chosen-box-storyboard');
			ui.item.addClass('chosen-box-storyboard');
		},
		update: function(event,ui){
			$(this).disableSelection();
			var result = $(this).sortable('toArray');
		},
		stop: function(event,ui){
			var children = $('#storyboard').sortable('refreshPositions').children().get().reverse();
		    console.log('Positions: ');
		    $.each(children, function(index) {
		    		var title = $(this).text().trim();
		    		console.log(title+index);
		        
		        $('div[title='+title+']').css('z-index',index);
		        
		    });
		}
	});
	
	
	// 도형 만들기!
	$('#mkfigure').on('click',function(event){	
		mkcnt++;
		// tool box 의 변화
		$('li[class=tool]').css('background','535353');
		$('li').removeClass('active').addClass('tool');
		
		// 작업장의 변화
		var workF = $('#work-field');
		var basic_width = (40/workF.width())*100;
		var basic_height = (40/workHeight)*100;
		var figure = "<div ondrag='select(event,this)' onresize='select(event,this)' title='layer"+mkcnt+"' class='boxes vivify popIn tmp layer"+mkcnt+"'></div>";
		
		workF.append(figure);
		
			// 나랑 같은 녀석을 찾아라!
		var title = 'layer'+mkcnt;
		
		$('.move').removeClass('chosen-box');
		$('div[title=layer'+mkcnt+']').addClass('chosen-box');
		
		var xc = workF.offset().left;
		var yc = workF.offset().top;
		
		var left = event.pageX-xc-20;
		var top = event.pageY-yc-20;		
		
		$('.tmp').css('position','absolute');
		$('.tmp').css('border','1px solid #3e3e3e');
		$('.tmp').css('width',basic_width+"%");
		$('.tmp').css('height',basic_height+"%");
		$('.tmp').css('left',left+"px");
		$('.tmp').css('top',top+'px');
		 
		$('.tmp').attr('onclick','stop(event, this)');
		
		// 대쉬보드의 변화
		var storyboard = $('#storyboard');
		var storyboard_width = $('#storyboard').width();
		
		var story_figure = "<li onclick='select_layout(event,this)' title='layer"+mkcnt+"' class='layers vivify pulsate layer"+mkcnt+"'>layer"+mkcnt+"</li>";
		var layer = $('.layers');
		layer.css('width',$('#dashboard').width()/10);
		storyboard.css('width',storyboard_width+layer.width());
		storyboard.prepend(story_figure);
		
		$('#storyboard').find('li').removeClass('chosen-box-storyboard');
		$('li[title='+title+']').addClass('chosen-box-storyboard');
		
		
		// 순서!!!!!!!!!!!!!!!!!!!
		var children = $('#storyboard').children().get().reverse();
	    console.log('Positions: ');
	    $.each(children, function(index) {
	    		var title = $(this).text().trim();
	    		console.log(title+index);
	        
	        $('div[title='+title+']').css('z-index',index);
	        
	    });
	});
	
	// tool중에 선택된 툴은 어에 되어야 한다?
	$('li[class=active]').on('mouseleave',function(){
		$(this).css('background','#3e3e3e');
	});
	
	// tool에 마우스가 올려졌을때 어에 되야할까~
	$('li[class=tool]').on('mouseenter',function(){
		$(this).css('background','#3e3e3e');
	});
	$('li[class=tool]').on('mouseleave',function(){
		$(this).css('background','#535353');
	});
	
	// tool을 선택하면 어떻게 돼야 할까아아아~~~!
	$('li[class=tool]').on('click',function(){
		$('li[class=tool]').css('background','535353');
		$('li').removeClass('active').addClass('tool');
		$(this).css('background','#3e3e3e');
		$(this).addClass('active').removeClass('tool');		
		
		if($(this).attr('id') != "mktext"){
			textMode = false;
		}
		
	});
	
	// mktext! 누르면 머다?
	$('#mktext').on('click',function(){
		textMode = true;		
	});
	
	// textMode가 true 일때 작업장을 클릭하면 텍스트 박스를 만드러야 겟지?
	$('#work-field').on('click',function(event){
		if(textMode){
			textMode=false;
			$('#mktext').css('background','535353');
			$('#mktext').removeClass('active').addClass('tool');
			var workF = $(this);
			var figure = "<p class='text_tmp' contenteditable='true'></p>";
			
			var text_location_x = event.pageX - workF.offset().left - 10;
			var text_location_y = event.pageY - workF.offset().top - 13;
			
			workF.append(figure);
			
			var text_tmp = $('.text_tmp');
			text_tmp.css('position','absolute');
			text_tmp.css('border','1px solid #000');
			text_tmp.css('outline','none');
			text_tmp.css('text-align','center');
			text_tmp.css('min-width','35px');
			text_tmp.css('left',text_location_x);
			text_tmp.css('top',text_location_y);
			text_tmp.attr('onkeydown','enter_text(event,this)');
			text_tmp.focus();
			
			text_tmp.removeClass('text_tmp');
		}
	});
	
	
	
	
	
	// 최종 세이브닷!!!!!!!!
	$('#submit').on('click',function(){
		$('.boxes').removeAttr('onclick').removeAttr('ondrag').removeAttr('onresize');
		
		$('.boxes').removeClass('vivify').removeClass('popIn').removeClass('move').removeClass('layer1').removeClass('ui-draggable')
		.removeClass('ui-draggable-handle').removeClass('ui-resizable').removeClass('boxes');
		
		
		var content = $('#work-field').html();
		var id = $('#id').val();
		
		var actionUrl = $(this).attr('action');
		var data = {'id':id,'content':content};
		
		$.ajax({
			type:'post',
			url: actionUrl,
			data:data,
			success:function(data){
				if(data.success){
					$('.close').trigger('click');
				}
				if(data.fail){
					alert("failed!"+data.fail);
				}
			}
		});
		
	});
	
	// 창닫기!!
	$('.close').on('click',function(){
		var id = $('#id').val();
		$.ajax({
			type:'post',
			url:'/WebClass/redirect.run',
			data:{'id':id},
			success:function(data){
				if(data.success){
					location.replace('/WebClass/jsp/login-main.jsp');
				} else{
					alert("실패함ㅜ");
				}
			}
		});
	});
	
});


// 창의 크기가 변해도 16:9 화면 비율을 유지하자
$(window).resize(function(){
	var workField = $('#work-field');
	
	var workWidth = workField.width();
	var workHeight = workWidth/100*56.25;
	
	var top = "calc(50% - "+workHeight/2+"px)";
	// 16:9 비율을 유지하기 위함

	workField.css('padding-top',workHeight+"px");
	workField.css('top',top);

});
// 마우스 움직일때
$(document).mousemove(function(event){		
		event.preventDefault();
	
		var workF = $('#work-field');
		
		// x 시작 좌표를 위한 값
		var xs = workF.offset().left;
		// y 시작 좌표를 위한 값
		var ys = workF.offset().top+3;
		// x 시작 좌표
		var xo = event.pageX - xs;
		// y 시작 좌표
		var yo = event.pageY - ys;

		var square = $('.tmp');
		
		var xc = xo-square.width()/2;
		var yc = yo-square.height()/2;
			
		square.css('top',yc+"px");
		square.css('left',xc+"px");
});

// 그만 움직여!
function stop(event, me){
	var workF = $('#work-field');
	var workHeight = workF.width()/100*56.25;
	// 위치값이죠~
	var xc = event.pageX - workF.offset().left - $(me).width()/2;
	var yc = event.pageY - workF.offset().top - $(me).height()/2;
	
	// 놓아버렸는데 작업장 밖이면 안댕!
	if(xc <= 0){
		xc = 0;
	}
	if(yc <=0){
		yc = 0;
	}
	// 나랑 같은 녀석을 스토리보드에서 찾아줘!
	var title = $(me).attr('title');
	var same_thing = $('li[title='+title+']');
	
	// 가변!
	var vx = (xc/workF.width())*100;
	var vy = (yc/workHeight)*100;
	
	// 좋아 마우스 근처에 놓자
	$(me).css('top',vy+"%");
	$(me).css('left',vx+"%");
	$(me).removeClass('tmp').addClass('move');
	
	console.log(vx);
	console.log(vy);
	
	$('.move').draggable({
		// 드래그 하다 멈추면?
		stop: function(event,ui){
			var x = $(this).offset().left - workF.offset().left;
			var y = $(this).offset().top - workF.offset().top;
			// 가변!
			var cx = (x/workF.width())*100;
			var cy = (y/workHeight)*100;

			$(this).css('top',cy+"%");
			$(this).css('left',cx+"%");
		}
	});
	$('.move').resizable({
		stop:function(event,ui){
			var workF = $('#work-field');
			var workHeight = workF.width()/100*56.25;
			
			var width = ($(this).width()/workF.width())*100;
			var height = ($(this).height()/workHeight)*100;
			
			console.log(width);
			console.log(height);
			
			$(this).css('width',width+"%");
			$(this).css('height',height+'%');
		}
	});
	$('li[class=tool]').css('background','535353');
	$('li').removeClass('active').addClass('tool');
	$('#move').css('background','#3e3e3e');
	$('#move').addClass('active').removeClass('tool');
	$(me).removeAttr('onclick');
	$(me).attr('onclick','select(event,this)');
	
	var children = $('#storyboard').children().get().reverse();
    console.log('Positions: ');
    $.each(children, function(index) {
    		var title = $(this).text().trim();
    		console.log(title+index);
        
        $('div[title='+title+']').css('z-index',index);
        
    });
	
}

// text 수정!!!
function modify_text(me){
	var text = $(me);
	
	text.attr('contenteditable','true');
	
}

// text 수정 끝!!
function enter_text(event,me){
	var isEnter = event.which;
	var me = $(me);
	
	if(isEnter == 13 || isEnter == 10){
		event.preventDefault();
		
		me.removeAttr('contenteditable');
		me.attr('ondblclick','modify_text(this)');
		me.draggable();
		me.resizable();
		me.resize(function(){
			me.css('line-height',me.height()+"px");
		});
	}
}

// 드래그 이벤트!!!!!!
function select(event,me){
	var me = $(me);
	
	// 스토리보드에서 나랑 같은 아이를 찾아보장
	var title = me.attr('title');

	var workF = $('#work-field');
	
	// 나의 위치!
	var top = me.offset().top - workF.offset().top;
	var left = me.offset().left - workF.offset().left;
	
	if(top <= 0){
		me.offset().top=0;
	}
	if(left <= 0){
		me.css('left','0px');
	}
	$('.move').removeClass('chosen-box');
	me.addClass('chosen-box');
	
	$('#storyboard').find('li').removeClass('chosen-box-storyboard');
	$('li[title='+title+']').addClass('chosen-box-storyboard');
}

// layout에서 클릭 했을때???
function select_layout(event,me){
	var me = $(me);
	// 이번에도 역시~~ 같은것을 차자봅시다~!!
	var title = me.attr('title');
	
	$('.move').removeClass('chosen-box');
	$('div[title='+title+']').addClass('chosen-box');
	
	$('#storyboard').find('li').removeClass('chosen-box-storyboard');
	me.addClass('chosen-box-storyboard');
}

// z-index를 설정해보자!!!!!!!!
var setZ_index = function(event,ui){
	var storyboard_array = $('#storyboard').sortable("toArray");
	
	for(var i=0; i<storyboard_array.length;i++){
		alert(storyboard_array[i]);
//		storyboard_array[i].css('z-index',2147483647-i);
	}
}
