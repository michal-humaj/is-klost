;/**
 Required. Ace's Basic File to Initiliaze Different Parts and Some Variables.
*/


//some basic variables
(function(undefined) {
	if( !('ace' in window) ) window['ace'] = {}
	if( !('helper' in window['ace']) ) window['ace'].helper = {}
	if( !('vars' in window['ace']) ) window['ace'].vars = {}
	window['ace'].vars['icon'] = ' ace-icon ';
	window['ace'].vars['.icon'] = '.ace-icon';

	ace.vars['touch']	= ('ontouchstart' in window);//(('ontouchstart' in document.documentElement) || (window.DocumentTouch && document instanceof DocumentTouch));
	
	//sometimes the only good way to work around browser's pecularities is to detect them using user-agents
	//though it's not accurate
	var agent = navigator.userAgent
	ace.vars['webkit'] = !!agent.match(/AppleWebKit/i)
	ace.vars['safari'] = !!agent.match(/Safari/i) && !agent.match(/Chrome/i);
	ace.vars['android'] = ace.vars['safari'] && !!agent.match(/Android/i)
	ace.vars['ios_safari'] = !!agent.match(/OS ([4-9])(_\d)+ like Mac OS X/i) && !agent.match(/CriOS/i)
	
	ace.vars['ie'] = window.navigator.msPointerEnabled || (document.all && document.querySelector);//8-11
	ace.vars['old_ie'] = document.all && !document.addEventListener;//8 and below
	ace.vars['very_old_ie']	= document.all && !document.querySelector;//7 and below
	ace.vars['firefox'] = 'MozAppearance' in document.documentElement.style;
	
	ace.vars['non_auto_fixed'] = ace.vars['android'] || ace.vars['ios_safari'];
})();



(function($ , undefined) {
	//sometimes we try to use 'tap' event instead of 'click' if jquery mobile plugin is available
	ace['click_event'] = ace.vars['touch'] && $.fn.tap ? 'tap' : 'click';
})(jQuery);




//document ready function
jQuery(function($) {

	//----------------------------------CHANGED BY MICHAL
	initKlostIS();
	//----------------------------------END OF CHANGED BY MICHAL

	basics();
	enableSidebar();
	
	enableDemoAjax();
	handleScrollbars();
	
	dropdownAutoPos();
	
	navbarHelpers();
	sidebarTooltips();
	
	scrollTopBtn();
	
	someBrowserFix();
	
	bsCollapseToggle();
	smallDeviceDropdowns();
	
	////////////////////////////

	function basics() {
		// for android and ios we don't use "top:auto" when breadcrumbs is fixed
		if(ace.vars['non_auto_fixed']) {
			$('body').addClass('mob-safari');
		}

		ace.vars['transition'] = !!$.support.transition.end
	}
	
	function enableSidebar() {
		//initiate sidebar function
		var $sidebar = $('.sidebar');
		if($.fn.ace_sidebar) $sidebar.ace_sidebar();
		if($.fn.ace_sidebar_scroll) $sidebar.ace_sidebar_scroll({
			//for other options please see documentation
			'include_toggle': false || ace.vars['safari'] || ace.vars['ios_safari'] //true = include toggle button in the scrollbars
		});
		if($.fn.ace_sidebar_hover)	$sidebar.ace_sidebar_hover({
			'sub_hover_delay': 750,
			'sub_scroll_style': 'no-track scroll-thin scroll-margin scroll-visible'
		});
	}

	
	//Load content via ajax
	function enableDemoAjax() {		
		if(!$.fn.ace_ajax) return;
 
		if(window.Pace) {
			window.paceOptions = {
				ajax: true,
				document: true,
				eventLag: false // disabled
				//elements: {selectors: ['.page-content-area']}
			}
		}

		var demo_ajax_options = {
			 'close_active': true,
			 
			 'default_url': 'page/index',//default hash
			 'content_url': function(hash) {
				//***NOTE***
				//this is for Ace demo only, you should change it to return a valid URL
				//please refer to documentation for more info

				if( !hash.match(/^page\//) ) return false;
				var path = document.location.pathname;

				//for example in Ace HTML demo version we convert /ajax/index.html#page/gallery to > /ajax/content/gallery.html and load it
				if(path.match(/(\/ajax\/)(index\.html)?/))
					return path.replace(/(\/ajax\/)(index\.html)?/, '/ajax/content/'+hash.replace(/^page\//, '')+'.html') ;

				//for example in Ace PHP demo version we convert "ajax.php#page/dashboard" to "ajax.php?page=dashboard" and load it
				return path + "?" + hash.replace(/\//, "=");
			  }			  
		}
		   
		//for IE9 and below we exclude PACE loader (using conditional IE comments)
		//for other browsers we use the following extra ajax loader options
		if(window.Pace) {
			demo_ajax_options['loading_overlay'] = 'body';//the opaque overlay is applied to 'body'
		}

		//initiate ajax loading on this element( which is .page-content-area[data-ajax-content=true] in Ace's demo)
		$('[data-ajax-content=true]').ace_ajax(demo_ajax_options)

		//if general error happens and ajax is working, let's stop loading icon & PACE
		$(window).on('error.ace_ajax', function() {
			$('[data-ajax-content=true]').each(function() {
				var $this = $(this);
				if( $this.ace_ajax('working') ) {
					if(window.Pace && Pace.running) Pace.stop();
					$this.ace_ajax('stopLoading', true);
				}
			})
		})
	}

	/////////////////////////////

	function handleScrollbars() {
		//add scrollbars for navbar dropdowns
		var has_scroll = !!$.fn.ace_scroll;
		if(has_scroll) $('.dropdown-content').ace_scroll({reset: false, mouseWheelLock: true})

		//reset scrolls bars on window resize
		if(has_scroll && !ace.vars['old_ie']) {//IE has an issue with widget fullscreen on ajax?!!!
			$(window).on('resize.reset_scroll', function() {
				$('.ace-scroll:not(.scroll-disabled)').not(':hidden').ace_scroll('reset');
			});
			if(has_scroll) $(document).on('settings.ace.reset_scroll', function(e, name) {
				if(name == 'sidebar_collapsed') $('.ace-scroll:not(.scroll-disabled)').not(':hidden').ace_scroll('reset');
			});
		}
	}


	function dropdownAutoPos() {
		//change a dropdown to "dropup" depending on its position
		$(document).on('click.dropdown.pos', '.dropdown-toggle[data-position="auto"]', function() {
			var offset = $(this).offset();
			var parent = $(this.parentNode);

			if ( parseInt(offset.top + $(this).height()) + 50 
					>
				(ace.helper.scrollTop() + ace.helper.winHeight() - parent.find('.dropdown-menu').eq(0).height()) 
				) parent.addClass('dropup');
			else parent.removeClass('dropup');
		});
	}

	
	function navbarHelpers() {
		//prevent dropdowns from hiding when a from is clicked
		/**$(document).on('click', '.dropdown-navbar form', function(e){
			e.stopPropagation();
		});*/


		//disable navbar icon animation upon click
		$('.ace-nav [class*="icon-animated-"]').closest('a').one('click', function(){
			var icon = $(this).find('[class*="icon-animated-"]').eq(0);
			var $match = icon.attr('class').match(/icon\-animated\-([\d\w]+)/);
			icon.removeClass($match[0]);
		});


		//prevent dropdowns from hiding when a tab is selected
		$(document).on('click', '.dropdown-navbar .nav-tabs', function(e){
			e.stopPropagation();
			var $this , href
			var that = e.target
			if( ($this = $(e.target).closest('[data-toggle=tab]')) && $this.length > 0) {
				$this.tab('show');
				e.preventDefault();
				$(window).triggerHandler('resize.navbar.dropdown')
			}
		});
	}

	
	function sidebarTooltips() {
		//tooltip in sidebar items
		$('.sidebar .nav-list .badge[title],.sidebar .nav-list .badge[title]').each(function() {
			var tooltip_class = $(this).attr('class').match(/tooltip\-(?:\w+)/);
			tooltip_class = tooltip_class ? tooltip_class[0] : 'tooltip-error';
			$(this).tooltip({
				'placement': function (context, source) {
					var offset = $(source).offset();

					if( parseInt(offset.left) < parseInt(document.body.scrollWidth / 2) ) return 'right';
					return 'left';
				},
				container: 'body',
				template: '<div class="tooltip '+tooltip_class+'"><div class="tooltip-arrow"></div><div class="tooltip-inner"></div></div>'
			});
		});
		
		//or something like this if items are dynamically inserted
		/**
		$('.sidebar').tooltip({
			'placement': function (context, source) {
				var offset = $(source).offset();

				if( parseInt(offset.left) < parseInt(document.body.scrollWidth / 2) ) return 'right';
				return 'left';
			},
			selector: '.nav-list .badge[title],.nav-list .label[title]',
			container: 'body',
			template: '<div class="tooltip tooltip-error"><div class="tooltip-arrow"></div><div class="tooltip-inner"></div></div>'
		});
		*/
	}
	
	

	function scrollTopBtn() {
		//the scroll to top button
		var scroll_btn = $('.btn-scroll-up');
		if(scroll_btn.length > 0) {
			var is_visible = false;
			$(window).on('scroll.scroll_btn', function() {
				var scroll = ace.helper.scrollTop();
				var h = ace.helper.winHeight();
				var body_sH = document.body.scrollHeight;
				if(scroll > parseInt(h / 4) || (scroll > 0 && body_sH >= h && h + scroll >= body_sH - 1)) {//|| for smaller pages, when reached end of page
					if(!is_visible) {
						scroll_btn.addClass('display');
						is_visible = true;
					}
				} else {
					if(is_visible) {
						scroll_btn.removeClass('display');
						is_visible = false;
					}
				}
			}).triggerHandler('scroll.scroll_btn');

			scroll_btn.on(ace.click_event, function(){
				var duration = Math.min(500, Math.max(100, parseInt(ace.helper.scrollTop() / 3)));
				$('html,body').animate({scrollTop: 0}, duration);
				return false;
			});
		}
	}


	
	function someBrowserFix() {
		//chrome and webkit have a problem here when resizing from 479px to more
		//we should force them redraw the navbar!
		if( ace.vars['webkit'] ) {
			var ace_nav = $('.ace-nav').get(0);
			if( ace_nav ) $(window).on('resize.webkit_fix' , function(){
				ace.helper.redraw(ace_nav);
			});
		}
		
		
		//fix an issue with ios safari, when an element is fixed and an input receives focus
		if(ace.vars['ios_safari']) {
		  $(document).on('ace.settings.ios_fix', function(e, event_name, event_val) {
			if(event_name != 'navbar_fixed') return;

			$(document).off('focus.ios_fix blur.ios_fix', 'input,textarea,.wysiwyg-editor');
			if(event_val == true) {
			  $(document).on('focus.ios_fix', 'input,textarea,.wysiwyg-editor', function() {
				$(window).on('scroll.ios_fix', function() {
					var navbar = $('#navbar').get(0);
					if(navbar) ace.helper.redraw(navbar);
				});
			  }).on('blur.ios_fix', 'input,textarea,.wysiwyg-editor', function() {
				$(window).off('scroll.ios_fix');
			  })
			}
		  }).triggerHandler('ace.settings.ios_fix', ['navbar_fixed', $('#navbar').css('position') == 'fixed']);
		}
	}

	
	
	function bsCollapseToggle() {
		//bootstrap collapse component icon toggle
		$(document).on('hide.bs.collapse show.bs.collapse', function (ev) {
			var panel_id = ev.target.getAttribute('id')
			var panel = $('a[href*="#'+ panel_id+'"]');
			if(panel.length == 0) panel = $('a[data-target*="#'+ panel_id+'"]');
			if(panel.length == 0) return;

			panel.find(ace.vars['.icon']).each(function(){
				var $icon = $(this)

				var $match
				var $icon_down = null
				var $icon_up = null
				if( ($icon_down = $icon.attr('data-icon-show')) ) {
					$icon_up = $icon.attr('data-icon-hide')
				}
				else if( $match = $icon.attr('class').match(/fa\-(.*)\-(up|down)/) ) {
					$icon_down = 'fa-'+$match[1]+'-down'
					$icon_up = 'fa-'+$match[1]+'-up'
				}

				if($icon_down) {
					if(ev.type == 'show') $icon.removeClass($icon_down).addClass($icon_up)
						else $icon.removeClass($icon_up).addClass($icon_down)
						
					return false;//ignore other icons that match, one is enough
				}

			});
		})
	}
	

	
	//in small devices display navbar dropdowns like modal boxes
	function smallDeviceDropdowns() {
	  if(ace.vars['old_ie']) return;
	  
	  $('.ace-nav > li')
	  .on('shown.bs.dropdown.navbar', function(e) {
		adjustNavbarDropdown.call(this);
	  })
	  .on('hidden.bs.dropdown.navbar', function(e) {
		$(window).off('resize.navbar.dropdown');
		resetNavbarDropdown.call(this);
	  })
	 
	  function adjustNavbarDropdown() {
		var $sub = $(this).find('> .dropdown-menu');

		if( $sub.css('position') == 'fixed' ) {
			var win_width = parseInt($(window).width());
			var offset_w = win_width > 320 ? 60 : (win_width > 240 ? 40 : 30);
			var avail_width = parseInt(win_width) - offset_w;
			var avail_height = parseInt($(window).height()) - 30;
			
			var width = parseInt(Math.min(avail_width , 320));
			//we set 'width' here for text wrappings and spacings to take effect before calculating scrollHeight
			$sub.css('width', width);

			var tabbed = false;
			var extra_parts = 0;
			var dropdown_content = $sub.find('.tab-pane.active .dropdown-content.ace-scroll');
			if(dropdown_content.length == 0) dropdown_content = $sub.find('.dropdown-content.ace-scroll');
			else tabbed = true;

			var parent_menu = dropdown_content.closest('.dropdown-menu');
			var scrollHeight = $sub[0].scrollHeight;
			if(dropdown_content.length == 1) {
				//sometimes there's no scroll-content, for example in detached scrollbars
				var content =  dropdown_content.find('.scroll-content')[0];
				if(content) {
					scrollHeight = content.scrollHeight;
				}
			
				extra_parts += parent_menu.find('.dropdown-header').outerHeight();
				extra_parts += parent_menu.find('.dropdown-footer').outerHeight();
				
				var tab_content = parent_menu.closest('.tab-content');
				if( tab_content.length != 0 ) {
					extra_parts += tab_content.siblings('.nav-tabs').eq(0).height();
				}
			}
			

			
			var height = parseInt(Math.min(avail_height , 480, scrollHeight + extra_parts));
			var left = parseInt(Math.abs((avail_width + offset_w - width)/2));
			var top = parseInt(Math.abs((avail_height + 30 - height)/2));

			
			var zindex = parseInt($sub.css('z-index')) || 0;

			$sub.css({'height': height, 'left': left, 'right': 'auto', 'top': top - (!tabbed ? 1 : 3)});
			if(dropdown_content.length == 1) {
				if(!ace.vars['touch']) {
					dropdown_content.ace_scroll('update', {size: height - extra_parts}).ace_scroll('enable').ace_scroll('reset');
				}
				else {
					dropdown_content
					.ace_scroll('disable').css('max-height', height - extra_parts).addClass('overflow-scroll');
				}
			}
			$sub.css('height', height + (!tabbed ? 2 : 7));//for bottom border adjustment and tab content paddings
			
			
			if($sub.hasClass('user-menu')) {
				$sub.css('height', '');//because of user-info hiding/showing at different widths, which changes above 'scrollHeight', so we remove it!
				
				//user menu is re-positioned in small widths
				//but we need to re-position again in small heights as well (modal mode)
				var user_info = $(this).find('.user-info');
				if(user_info.length == 1 && user_info.css('position') == 'fixed') {
					user_info.css({'left': left, 'right': 'auto', 'top': top, 'width': width - 2, 'max-width': width - 2, 'z-index': zindex + 1});
				}
				else user_info.css({'left': '', 'right': '', 'top': '', 'width': '', 'max-width': '', 'z-index': ''});
			}
			
			//dropdown's z-index is limited by parent .navbar's z-index (which doesn't make sense because dropdowns are fixed!)
			//so for example when in 'content-slider' page, fixed modal toggle buttons go above are dropdowns
			//so we increase navbar's z-index to fix this!
			$(this).closest('.navbar.navbar-fixed-top').css('z-index', zindex);
		}
		else {
			if($sub.length != 0) resetNavbarDropdown.call(this, $sub);
		}
		
		var self = this;
		$(window)
		.off('resize.navbar.dropdown')
		.one('resize.navbar.dropdown', function() {
			$(self).triggerHandler('shown.bs.dropdown.navbar');
		})
	  }

	  //reset scrollbars and user menu
	  function resetNavbarDropdown($sub) {
		$sub = $sub || $(this).find('> .dropdown-menu');
	  
	    if($sub.length > 0) {
			$sub
			.css({'width': '', 'height': '', 'left': '', 'right': '', 'top': ''})
			.find('.dropdown-content').each(function() {
				if(ace.vars['touch']) {
					$(this).css('max-height', '').removeClass('overflow-scroll');
				}

				var size = parseInt($(this).attr('data-size') || 0) || $.fn.ace_scroll.defaults.size;
				$(this).ace_scroll('update', {size: size}).ace_scroll('enable').ace_scroll('reset');
			})
			
			if( $sub.hasClass('user-menu') ) {
				var user_info = 
				$(this).find('.user-info')
				.css({'left': '', 'right': '', 'top': '', 'width': '', 'max-width': '', 'z-index': ''});
			}
		}
		
		$(this).closest('.navbar').css('z-index', '');
	  }
	}

});//jQuery document ready





//some ace helper functions
(function($$ , undefined) {//$$ is ace.helper
 $$.unCamelCase = function(str) {
	return str.replace(/([a-z])([A-Z])/g, function(match, c1, c2){ return c1+'-'+c2.toLowerCase() })
 }
 $$.strToVal = function(str) {
	var res = str.match(/^(?:(true)|(false)|(null)|(\-?[\d]+(?:\.[\d]+)?)|(\[.*\]|\{.*\}))$/i);

	var val = str;
	if(res) {
		if(res[1]) val = true;
		else if(res[2]) val = false;
		else if(res[3]) val = null;	
		else if(res[4]) val = parseFloat(str);
		else if(res[5]) {
			try { val = JSON.parse(str) }
			catch (err) {}
		}
	}

	return val;
 }
 $$.getAttrSettings = function(el, attr_list, prefix) {
	var list_type = attr_list instanceof Array ? 1 : 2;
	//attr_list can be Array or Object(key/value)
	var prefix = prefix ? prefix.replace(/([^\-])$/ , '$1-') : '';
	prefix = 'data-' + prefix;

	var settings = {}
	for(var li in attr_list) if(attr_list.hasOwnProperty(li)) {
		var name = list_type == 1 ? attr_list[li] : li;
		var attr_val, attr_name = $$.unCamelCase(name.replace(/[^A-Za-z0-9]{1,}/g , '-')).toLowerCase()

		if( ! ((attr_val = el.getAttribute(prefix + attr_name))  ) ) continue;
		settings[name] = $$.strToVal(attr_val);
	}

	return settings;
 }

 $$.scrollTop = function() {
	return document.scrollTop || document.documentElement.scrollTop || document.body.scrollTop
 }
 $$.winHeight = function() {
	return window.innerHeight || document.documentElement.clientHeight;
 }
 $$.redraw = function(elem, force) {
	var saved_val = elem.style['display'];
	elem.style.display = 'none';
	elem.offsetHeight;
	if(force !== true) {
		elem.style.display = saved_val;
	}
	else {
		//force redraw for example in old IE
		setTimeout(function() {
			elem.style.display = saved_val;
		}, 10);
	}
 }
})(ace.helper);

/**
 <b>Sidebar functions</b>. Collapsing/expanding, toggling mobile view menu and other sidebar functions.
*/

(function($ , undefined) {
	var sidebar_count = 0;

	function Sidebar(sidebar, settings) {
		var self = this;
		this.$sidebar = $(sidebar);
		this.$sidebar.attr('data-sidebar', 'true');
		if( !this.$sidebar.attr('id') ) this.$sidebar.attr( 'id' , 'id-sidebar-'+(++sidebar_count) )

		
		//get a list of 'data-*' attributes that override 'defaults' and 'settings'
		var attrib_values = ace.helper.getAttrSettings(sidebar, $.fn.ace_sidebar.defaults, 'sidebar-');
		this.settings = $.extend({}, $.fn.ace_sidebar.defaults, settings, attrib_values);


		//some vars
		this.minimized = false;//will be initiated later
		this.collapsible = false;//...
		this.horizontal = false;//...
		this.mobile_view = false;//


		this.vars = function() {
			return {'minimized': this.minimized, 'collapsible': this.collapsible, 'horizontal': this.horizontal, 'mobile_view': this.mobile_view}
		}
		this.get = function(name) {
			if(this.hasOwnProperty(name)) return this[name];
		}
		this.set = function(name, value) {
			if(this.hasOwnProperty(name)) this[name] = value;
		}
		

		this.ref = function() {
			//return a reference to self
			return this;
		}

		var toggleIcon = function(minimized) {
			var icon = $(this).find(ace.vars['.icon']), icon1, icon2;
			if(icon.length > 0) {
				icon1 = icon.attr('data-icon1');//the icon for expanded state
				icon2 = icon.attr('data-icon2');//the icon for collapsed state

				if(minimized !== undefined) {
					if(minimized) icon.removeClass(icon1).addClass(icon2);
					else icon.removeClass(icon2).addClass(icon1);
				}
				else {
					icon.toggleClass(icon1).toggleClass(icon2);
				}
			}
		}		
		
		var findToggleBtn = function() {
			var toggle_btn = self.$sidebar.find('.sidebar-collapse');
			if(toggle_btn.length == 0) toggle_btn = $('.sidebar-collapse[data-target="#'+(self.$sidebar.attr('id')||'')+'"]');
			if(toggle_btn.length != 0) toggle_btn = toggle_btn[0];
			else toggle_btn = null;
			
			return toggle_btn;
		}
		
		//collapse/expand button
		this.toggleMenu = function(toggle_btn, save) {
			if(this.collapsible) return;

			//var minimized = this.$sidebar.hasClass('menu-min');
			this.minimized = !this.minimized;
			
			try {
				//toggle_btn can also be a param to indicate saving to cookie or not?! if toggle_btn === false, it won't be saved
				ace.settings.sidebar_collapsed(sidebar, this.minimized, !(toggle_btn === false || save === false));//@ ace-extra.js
			} catch(e) {
				if(this.minimized)
					this.$sidebar.addClass('menu-min');
				else this.$sidebar.removeClass('menu-min');
			}
	
			if( !toggle_btn ) {
				toggle_btn = findToggleBtn();
			}
			if(toggle_btn) {
				toggleIcon.call(toggle_btn, this.minimized);
			}

			//force redraw for ie8
			if(ace.vars['old_ie']) ace.helper.redraw(sidebar);
		}
		this.collapse = function(toggle_btn, save) {
			if(this.collapsible) return;
			this.minimized = false;
			
			this.toggleMenu(toggle_btn, save);
		}
		this.expand = function(toggle_btn, save) {
			if(this.collapsible) return;
			this.minimized = true;
			
			this.toggleMenu(toggle_btn, save);
		}
		

		
		//collapse/expand in 2nd mobile style
		this.toggleResponsive = function(toggle_btn) {
			if(!this.mobile_view || this.mobile_style != 3) return;
		
			if( this.$sidebar.hasClass('menu-min') ) {
				//remove menu-min because it interferes with responsive-max
				this.$sidebar.removeClass('menu-min');
				var btn = findToggleBtn();
				if(btn) toggleIcon.call(btn);
			}


			this.minimized = !this.$sidebar.hasClass('responsive-min');
			this.$sidebar.toggleClass('responsive-min responsive-max');


			if( !toggle_btn ) {
				toggle_btn = this.$sidebar.find('.sidebar-expand');
				if(toggle_btn.length == 0) toggle_btn = $('.sidebar-expand[data-target="#'+(this.$sidebar.attr('id')||'')+'"]');
				if(toggle_btn.length != 0) toggle_btn = toggle_btn[0];
				else toggle_btn = null;
			}
			
			if(toggle_btn) {
				var icon = $(toggle_btn).find(ace.vars['.icon']), icon1, icon2;
				if(icon.length > 0) {
					icon1 = icon.attr('data-icon1');//the icon for expanded state
					icon2 = icon.attr('data-icon2');//the icon for collapsed state

					icon.toggleClass(icon1).toggleClass(icon2);
				}
			}

			$(document).triggerHandler('settings.ace', ['sidebar_collapsed' , this.minimized]);
		}
		
		//some helper functions
		this.is_collapsible = function() {
			var toggle
			return (this.$sidebar.hasClass('navbar-collapse'))
			&& ((toggle = $('.navbar-toggle[data-target="#'+(this.$sidebar.attr('id')||'')+'"]').get(0)) != null)
			&&  toggle.scrollHeight > 0
			//sidebar is collapsible and collapse button is visible?
		}
		this.is_mobile_view = function() {
			var toggle
			return ((toggle = $('.menu-toggler[data-target="#'+(this.$sidebar.attr('id')||'')+'"]').get(0)) != null)
			&&  toggle.scrollHeight > 0
		}


		//toggling submenu
		this.$sidebar.on(ace.click_event+'.ace.submenu', '.nav-list', function (ev) {
			var nav_list = this;

			//check to see if we have clicked on an element which is inside a .dropdown-toggle element?!
			//if so, it means we should toggle a submenu
			var link_element = $(ev.target).closest('a');
			if(!link_element || link_element.length == 0) return;//return if not clicked inside a link element

			var minimized  = self.minimized && !self.collapsible;
			//if .sidebar is .navbar-collapse and in small device mode, then let minimized be uneffective
	
			if( !link_element.hasClass('dropdown-toggle') ) {//it doesn't have a submenu return
				//just one thing before we return
				//if sidebar is collapsed(minimized) and we click on a first level menu item
				//and the click is on the icon, not on the menu text then let's cancel event and cancel navigation
				//Good for touch devices, that when the icon is tapped to see the menu text, navigation is cancelled
				//navigation is only done when menu text is tapped

				if( ace.click_event == 'tap'
					&&
					minimized
					&&
					link_element.get(0).parentNode.parentNode == nav_list )//only level-1 links
				{
					var text = link_element.find('.menu-text').get(0);
					if( text != null && ev.target != text && !$.contains(text , ev.target) ) {//not clicking on the text or its children
						ev.preventDefault();
						return false;
					}
				}


				//ios safari only has a bit of a problem not navigating to link address when scrolling down
				//specify data-link attribute to ignore this
				if(ace.vars['ios_safari'] && link_element.attr('data-link') !== 'false') {
					//only ios safari has a bit of a problem not navigating to link address when scrolling down
					//please see issues section in documentation
					document.location = link_element.attr('href');
					ev.preventDefault();
					return false;
				}

				return;
			}
			
			ev.preventDefault();
			
			


			var sub = link_element.siblings('.submenu').get(0);
			if(!sub) return false;
			var $sub = $(sub);

			var height_change = 0;//the amount of height change in .nav-list

			var parent_ul = sub.parentNode.parentNode;
			if
			(
				( minimized && parent_ul == nav_list )
				 || 
				( ( $sub.parent().hasClass('hover') && $sub.css('position') == 'absolute' ) && !self.collapsible )
			)
			{
				return false;
			}

			
			var sub_hidden = (sub.scrollHeight == 0)

			//if not open and visible, let's open it and make it visible
			if( sub_hidden ) {//being shown now
			  $(parent_ul).find('> .open > .submenu').each(function() {
				//close all other open submenus except for the active one
				if(this != sub && !$(this.parentNode).hasClass('active')) {
					height_change -= this.scrollHeight;
					self.hide(this, self.settings.duration, false);
				}
			  })
			}

			if( sub_hidden ) {//being shown now
				self.show(sub, self.settings.duration);
				//if a submenu is being shown and another one previously started to hide, then we may need to update/hide scrollbars
				//but if no previous submenu is being hidden, then no need to check if we need to hide the scrollbars in advance
				if(height_change != 0) height_change += sub.scrollHeight;//we need new updated 'scrollHeight' here
			} else {
				self.hide(sub, self.settings.duration);
				height_change -= sub.scrollHeight;
				//== -1 means submenu is being hidden
			}

			//hide scrollbars if content is going to be small enough that scrollbars is not needed anymore
			//do this almost before submenu hiding begins
			//but when minimized submenu's toggle should have no effect
			if (height_change != 0) {
				if(self.$sidebar.attr('data-sidebar-scroll') == 'true' && !self.minimized) 
					self.$sidebar.ace_sidebar_scroll('prehide', height_change)
			}

			return false;
		})

		var submenu_working = false;
		this.show = function(sub, $duration, shouldWait) {
			//'shouldWait' indicates whether to wait for previous transition (submenu toggle) to be complete or not?
			shouldWait = (shouldWait !== false);
			if(shouldWait && submenu_working) return false;
					
			var $sub = $(sub);
			var event;
			$sub.trigger(event = $.Event('show.ace.submenu'))
			if (event.isDefaultPrevented()) {
				return false;
			}
			
			if(shouldWait) submenu_working = true;


			$duration = $duration || this.settings.duration;
			
			$sub.css({
				height: 0,
				overflow: 'hidden',
				display: 'block'
			})
			.removeClass('nav-hide').addClass('nav-show')//only for window < @grid-float-breakpoint and .navbar-collapse.menu-min
			.parent().addClass('open');
			
			sub.scrollTop = 0;//this is for submenu_hover when sidebar is minimized and a submenu is scrollTop'ed using scrollbars ...

			if( $duration > 0 ) {
			  $sub.css({height: sub.scrollHeight,
				'transition-property': 'height',
				'transition-duration': ($duration/1000)+'s'})
			}

			var complete = function(ev, trigger) {
				ev && ev.stopPropagation();
				$sub
				.css({'transition-property': '', 'transition-duration': '', overflow:'', height: ''})
				//if(ace.vars['webkit']) ace.helper.redraw(sub);//little Chrome issue, force redraw ;)

				if(trigger !== false) $sub.trigger($.Event('shown.ace.submenu'))
				
				if(shouldWait) submenu_working = false;
			}
			
			if( $duration > 0 && !!$.support.transition.end ) {
			  $sub.one($.support.transition.end, complete);
			}
			else complete();
			
			//there is sometimes a glitch, so maybe retry
			if(ace.vars['android']) {
				setTimeout(function() {
					complete(null, false);
					ace.helper.redraw(sub);
				}, $duration + 20);
			}

			return true;
		 }
		 
		 
		 this.hide = function(sub, $duration, shouldWait) {
			//'shouldWait' indicates whether to wait for previous transition (submenu toggle) to be complete or not?
			shouldWait = (shouldWait !== false);
			if(shouldWait && submenu_working) return false;
		 
			
			var $sub = $(sub);
			var event;
			$sub.trigger(event = $.Event('hide.ace.submenu'))
			if (event.isDefaultPrevented()) {
				return false;
			}
			
			if(shouldWait) submenu_working = true;
			

			$duration = $duration || this.settings.duration;
			
			$sub.css({
				height: sub.scrollHeight,
				overflow: 'hidden',
				display: 'block'
			})
			.parent().removeClass('open');

			sub.offsetHeight;
			//forces the "sub" to re-consider the new 'height' before transition

			if( $duration > 0 ) {
			  $sub.css({'height': 0,
				'transition-property': 'height',
				'transition-duration': ($duration/1000)+'s'});
			}


			var complete = function(ev, trigger) {
				ev && ev.stopPropagation();
				$sub
				.css({display: 'none', overflow:'', height: '', 'transition-property': '', 'transition-duration': ''})
				.removeClass('nav-show').addClass('nav-hide')//only for window < @grid-float-breakpoint and .navbar-collapse.menu-min

				if(trigger !== false) $sub.trigger($.Event('hidden.ace.submenu'))
				
				if(shouldWait) submenu_working = false;
			}

			if( $duration > 0 && !!$.support.transition.end ) {
			   $sub.one($.support.transition.end, complete);
			}
			else complete();


			//there is sometimes a glitch, so maybe retry
			if(ace.vars['android']) {
				setTimeout(function() {
					complete(null, false);
					ace.helper.redraw(sub);
				}, $duration + 20);
			}

			return true;
		 }

		 this.toggle = function(sub, $duration) {
			$duration = $duration || self.settings.duration;
		 
			if( sub.scrollHeight == 0 ) {//if an element is hidden scrollHeight becomes 0
				if( this.show(sub, $duration) ) return 1;
			} else {
				if( this.hide(sub, $duration) ) return -1;
			}
			return 0;
		 }


		//sidebar vars
		var minimized_menu_class  = 'menu-min';
		var responsive_min_class  = 'responsive-min';
		var horizontal_menu_class = 'h-sidebar';

		var sidebar_mobile_style = function() {
			//differnet mobile menu styles
			this.mobile_style = 1;//default responsive mode with toggle button inside navbar
			if(this.$sidebar.hasClass('responsive') && !$('.menu-toggler[data-target="#'+this.$sidebar.attr('id')+'"]').hasClass('navbar-toggle')) this.mobile_style = 2;//toggle button behind sidebar
			 else if(this.$sidebar.hasClass(responsive_min_class)) this.mobile_style = 3;//minimized menu
			  else if(this.$sidebar.hasClass('navbar-collapse')) this.mobile_style = 4;//collapsible (bootstrap style)
		}
		sidebar_mobile_style.call(self);
		  
		function update_vars() {
			this.mobile_view = this.mobile_style < 4 && this.is_mobile_view();
			this.collapsible = !this.mobile_view && this.is_collapsible();

			this.minimized = 
			(!this.collapsible && this.$sidebar.hasClass(minimized_menu_class))
			 ||
			(this.mobile_style == 3 && this.mobile_view && this.$sidebar.hasClass(responsive_min_class))

			this.horizontal = !(this.mobile_view || this.collapsible) && this.$sidebar.hasClass(horizontal_menu_class)
		}

		//update some basic variables
		$(window).on('resize.sidebar.vars' , function(){
			update_vars.call(self);
		}).triggerHandler('resize.sidebar.vars')

	}//end of Sidebar
	

	//sidebar events
	
	//menu-toggler
	$(document)
	.on(ace.click_event+'.ace.menu', '.menu-toggler', function(e){
		var btn = $(this);
		var sidebar = $(btn.attr('data-target'));
		if(sidebar.length == 0) return;
		
		e.preventDefault();
				
		sidebar.toggleClass('display');
		btn.toggleClass('display');
		
		var click_event = ace.click_event+'.ace.autohide';
		var auto_hide = sidebar.attr('data-auto-hide') === 'true';

		if( btn.hasClass('display') ) {
			//hide menu if clicked outside of it!
			if(auto_hide) {
				$(document).on(click_event, function(ev) {
					if( sidebar.get(0) == ev.target || $.contains(sidebar.get(0), ev.target) ) {
						ev.stopPropagation();
						return;
					}

					sidebar.removeClass('display');
					btn.removeClass('display');
					$(document).off(click_event);
				})
			}

			if(sidebar.attr('data-sidebar-scroll') == 'true') sidebar.ace_sidebar_scroll('reset');
		}
		else {
			if(auto_hide) $(document).off(click_event);
		}

		return false;
	})
	//sidebar collapse/expand button
	.on(ace.click_event+'.ace.menu', '.sidebar-collapse', function(e){
		
		var target = $(this).attr('data-target'), $sidebar = null;
		if(target) $sidebar = $(target);
		if($sidebar == null || $sidebar.length == 0) $sidebar = $(this).closest('.sidebar');
		if($sidebar.length == 0) return;

		e.preventDefault();
		$sidebar.ace_sidebar('toggleMenu', this);
	})
	//this button is used in `mobile_style = 3` responsive menu style to expand minimized sidebar
	.on(ace.click_event+'.ace.menu', '.sidebar-expand', function(e){
		var target = $(this).attr('data-target'), $sidebar = null;
		if(target) $sidebar = $(target);
		if($sidebar == null || $sidebar.length == 0) $sidebar = $(this).closest('.sidebar');
		if($sidebar.length == 0) return;	
	
		var btn = this;
		e.preventDefault();
		$sidebar.ace_sidebar('toggleResponsive', this);
		
		var click_event = ace.click_event+'.ace.autohide';
		if($sidebar.attr('data-auto-hide') === 'true') {
			if( $sidebar.hasClass('responsive-max') ) {
				$(document).on(click_event, function(ev) {
					if( $sidebar.get(0) == ev.target || $.contains($sidebar.get(0), ev.target) ) {
						ev.stopPropagation();
						return;
					}

					$sidebar.ace_sidebar('toggleResponsive', btn);
					$(document).off(click_event);
				})
			}
			else {
				$(document).off(click_event);
			}
		}
	})

	
	$.fn.ace_sidebar = function (option, value) {
		var method_call;

		var $set = this.each(function () {
			var $this = $(this);
			var data = $this.data('ace_sidebar');
			var options = typeof option === 'object' && option;

			if (!data) $this.data('ace_sidebar', (data = new Sidebar(this, options)));
			if (typeof option === 'string' && typeof data[option] === 'function') {
				if(value instanceof Array) method_call = data[option].apply(data, value);
				else method_call = data[option](value);
			}
		});

		return (method_call === undefined) ? $set : method_call;
	};
	
	
	$.fn.ace_sidebar.defaults = {
		'duration': 300
    }


})(window.jQuery);


/**
 <b>Scrollbars for sidebar</b>. This approach can <span class="text-danger">only</span> be used on <u>fixed</u> sidebar.
 It doesn't use <u>"overflow:hidden"</u> CSS property and therefore can be used with <u>.hover</u> submenus and minimized sidebar.
 Except when in mobile view and menu toggle button is not in the navbar.
*/

(function($ , undefined) {
	//if( !$.fn.ace_scroll ) return;

	var old_safari = ace.vars['safari'] && navigator.userAgent.match(/version\/[1-5]/i)
	//NOTE
	//Safari on windows has not been updated for a long time.
	//And it has a problem when sidebar is fixed & scrollable and there is a CSS3 animation inside page content.
	//Very probably windows users of safari have migrated to another browser by now!

	var is_element_pos =
	'getComputedStyle' in window ?
	//el.offsetHeight is used to force redraw and recalculate 'el.style.position' esp. for webkit!
	function(el, pos) { el.offsetHeight; return window.getComputedStyle(el).position == pos }
	:
	function(el, pos) { el.offsetHeight; return $(el).css('position') == pos }
	
		
	function Sidebar_Scroll(sidebar , settings) {
		var self = this;

		var $window = $(window);
		var $sidebar = $(sidebar),
			$nav = $sidebar.find('.nav-list'),
			$toggle = $sidebar.find('.sidebar-toggle').eq(0),
			$shortcuts = $sidebar.find('.sidebar-shortcuts').eq(0);
			
		var nav = $nav.get(0);
		if(!nav) return;
		
		
		var attrib_values = ace.helper.getAttrSettings(sidebar, $.fn.ace_sidebar_scroll.defaults);
		this.settings = $.extend({}, $.fn.ace_sidebar_scroll.defaults, settings, attrib_values);
		var scroll_to_active = self.settings.scroll_to_active;
	
	
		var ace_sidebar = $sidebar.ace_sidebar('ref');
		$sidebar.attr('data-sidebar-scroll', 'true');
			
		
		var scroll_div = null,
			scroll_content = null,
			scroll_content_div = null,
			bar = null,
			track = null,
			ace_scroll = null;


		this.is_scrolling = false;
		var _initiated = false;
		this.sidebar_fixed = is_element_pos(sidebar, 'fixed');
		
		var $avail_height, $content_height;

		
		var available_height = function() {
			//available window space
			var offset = $nav.parent().offset();//because `$nav.offset()` considers the "scrolled top" amount as well
			if(self.sidebar_fixed) offset.top -= ace.helper.scrollTop();

			return $window.innerHeight() - offset.top - ( self.settings.include_toggle ? 0 : $toggle.outerHeight() );
		}
		var content_height = function() {
			return nav.clientHeight;//we don't use nav.scrollHeight here, because hover submenus are considered in calculating scrollHeight despite position=absolute!
		}

		
		
		var initiate = function(on_page_load) {
			if( _initiated ) return;
			if( !self.sidebar_fixed ) return;//eligible??
			//return if we want scrollbars only on "fixed" sidebar and sidebar is not "fixed" yet!

			//initiate once
			$nav.wrap('<div class="nav-wrap-up pos-rel" />');
			$nav.after('<div><div></div></div>');

			$nav.wrap('<div class="nav-wrap" />');
			if(!self.settings.include_toggle) $toggle.css({'z-index': 1});
			if(!self.settings.include_shortcuts) $shortcuts.css({'z-index': 99});

			scroll_div = $nav.parent().next()
			.ace_scroll({
				size: available_height(),
				//reset: true,
				mouseWheelLock: true,
				hoverReset: false,
				dragEvent: true,
				styleClass: self.settings.scroll_style,
				touchDrag: false//disable touch drag event on scrollbars, we'll add a custom one later
			})
			.closest('.ace-scroll').addClass('nav-scroll');
			
			ace_scroll = scroll_div.data('ace_scroll');

			scroll_content = scroll_div.find('.scroll-content').eq(0);
			scroll_content_div = scroll_content.find(' > div').eq(0);
			
			track = $(ace_scroll.get_track());
			bar = track.find('.scroll-bar').eq(0);

			if(self.settings.include_shortcuts && $shortcuts.length != 0) {
				$nav.parent().prepend($shortcuts).wrapInner('<div />');
				$nav = $nav.parent();
			}
			if(self.settings.include_toggle && $toggle.length != 0) {
				$nav.append($toggle);
				$nav.closest('.nav-wrap').addClass('nav-wrap-t');//it just helps to remove toggle button's top border and restore li:last-child's bottom border
			}

			$nav.css({position: 'relative'});
			if( self.settings.scroll_outside == true ) scroll_div.addClass('scrollout');
			
			nav = $nav.get(0);
			nav.style.top = 0;
			scroll_content.on('scroll.nav', function() {
				nav.style.top = (-1 * this.scrollTop) + 'px';
			});
			
			//mousewheel library available?
			$nav.on(!!$.event.special.mousewheel ? 'mousewheel.ace_scroll' : 'mousewheel.ace_scroll DOMMouseScroll.ace_scroll', function(event){
				if( !self.is_scrolling || !ace_scroll.is_active() ) {
					return !self.settings.lock_anyway;
				}
				//transfer $nav's mousewheel event to scrollbars
				return scroll_div.trigger(event);
			});
			
			$nav.on('mouseenter.ace_scroll', function() {
				track.addClass('scroll-hover');
			}).on('mouseleave.ace_scroll', function() {
				track.removeClass('scroll-hover');
			});


			/**
			$(document.body).on('touchmove.nav', function(event) {
				if( self.is_scrolling && $.contains(sidebar, event.target) ) {
					event.preventDefault();
					return false;
				}
			})
			*/

			//you can also use swipe event in a similar way //swipe.nav
			var content = scroll_content.get(0);
			$nav.on('ace_drag.nav', function(event) {
				if( !self.is_scrolling || !ace_scroll.is_active() ) {
					event.retval.cancel = true;
					return;
				}
				
				//if submenu hover is being scrolled let's cancel sidebar scroll!
				if( $(event.target).closest('.can-scroll').length != 0 ) {
					event.retval.cancel = true;
					return;
				}

				if(event.direction == 'up' || event.direction == 'down') {
					
					ace_scroll.move_bar(true);
					
					var distance = event.dy;
					
					distance = parseInt(Math.min($avail_height, distance))
					if(Math.abs(distance) > 2) distance = distance * 2;
					
					if(distance != 0) {
						content.scrollTop = content.scrollTop + distance;
						nav.style.top = (-1 * content.scrollTop) + 'px';
					}
				}
			});
			

			//for drag only
			if(self.settings.smooth_scroll) {
				$nav
				.on('touchstart.nav MSPointerDown.nav pointerdown.nav', function(event) {
					$nav.css('transition-property', 'none');
					bar.css('transition-property', 'none');
				})
				.on('touchend.nav touchcancel.nav MSPointerUp.nav MSPointerCancel.nav pointerup.nav pointercancel.nav', function(event) {
					$nav.css('transition-property', 'top');
					bar.css('transition-property', 'top');
				});
			}
			
			

			if(old_safari && !self.settings.include_toggle) {
				var toggle = $toggle.get(0);
				if(toggle) scroll_content.on('scroll.safari', function() {
					ace.helper.redraw(toggle);
				});
			}

			_initiated = true;

			//if the active item is not visible, scroll down so that it becomes visible
			//only the first time, on page load
			if(on_page_load == true) {
				self.reset();//try resetting at first

				if( scroll_to_active ) {
					self.scroll_to_active();
				}
				scroll_to_active = false;
			}
			
			
			
			if( typeof self.settings.smooth_scroll === 'number' && self.settings.smooth_scroll > 0) {
				$nav.css({'transition-property': 'top', 'transition-duration': (self.settings.smooth_scroll / 1000).toFixed(2)+'s'})
				bar.css({'transition-property': 'top', 'transition-duration': (self.settings.smooth_scroll / 1500).toFixed(2)+'s'})
				
				scroll_div
				.on('drag.start', function(e) {
					e.stopPropagation();
					$nav.css('transition-property', 'none')
				})
				.on('drag.end', function(e) {
					e.stopPropagation();
					$nav.css('transition-property', 'top')
				});
			}
			
			if(ace.vars['android']) {
				//force hide address bar, because its changes don't trigger window resize and become kinda ugly
				var val = ace.helper.scrollTop();
				if(val < 2) {
					window.scrollTo( val, 0 );
					setTimeout( function() {
						self.reset();
					}, 20 );
				}
				
				var last_height = ace.helper.winHeight() , new_height;
				$(window).on('scroll.ace_scroll', function() {
					if(self.is_scrolling && ace_scroll.is_active()) {
						new_height = ace.helper.winHeight();
						if(new_height != last_height) {
							last_height = new_height;
							self.reset();
						}
					}
				});
			}
		}
		
		
		
		
		this.scroll_to_active = function() {
			if( !ace_scroll || !ace_scroll.is_active() ) return;
			try {
				//sometimes there's no active item or not 'offsetTop' property
				var $active;
				
				var vars = ace_sidebar['vars']()

				var nav_list = $sidebar.find('.nav-list')
				if(vars['minimized'] && !vars['collapsible']) {
					$active = nav_list.find('> .active')
				}
				else {
					$active = $nav.find('> .active.hover')
					if($active.length == 0)	$active = $nav.find('.active:not(.open)')
				}

			
				var top = $active.outerHeight();
				nav_list = nav_list.get(0);
				var active = $active.get(0);
				while(active != nav_list) {
					top += active.offsetTop;
					active = active.parentNode;
				}

				var scroll_amount = top - scroll_div.height();
				if(scroll_amount > 0) {
					nav.style.top = -scroll_amount + 'px';
					scroll_content.scrollTop(scroll_amount);
				}
			}catch(e){}
		}
		
		
		
		this.reset = function(recalc) {
			if(recalc === true) {
				this.sidebar_fixed = is_element_pos(sidebar, 'fixed');
			}
			
			if( !this.sidebar_fixed ) {
				this.disable();
				return;//eligible??
			}

			//return if we want scrollbars only on "fixed" sidebar and sidebar is not "fixed" yet!

			if( !_initiated ) initiate();
			//initiate scrollbars if not yet
			
			var vars = ace_sidebar['vars']();
			

			//enable if:
			//menu is not collapsible mode (responsive navbar-collapse mode which has default browser scrollbar)
			//menu is not horizontal or horizontal but mobile view (which is not navbar-collapse)
			//and available height is less than nav's height
			

			var enable_scroll = !vars['collapsible'] && !vars['horizontal']
								&& ($avail_height = available_height()) < ($content_height = nav.clientHeight);
								//we don't use nav.scrollHeight here, because hover submenus are considered in calculating scrollHeight despite position=absolute!

								
			this.is_scrolling = true;
			if( enable_scroll ) {
				scroll_content_div.css({height: $content_height, width: 8});
				scroll_div.prev().css({'max-height' : $avail_height})
				ace_scroll.update({size: $avail_height})
				ace_scroll.enable();
				ace_scroll.reset();
			}
			if( !enable_scroll || !ace_scroll.is_active() ) {
				if(this.is_scrolling) this.disable();
			}
			else {
				$sidebar.addClass('sidebar-scroll');
			}
			
			//return this.is_scrolling;
		}
		
		
		
		this.disable = function() {
			this.is_scrolling = false;
			if(scroll_div) {
				scroll_div.css({'height' : '', 'max-height' : ''});
				scroll_content_div.css({height: '', width: ''});//otherwise it will have height and takes up some space even when invisible
				scroll_div.prev().css({'max-height' : ''})
				ace_scroll.disable();
			}

			if(parseInt(nav.style.top) < 0 && self.settings.smooth_scroll && $.support.transition.end) {
				$nav.one($.support.transition.end, function() {
					$sidebar.removeClass('sidebar-scroll');
					$nav.off('.trans');
				});
			} else {
				$sidebar.removeClass('sidebar-scroll');
			}

			nav.style.top = 0;
		}
		
		this.prehide = function(height_change) {
			if(!this.is_scrolling || ace_sidebar.get('minimized')) return;//when minimized submenu's toggle should have no effect
			
			if(content_height() + height_change < available_height()) {
				this.disable();
			}
			else if(height_change < 0) {
				//if content height is decreasing
				//let's move nav down while a submenu is being hidden
				var scroll_top = scroll_content.scrollTop() + height_change
				if(scroll_top < 0) return;

				nav.style.top = (-1 * scroll_top) + 'px';
			}
		}
		
		
		this._reset = function(recalc) {
			if(recalc === true) {
				this.sidebar_fixed = is_element_pos(sidebar, 'fixed');
			}
			
			if(ace.vars['webkit']) 
				setTimeout(function() { self.reset() } , 0);
			else this.reset();
		}
		
		
		this.set_hover = function() {
			if(track) track.addClass('scroll-hover');
		}
		
		this.get = function(name) {
			if(this.hasOwnProperty(name)) return this[name];
		}
		this.set = function(name, value) {
			if(this.hasOwnProperty(name)) this[name] = value;
		}
		this.ref = function() {
			//return a reference to self
			return this;
		}
		
		this.updateStyle = function(styleClass) {
			if(ace_scroll == null) return;
			ace_scroll.update({styleClass: styleClass});
		}

		
		//change scrollbar size after a submenu is hidden/shown
		//but don't change if sidebar is minimized
		$sidebar.on('hidden.ace.submenu.sidebar_scroll shown.ace.submenu.sidebar_scroll', '.submenu', function(e) {
			e.stopPropagation();

			if( !ace_sidebar.get('minimized') ) {
				//webkit has a little bit of a glitch!!!
				self._reset();
				if( e.type == 'shown' ) self.set_hover();
			}
		});

		
		initiate(true);//true = on_page_load
	}
	

	
	//reset on document and window changes
	$(document).on('settings.ace.sidebar_scroll', function(ev, event_name, event_val){
		$('.sidebar[data-sidebar-scroll=true]').each(function() {
			var $this = $(this);
			var sidebar_scroll = $this.ace_sidebar_scroll('ref');

			if( event_name == 'sidebar_collapsed' && is_element_pos(this, 'fixed') ) {
				if( $this.attr('data-sidebar-hover') == 'true' ) $this.ace_sidebar_hover('reset');
				sidebar_scroll._reset();
			}
			else if( event_name === 'sidebar_fixed' || event_name === 'navbar_fixed' ) {
				var is_scrolling = sidebar_scroll.get('is_scrolling');
				var sidebar_fixed = is_element_pos(this, 'fixed')
				sidebar_scroll.set('sidebar_fixed', sidebar_fixed);

				if(sidebar_fixed && !is_scrolling) {
					sidebar_scroll._reset();
				}
				else if( !sidebar_fixed ) {
					sidebar_scroll.disable();
				}
			}
		
		});
	});
	
	$(window).on('resize.ace.sidebar_scroll', function(){
		$('.sidebar[data-sidebar-scroll=true]').each(function() {
			var $this = $(this);
			if( $this.attr('data-sidebar-hover') == 'true' ) $this.ace_sidebar_hover('reset');
			/////////////
			var sidebar_scroll = $(this).ace_sidebar_scroll('ref');
			
			var sidebar_fixed = is_element_pos(this, 'fixed')
			sidebar_scroll.set('sidebar_fixed', sidebar_fixed);
			sidebar_scroll._reset();
		});
	})
	

	
	
	 /////////////////////////////////////////////
	 if(!$.fn.ace_sidebar_scroll) {
	  $.fn.ace_sidebar_scroll = function (option, value) {
		var method_call;

		var $set = this.each(function () {
			var $this = $(this);
			var data = $this.data('ace_sidebar_scroll');
			var options = typeof option === 'object' && option;

			if (!data) $this.data('ace_sidebar_scroll', (data = new Sidebar_Scroll(this, options)));
			if (typeof option === 'string' && typeof data[option] === 'function') {
				method_call = data[option](value);
			}
		});

		return (method_call === undefined) ? $set : method_call;
	 }
	 
	 
	 $.fn.ace_sidebar_scroll.defaults = {
		'scroll_to_active': true,
		'include_shortcuts': true,
		'include_toggle': false,
		'smooth_scroll': 150,
		'scroll_outside': false,
		'scroll_style': '',
		'lock_anyway': false
     }
	 
	}

})(window.jQuery);

/**
 <b>Widget boxes</b>
*/
(function($ , undefined) {

	var Widget_Box = function(box, options) {
		this.$box = $(box);
		var that = this;
		//this.options = $.extend({}, $.fn.widget_box.defaults, options);

		this.reload = function() {
			var $box = this.$box;
			var $remove_position = false;
			if($box.css('position') == 'static') {
				$remove_position = true;
				$box.addClass('position-relative');
			}
			$box.append('<div class="widget-box-overlay"><i class="'+ ace.vars['icon'] + 'loading-icon fa fa-spinner fa-spin fa-2x white"></i></div>');

			$box.one('reloaded.ace.widget', function() {
				$box.find('.widget-box-overlay').remove();
				if($remove_position) $box.removeClass('position-relative');
			});
		}

		this.close = function() {
			var $box = this.$box;
			var closeSpeed = 300;
			$box.fadeOut(closeSpeed , function(){
					$box.trigger('closed.ace.widget');
					$box.remove();
				}
			)
		}
		
		this.toggle = function(type, button) {
			var $box = this.$box;
			var $body = $box.find('.widget-body').eq(0);
			var $icon = null;
			
			var event_name = typeof type !== 'undefined' ? type : ($box.hasClass('collapsed') ? 'show' : 'hide');
			var event_complete_name = event_name == 'show' ? 'shown' : 'hidden';

			if(typeof button === 'undefined') {
				button = $box.find('> .widget-header a[data-action=collapse]').eq(0);
				if(button.length == 0) button = null;
			}

			if(button) {
				$icon = button.find(ace.vars['.icon']).eq(0);

				var $match
				var $icon_down = null
				var $icon_up = null
				if( ($icon_down = $icon.attr('data-icon-show')) ) {
					$icon_up = $icon.attr('data-icon-hide')
				}
				else if( $match = $icon.attr('class').match(/fa\-(.*)\-(up|down)/) ) {
					$icon_down = 'fa-'+$match[1]+'-down'
					$icon_up = 'fa-'+$match[1]+'-up'
				}
			}

			var expandSpeed   = 250;
			var collapseSpeed = 200;

			if( event_name == 'show' ) {
				if($icon) $icon.removeClass($icon_down).addClass($icon_up);

				$body.hide();
				$box.removeClass('collapsed');
				$body.slideDown(expandSpeed, function(){
					$box.trigger(event_complete_name+'.ace.widget')
				})
			}
			else {
				if($icon) $icon.removeClass($icon_up).addClass($icon_down);
				$body.slideUp(collapseSpeed, function(){
						$box.addClass('collapsed')
						$box.trigger(event_complete_name+'.ace.widget')
					}
				);
			}
		}
		
		this.hide = function() {
			this.toggle('hide');
		}
		this.show = function() {
			this.toggle('show');
		}
		
		
		this.fullscreen = function() {
			var $icon = this.$box.find('> .widget-header a[data-action=fullscreen]').find(ace.vars['.icon']).eq(0);
			var $icon_expand = null
			var $icon_compress = null
			if( ($icon_expand = $icon.attr('data-icon1')) ) {
				$icon_compress = $icon.attr('data-icon2')
			}
			else {
				$icon_expand = 'fa-expand';
				$icon_compress = 'fa-compress';
			}
			
			
			if(!this.$box.hasClass('fullscreen')) {
				$icon.removeClass($icon_expand).addClass($icon_compress);
				this.$box.addClass('fullscreen');
				
				applyScrollbars(this.$box, true);
			}
			else {
				$icon.addClass($icon_expand).removeClass($icon_compress);
				this.$box.removeClass('fullscreen');
				
				applyScrollbars(this.$box, false);
			}
			
			this.$box.trigger('fullscreened.ace.widget')
		}

	}
	
	$.fn.widget_box = function (option, value) {
		var method_call;

		var $set = this.each(function () {
			var $this = $(this);
			var data = $this.data('widget_box');
			var options = typeof option === 'object' && option;

			if (!data) $this.data('widget_box', (data = new Widget_Box(this, options)));
			if (typeof option === 'string') method_call = data[option](value);
		});

		return (method_call === undefined) ? $set : method_call;
	};


	$(document).on('click.ace.widget', '.widget-header a[data-action]', function (ev) {
		ev.preventDefault();

		var $this = $(this);
		var $box = $this.closest('.widget-box');
		if( $box.length == 0 || $box.hasClass('ui-sortable-helper') ) return;

		var $widget_box = $box.data('widget_box');
		if (!$widget_box) {
			$box.data('widget_box', ($widget_box = new Widget_Box($box.get(0))));
		}

		var $action = $this.data('action');
		if($action == 'collapse') {
			var event_name = $box.hasClass('collapsed') ? 'show' : 'hide';

			var event
			$box.trigger(event = $.Event(event_name+'.ace.widget'))
			if (event.isDefaultPrevented()) return

			$widget_box.toggle(event_name, $this);
		}
		else if($action == 'close') {
			var event
			$box.trigger(event = $.Event('close.ace.widget'))
			if (event.isDefaultPrevented()) return

			$widget_box.close();
		}
		else if($action == 'reload') {
			$this.blur();
			var event
			$box.trigger(event = $.Event('reload.ace.widget'))
			if (event.isDefaultPrevented()) return

			$widget_box.reload();
		}
		else if($action == 'fullscreen') {
			var event
			$box.trigger(event = $.Event('fullscreen.ace.widget'))
			if (event.isDefaultPrevented()) return
		
			$widget_box.fullscreen();
		}
		else if($action == 'settings') {
			$box.trigger('setting.ace.widget')
		}

	});
	
		
	function applyScrollbars($widget, enable) {
		var $main = $widget.find('.widget-main').eq(0);
		$(window).off('resize.widget.scroll');
		
		//IE8 has an unresolvable issue!!! re-scrollbaring with unknown values?!
		var nativeScrollbars = ace.vars['old_ie'] || ace.vars['touch'];
		
		if(enable) {
			var ace_scroll = $main.data('ace_scroll');
			if( ace_scroll ) {
				$main.data('save_scroll', {size: ace_scroll['size'], lock: ace_scroll['lock'], lock_anyway: ace_scroll['lock_anyway']});
			}
			
			var size = $widget.height() - $widget.find('.widget-header').height() - 10;//extra paddings
			size = parseInt(size);
			
			$main.css('min-height', size);
			if( !nativeScrollbars ) {
				if( ace_scroll ) {
					$main.ace_scroll('update', {'size': size, 'mouseWheelLock': true, 'lockAnyway': true});
				}
				else {
					$main.ace_scroll({'size': size, 'mouseWheelLock': true, 'lockAnyway': true});
				}
				$main.ace_scroll('enable').ace_scroll('reset');
			}
			else {
				if( ace_scroll ) $main.ace_scroll('disable');
				$main.css('max-height', size).addClass('overflow-scroll');
			}
			
			
			$(window)
			.on('resize.widget.scroll', function() {
				var size = $widget.height() - $widget.find('.widget-header').height() - 10;//extra paddings
				size = parseInt(size);
				
				$main.css('min-height', size);
				if( !nativeScrollbars ) {
					$main.ace_scroll('update', {'size': size}).ace_scroll('reset');
				}
				else {
					$main.css('max-height', size).addClass('overflow-scroll');
				}
			});
		}
		
		else  {
			$main.css('min-height', '');
			var saved_scroll = $main.data('save_scroll');
			if(saved_scroll) {
				$main
				.ace_scroll('update', {'size': saved_scroll['size'], 'mouseWheelLock': saved_scroll['lock'], 'lockAnyway': saved_scroll['lock_anyway']})
				.ace_scroll('enable')
				.ace_scroll('reset');
			}
			
			if( !nativeScrollbars ) {				
				if(!saved_scroll) $main.ace_scroll('disable');				
			}
			else {
				$main.css('max-height', '').removeClass('overflow-scroll');
			}
		}
	}

})(window.jQuery);

