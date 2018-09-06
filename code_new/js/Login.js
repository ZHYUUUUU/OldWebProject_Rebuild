'use strict';

$(function () {
	function resize(){
		// 获取屏幕宽度、高度
		var windowWidth = $(document.body).width();
		var windowheight = $(window).height()-$('#header').height();		
		// 根据宽度、高度为界面上的背景图片设置大小
		$('#login').css({
			// width: windowWidth,
			height: windowheight
		});
		var loginMarginTop = (windowheight-$('#login .container .row > div').height())/2;
		// console.log($('#login .container .row > div').height());
		$('#login .container .row > div').css({
			marginTop: loginMarginTop
		});
	}
	$(window).on('resize',resize).trigger('resize');
});

$(document).ready(function(){
	$('#login-s').click(function(event) {
		$('.login-student').show();
		$('.login-register-s').show();
		$('.login-expert').hide();
		$('.login-register-e').hide();
		$(this).css({
			borderBottom: '2px solid #e92322'
		});
		$('#login-e').css({
			borderBottom: 'none'
		});
	});
	$('#login-e').click(function(event) {
		$('.login-expert').show();
		$('.login-register-e').show();
		$('.login-student').hide();
		$('.login-register-s').hide();
		$(this).css({
			borderBottom: '2px solid #e92322'
		});
		$('#login-s').css({
			borderBottom: 'none'
		});
	});
});