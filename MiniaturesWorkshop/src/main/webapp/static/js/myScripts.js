/**
 * Yaroslav`s personal scripts
 */

$(function() {
	$('input:button').click(function() {
		$('#count').val($(this).data('quantity') * $('#product_price').text());
	});
});

$(function() {
	$('input:chosenMiniature').click(function() {
		$('#miniaturePrice').val($(this).data('quantity') * $('#product_price').text());
	});
});