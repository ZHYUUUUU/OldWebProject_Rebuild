'use strict';

$(function () {
	function resize(){
		$('#main_ad .item').each(function(index, el) {
			var lgImage = $(this).data('image-lg');
			var xsImage = $(this).data('image-xs');
			// console.log(lgImage);
			var bgWidth = $(window).width();
			// console.log(bgWidth);
			if (bgWidth > 768) {
				$(this).empty();
				$(this).css({
				backgroundImage: 'url('+ lgImage +')'
				});
			}else{
				$(this).html('<img src="'+ xsImage +'" alt="课程">');
			}
		});	
	}
	$(window).on('resize',resize).trigger('resize');
})