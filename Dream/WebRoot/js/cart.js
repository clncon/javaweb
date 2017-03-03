$(document).ready(
     function() {
        $('.add-cart,#addCart,.btn-danger').on('click',function(){
			var parent_li = $(this).parents('li');
			var items = {
				0: {
					'pid':parent_li.attr('pid'),
					'ppid':parent_li.attr('ppid'),
					'type':parent_li.attr('type'),
					'qty':'1',
				}
			};
			var $ths = $(this);

			Cart.add(items,function(resp){
				if (resp.code == 200) {
                    $('.shop-cart').find('.row2').jsp('购物车中共<em>'+resp.data.cartcount+'</em>件商品 | 商品小计<em>￥'+resp.data.cart.total_amount+'</em>');
				} else {
					//MessageBox.errorFadeout(resp.msg);
				}
			});
        });

        $('.add-gifts').on('click',function(){

			var parent_li = $(this).parents('li');

			var items = {
				0: {
					'pid':parent_li.attr('pid'),
					'ppid':parent_li.attr('ppid'),
					'type':"user_gift",
					'qty':parent_li.attr('qty'),
				    'pno':parent_li.attr('pno'),
					'gift_send_id':parent_li.attr('gift_send_id'),
					'gift_active_type':parent_li.attr('gift_active_type'),
				}
			};
			var $ths = $(this);

			Cart.add(items,function(resp){
				window.location.href="/user/giftsget";

			});
            return false;
        });

         /*
         * cart btn
          */
		$('.cartspage').delegate('.deC','click',function(event){
				var $num, _val;
				var timeout;
				event.stopPropagation();

                var parent_li = $(this).parents('li');
				$num=$('.list-unstyled').find('.deC').filter(function(i){
                    return $(this).parents('li').attr('ppid')==parent_li.attr('ppid') ? true : false;
                }).prev('input');

				//alert($num.val());
				_val=parseInt($num.val());
				if(_val<=1){
					_val=1;
				}
				_val++;
				$num.val(_val);

				var data = {
					'pid':parent_li.attr('pid'),
					'ppid':parent_li.attr('ppid'),
					'type':parent_li.attr('type'),
					'qty':_val,
					'ik':parent_li.attr('id')
				};

				if (timeout) {
					clearTimeout(timeout);
				}
	
				timeout = setTimeout(function(){Cart.update(data);},20);
				
		});

         /*
          * cart-mini  btn
          */
         $('.p-common-minicart').delegate('.deC','click',function(event){
             var $num, _val;
             var timeout;
             event.stopPropagation();

             var parent_li = $(this).parents('li');
             $num=$('.list-unstyled').find('.deC').filter(function(i){
                 return $(this).parents('li').attr('ppid')==parent_li.attr('ppid') ? true : false;
             }).prev('input');

             //alert($num.val());
             _val=parseInt($num.val());
             if(_val<=1){
                 _val=1;
             }
             _val++;
             $num.val(_val);

             var data = {
                 'pid':parent_li.attr('pid'),
                 'ppid':parent_li.attr('ppid'),
                 'type':parent_li.attr('type'),
                 'qty':_val,
                 'ik':parent_li.attr('id')
             };
             Cart.update(data);
         });

         /*
          * cart  btn
          */
		$('.cartspage').delegate('.inC','click',function(event){
            var $num, _val;
			var timeout;
			event.stopPropagation();

			var parent_li = $(this).parents('li');
			$num=$('.list-unstyled').find('.inC').filter(function(i){
				return $(this).parents('li').attr('ppid')==parent_li.attr('ppid') ? true : false;
			}).next('input');

			_val=parseInt($num.val()); 

			if (_val==1) return;
			_val--;
			if(_val>1){
				$num.val(_val);
			}else{
				$num.val(1);
			}

			var data = {
				'pid':parent_li.attr('pid'),
				'ppid':parent_li.attr('ppid'),
				'type':parent_li.attr('type'),
				'qty':$num.val(),
				'ik':parent_li.attr('id')
			};

			if (timeout) {
				clearTimeout(timeout);
			}
			timeout = setTimeout(function(){Cart.update(data);},20);

	    });

         /*
          * cart-mini  btn
          */
         $('.p-common-minicart').delegate('.inC','click',function(event){
             var $num, _val;
             var timeout;
             event.stopPropagation();

             var parent_li = $(this).parents('li');
             $num=$('.list-unstyled').find('.inC').filter(function(i){
                 return $(this).parents('li').attr('ppid')==parent_li.attr('ppid') ? true : false;
             }).next('input');

             _val=parseInt($num.val());

             if (_val==1) return;
             _val--;
             if(_val>1){
                 $num.val(_val);
             }else{
                 $num.val(1);
             }

             var data = {
                 'pid':parent_li.attr('pid'),
                 'ppid':parent_li.attr('ppid'),
                 'type':parent_li.attr('type'),
                 'qty':$num.val(),
                 'ik':parent_li.attr('id')
             };

             Cart.update(data);
         });

		$('.cartspage').delegate('.m-cartlist-delete','click',function(event){
            event.stopPropagation();
            var $this=$(this);
			$.ajax({
                type: 'GET',
                url: "/cart/confirm",
                dataType: 'html'
            }).done(function(data){
                $('#p-dialog').empty().append(data).fadeIn(100).removeClass().addClass('dialog-open');
                $('.dialog-til>span').on('click', diaClose);
				$('.btn-default').on('click', diaClose);
                $('.btn-success').on('click', function(){
					var parent_li = $this.parents('li');
					var pdata = {
						'pid':parent_li.attr('pid'),
						'ppid':parent_li.attr('ppid'),
						'type':parent_li.attr('type'),
						'ik':parent_li.attr('id')
					};
                    diaClose();             
					Cart.remove(pdata);

                });
            })
        });

		$('.p-common-minicart').delegate('.mini-cartlist-delete','click',function(event){
            event.stopPropagation();
			var parent_li = $(this).parents('li');
			var pdata = {
				'pid':parent_li.attr('pid'),
				'ppid':parent_li.attr('ppid'),
				'type':parent_li.attr('type'),
				'ik':parent_li.attr('id')
			};
	        Cart.remove(pdata);
        });


		$('.fruit-kinds .good-list ul li .wrap a span').click(
		  function(){

			  //$('.zhezhao').fadeIn(800);
			  //$('.shop-cart').fadeIn(800);
			  return false;
		  }
		);


		$('.shop-cart .shop-content .choosed ul li .buy .fr-buy').click(
			function(){
			  $('.shop-cart').fadeOut(800);
			  $('.zhezhao').fadeOut(800);
			  $('.fruit-kinds .good-list ul li .s-info .s-che.cur').animate({"background-position-x":"-517px","background-position-y":"-243px"},500); 
			}
		);
     }
 );




var Cart = {
    sessid:'',
    url:'http://localhost',
    add:function(){
        var items = arguments[0];
        var callback = arguments[1];

        var data = {
            'items':items
        };
        $.ajax('/ajax/cart/add',{
            'type': 'POST',
            'data':data,
            'dataType':'json',
            'beforeSend':function(XHR){ 
            },
            'success':function(resp, textStatus, jqXHR){
                if(resp.msg=="请先登录"){
                    window.location.href="/login";
                }

                if (resp.code == 200){
                    localStorage['cartcount'] = resp.cart_items_count;
                }
                
                if ($.isFunction(callback)) {
                    callback(resp);
                    return ;
                }

                if (resp.code == 200) {
                   // MessageBox.show('恭喜您，商品已成功加入购物车');
                } else {

                   // MessageBox.errorFadeout(resp.msg);
                } 
            }
        });
    },
    update:function(){
        var item = arguments[0];

        item.ik = item.ik.substr(2);
        var data = {
            'item':item
        };

        var _this = this;
        $.ajax('/ajax/cart/update#!',{
            'type': 'POST',
            'data':data,
            'dataType':'json',
            'success':function(resp, textStatus, jqXHR){
               //MessageBox.unloading();
                if (resp.code == 200) {
                    localStorage['cartcount'] = resp.cart_items_count;
                    
                    $('.cartspage').load(location.href+'/rescart' + " .cartspage>*");
                    var url = "http://"+window.location.host;
                    $('.p-common-minicart').load(url+'/cart/resminicart' + " .p-common-minicart>*", function(){
                        $(this).find('.cart-order').css('display','block');
                    });

                    _this.body(resp.cart);

                } else {
                    //MessageBox.errorFadeout(resp.msg);
                }
            }
        });
    },
    remove:function(){
        var item = arguments[0];

        item.ik = item.ik.substr(2);
        var data = {
            'item':item
        };

        var _this = this;

        $.ajax('/ajax/cart/remove#!',{
            'type': 'POST',
            'data':data,
            'dataType':'json',
            'success':function(resp, textStatus, jqXHR){
                if (resp.code == 200) {
                    localStorage['cartcount'] = resp.cart_items_count;

                    //$('.cart-body').jsp(resp.cartbody);

                    if ($.isEmptyObject(resp.cart)) {
                        //$('.cart-order').jsp('<div class="cart-empty">购物车中还没有商品，<a href="fruit.jsp" class="VI-color2">继续逛逛</a>吧！</div>');
						$('.cartfooter').remove();
                    }else{
                        //_this.body(resp.cart);
                    }
                    $('.cartspage').load(location.href+'/rescart' + " .cartspage>*");
                    var url = "http://"+window.location.host;
                    $('.p-common-minicart').load(url+'/cart/resminicart' + " .p-common-minicart>*", function(){
                        $(this).find('.cart-order').css('display','block');
                    });
                } else {
                    MessageBox.errorFadeout(resp.msg,function(){});
                }
            }
        });

    },
    empty:function(){
        localStorage.removeItem('cartcount');
    },
    index:function(){
        var cart = localStorage['cartitems'];
        var form = $('<form action="/cart" method="post"><input type="hidden" name="carttmp" value="'+cart+'"></input></form>');
        form.submit();
    },
    body:function(cart){
		var total_qty = 0;
        this.itemT(cart);
        this.pmtT(cart);
    },
    pmtT:function(cart){
        var T = '<li class="donationTips" data-toggle="tooltip" data-placement="top" title="${title}" ><a href="${href}" ><i class="glyphicon fdayicon fdayicon-notice">${tag}</i>${title}</a></li>';

        /*优惠提醒*/
        if ($('.cart-body .m-carttips').length) {$('.cart-body .m-carttips').remove();};
        if (!$.isEmptyObject(cart.pmt_alert)) {
            var tipEl = $('<div class="m-carttips"><ul class="list-unstyled"></ul></div>');
            $.each(cart.pmt_alert,function(i,p){
                var map = {
                    'title':p.solution.title,
                    'href':'/cart/selpmt/'+p.pmt_type+'/'+p.solution.pmt_id,
                    'tag':p.solution.tag,
                };

                if (p.pmt_type == 'usergift') {
                    map.href = "/cart/getusergifts";
                };

                var pt = $(substitute(T,map));
                if (p.pmt_type != 'usergift') {
                    pt.find('i').removeAttr('class');
                };

                if (!p.solution.url) {
                    pt.find('i').unwrap();
                } else {
                    pt.removeAttr('class').removeAttr('data-toggle').removeAttr('data-placement').removeAttr('title');
                }

                tipEl.find('ul').append(pt);
            });
            $('.cart-body #m-cart').append(tipEl);
        };
    },
    itemT:function(cart){

        if ($('.list-unstyled').length) {
            var cEl = $('.list-unstyled');
            var total_qty = 0;
			var cartnum = 0;
            var domidlist=[];
            $.each(	cart.items , function(k,i){
                var map = {
                    'domid':'c_'+k,
                    'item_type':i.item_type,
                    'product_id':i.product_id,
                    'sku_id':i.sku_id,
                    'href': (i.item_type=='normal' || i.item_type=='exch') ? "/detail/index/"+i.product_id : 'javascript:void(0);',
                    'product_photo':i.photo.thum,
                    'name':i.name,
                    'spec':i.spec ? '规格：'+i.spec : '',
                    'sale_price':'￥'+i.sale_price,
                    'price':(parseFloat(i.price) > parseFloat(i.sale_price)) ? '<del>￥'+i.price+'</del>' : '',
                    'endtime':(i.item_type=='user_gift' || i.item_type=='coupon_gift') ? '<span class="pull-right">截至 '+i.endtime+'</span>' :'',
                    'qty':i.qty,
                    'pmt_details':'',
                    'src':i.photo.thum,
					'total_amount': i.amount
                };
                cartnum++;

                total_qty = parseInt(i.qty) + parseInt(total_qty);
                domidlist.push(map.domid);

                var iEl = cEl.find('li#'+map.domid);
				
                iEl.find('.sum').jsp('<p>￥'+map.total_amount+'</p>');
            });

			$('.cartnum').jsp(cartnum);
            $('.cart-pay').jsp('<span>已选择 <em>'+total_qty+'件</em> 商品  |  订单金额</span><span class="all-order">￥'+cart.total_amount+'</span><a id="btngopay" class="go-pay">去结算</a>');

            $('.mcart-pay').jsp('<div class="pull-left">共<span class="VI-color2"> '+total_qty+'</span> 件商品</div><div class="pull-right">商品小计 <span class="fs-3 VI-color2">'+cart.total_amount+'</span></div><button id="btncart" type="button" class="btn btn-success btn-lg btn-block">立即结算</button>');

			if( $('#cart_page').val() == '2' ){
				var notli = cEl.find('li').filter(function(i){
					return $.inArray($(this).attr('id'),domidlist)==-1 ? true : false;
				}).remove();

				if (notli.length) {
					notli.slideUp(150,function(){
						$(this).remove();
					});
				}
			}
        }
    }
};
function substitute( template,map,transform,thisObject){
	 thisObject = thisObject || $.noop;
	 transform = transform || thisObject["transform"] || function(v){ return v; };

	 return template.replace(/\$\{([^\s\:\}]+)(?:\:([^\s\:\}]+))?\}/g, function(match, key, format){
			var value = map[key] || ("undefined" === typeof map[key] ? match : map[key]);
			format && (value = thisObject[format](value, key));
			return transform(value, key).toString();});
}