/* MINIFIED */
'use strict';

var lyr={};;

(
function(){var a,b=navigator.userAgent;function c(a){$('html').addClass(a);}a=document.documentMode;a+=a&&a<=8?' ie-nosupport':'';if((/msie/gi).test(b))c('ie'+a);if((/gecko\//gi).test(b))c('moz');if((/webkit/gi).test(b))c('webkit');if((/macintosh/gi).test(b))c('mac');if((/windows/gi).test(b))c('win');if((/linux/gi).test(b))c('lin');if('ontouchstart' in document.documentElement)c('touch-enabled');})();$(
function(){lyr.wgt.scan(document.body);$(document).trigger(lyr.event.WGTS_INITIALIZED_INITIAL);});if(typeof Mustache!=='undefined')Mustache.tags=['[[',']]'];;

lyr.Wgt=
function(){this._wgts={};};lyr.Wgt.prototype={scan:
function(a){var b;if(arguments.length===0)this.scan(document.documentElement);for(var c=0,d=arguments.length;c<d;c++){var e=$(arguments[c]);b=e.find('[data-wgt]');if(e.attr('data-wgt'))b=b.add(e);for(var f=0,g=b.length;f<g;f++)this._initElementWgts(b[f]);if(lyr.ngScan)lyr.ngScan(e);}},register:
function(a,b){this._wgts[a]=b;},get:
function(a,b){var c;a=$(a);if(!a.length)return false;c=$(a).eq(0).data();if(!c.wgtInstances)return false;if(b)return c.wgtInstances[b]||false;if(this.count(a)===1)return c.wgtInstances[c.wgt];
return c.wgtInstances.length?c.wgtInstances:false;},count:
function(a){var b=0,c=$(a).data('wgtInstances');for(var d in c)if(c.hasOwnProperty(d))b++;
return b;},append:
function(a,b){if(this._wgts[b])return this._construct($(a),b);else throw new Error('Widget undefined: '+b);},_initElementWgts:
function(a){var b,c;a=$(a);b=a.attr('data-wgt');b=b.split(/\s+/);for(var d=0,e=b.length;d<e;d++){c=b[d];if(!c)continue;this.append(a,c);}a.trigger(lyr.event.WGTS_INITIALIZED);},_construct:
function(a,b){var c=this.get(a,b);if(!c){c=new this._wgts[b](a,b);this._register(a,b,c);}return c;},_register:
function(a,b,c){var d=a.data();d.wgtInstances=d.wgtInstances||{};d.wgtInstances[b]=c;}};lyr.wgt=new lyr.Wgt();;

lyr.storage=
function(a,b){if(a===null)return '';switch(arguments.length){case 0:return '';case 1:try{
return JSON.parse(localStorage.getItem(a));}catch(c){localStorage.removeItem(a);}return '';case 2:if(b===null){localStorage.removeItem(a);
return '';}else return localStorage.setItem(a,JSON.stringify(b,null,''));}};try{lyr.storage('foo','bar');lyr.storage('foo',null);}catch(err){console&&console.warn('localStorage is not writable.');lyr.storage=
function(){
return '';};}$.fn.assert=
function(a,b){a=(typeof a==='undefined')?1:a;b=(typeof b==='undefined')?a:b;if(this.length<a||this.length>b){console.warn(this);throw new Error(''+'"'+this.selector+'" should match at least '+a+' and at most '+b+' elements, but matched '+this.length+' elements.');}return this;};lyr.debounce=
function(a,b,c){var d,e,f,g,h;
return function(){f=this;e=arguments;g=new Date().getTime();var i=
function(){var j=new Date().getTime()-g;if(j<b)d=setTimeout(i,b-j);else{d=null;if(!c){h=a.apply(f,e);f=e=null;}}};var j=c&&!d;if(!d)d=setTimeout(i,b);if(j){h=a.apply(f,e);f=e=null;}return h;};};$(document).on('click keyup propertychange paste','input',lyr.debounce(
function(a){if(a.target.type!=='file')$(a.target).trigger('change');},250));lyr.loadScript=
function(a,b){var c;b=b||
function(){};if(-1===$.inArray(lyr._scriptsLoaded,a)){c=document.createElement('script');c.src=a;c.onload=
function(){lyr._scriptsLoaded.push(a);b();};$('head')[0].appendChild(c);}else b();};lyr._scriptsLoaded=[];lyr.randomStr=
function(a){
return Math.random().toString(36).substr(2,a||5);};lyr.randomBetween=
function(a,b){
return a+Math.floor(Math.random()*(b-a+1));};if(!Function.prototype.bind)Function.prototype.bind=
function(a){var b,c,d,e,f;b=Array.prototype.slice.call(arguments,1);c=this;d=
function(){};e=
function(){f=this instanceof d&&a?this:a;
return c.apply(f,b.concat(Array.prototype.slice.call(arguments)));};d.prototype=this.prototype;e.prototype=new d();
return e;};lyr.format={sprintf:
function(){var a=arguments;
return a[0].replace(/\{(\d+)\}/g,
function(b,c){
return typeof a[c]!=='undefined'?a[c]:b;});}};lyr.preloadImage=
function(a,b,c){var d,e,f;d=
function(){};e=c||
function(){throw new Error('Error loading image: '+a);};f=new Image();f.src=a;if(b)d=
function(c){b(a,f.width,f.height,!!c);};if(f.complete)d(true);else{f.onload=d;f.onerror=e;}};lyr.confirm=
function(a,b,c){var d,e=$(),f,g,h,i,j,k;i=new lyr.Lightbox();j=$('<div>');h=$('<h1>').text(a).appendTo(j);g=$('<form>').appendTo(j);d=$('<div>').addClass('buttons').appendTo(g);k=$('<p>').addClass('question');k.html(b).insertAfter(h);if(c.extraButton)c.extraButton.appendTo(d);if(c.cancelButton!==false){e=$('<button>').addClass('cancel').appendTo(d);e.text(c.cancelLabel||'Cancel');e.on('click',
function(){i.close();
return false;});}f=$('<button>').addClass('ok').text(c.okLabel||'OK');f.appendTo(d);f.on('click',
function(){(c.ok||i.close.bind(i))();i.clearCallbacks();i.close();
return false;});$(document).off('keydown.confrm');$(document).on('keydown.confrm',
function(a){switch(a.keyCode){case 27:e.trigger('click');
return false;case 13:f.trigger('click');
return false;}});
return i.open($.extend({html:j,onclose:c.cancel,width:c.width||320,height:c.height||220},c));};lyr.alert=
function(a,b,c){c=$.extend(c||{},{cancelButton:false});lyr.confirm(a,b,c);};lyr.alertUnexpectedServerResponse=
function(a,b){var c={},d=a.title;if(!d)d=b==='error'?'Error':'Message';if(a.redirect)c.onclose=
function(){location.replace(a.redirect);};if(a.ok_label)c.okLabel=a.ok_label;lyr.alert(d,a.message,c);};lyr.LightboxTrigger=
function(a){this.element=a;this.element.on('click',this.openLightbox.bind(this));this.handleJson();};lyr.LightboxTrigger.prototype={handleJson:
function(){var a=[lyr.event.LIGHTBOX_AJAX_SUCCESS,lyr.event.LIGHTBOX_AJAX_ERROR].join(' ');$(document).off(a).on(a,
function(a,b){this.report(a,b,a.type===lyr.event.LIGHTBOX_AJAX_ERROR?'error':'message');}.bind(this));},report:
function(a,b,c){lyr.lightbox.closeLast();lyr.alertUnexpectedServerResponse(b,c);},setupLightbox:
function(){var a=this.element.data();if(a.offsetObj==='this')a.offsetObj=this.element;
return a;},openLightbox:
function(){this.lightbox=new lyr.Lightbox();this.lightbox.open(this.setupLightbox());
return false;}};lyr.wgt.register('lightbox',lyr.LightboxTrigger);;

$.ajaxSetup({error:
function(a,b,c){if(!c)try{c=JSON.parse(a.responseText).message;}catch(d){}if(b==='abort')return false;else if(c)lyr.alert('Error',c);else if(a.status===403)lyr.alert('No access','We’re sorry, you do not have access to this functionality.');else if(a.status===404)lyr.alert('Page not found','We’re sorry, we could not find the page. Please try again later.');else if(a.status===500)lyr.alert('Server Error','We’re sorry, we encountered a server error while processing your request. We will look into this. Please try again later.');else if(b==='parsererror')lyr.alert('Parse Error','We’re sorry, we were unable to process this request. Please try again later.');else if(b==='timeout')lyr.alert('Timeout Error','We’re sorry, the page did not load in time. Please try again later.');},crossDomain:false,beforeSend:
function(a,b){if(String(b.type)!=='GET')a.setRequestHeader('X-CSRFToken',$.cookie('csrftoken'));}});lyr.AjaxSubmit=
function(a){this.element=a;this.buttons=this.element.find('.buttons');if(!this.buttons.length)this.buttons=this.element;this.options={forceSync:false,success:this.handleJsonResponse.bind(this),error:this.handleError.bind(this),beforeSerialize:this.beforeSerialize.bind(this),beforeSubmit:this.beforeSubmit.bind(this)};this.element.ajaxForm(this.options);};lyr.AjaxSubmit.prototype={submit:
function(){this.element.ajaxSubmit(this.options);},beforeSerialize:
function(a,b){a.trigger(lyr.event.FORM_BEFORE_SUBMIT,[b]);},beforeSubmit:
function(a,b,c){b.trigger(lyr.event.FORM_SUBMIT,[a,c]);this.toggleLoading(true);},handleError:
function(a,b){this.toggleLoading(false);this.element.trigger(lyr.event.FORM_SERVER_ERROR,[a,b]);$.ajaxSettings.error(a,b);},handleJsonResponse:
function(a){if(typeof a==='string')try{a=JSON.parse(a);}catch(b){this.handleError({},'parsererror');
return false;}this.toggleLoading(false);if($.isEmptyObject(a.errors)&&!a.error)this.success(a);else if(a.error&&a.message){this.element.trigger(lyr.event.FORM_ERROR,[a.message]);lyr.alertUnexpectedServerResponse(a,'error');}else this.showFormErrors(a);},success:
function(a){this.element.trigger(lyr.event.FORM_SUCCESS,[a]);},toggleLoading:
function(a){lyr.toggleLoading(this.buttons,a);},showFormErrors:
function(a){var b={};for(var c in a.errors)if(a.errors.hasOwnProperty(c))b[c]=a.errors[c].join('<br>');this.element.trigger(lyr.event.FORM_ERRORS,[a,b]);}};lyr.wgt.register('ajaxsubmit',lyr.AjaxSubmit);;

lyr.gaq={};lyr.gaq.CATEGORY={};lyr.gaq.ACTION={};(
function(a,b){a.ERROR='Error';a.FORM='Form';a.UPGRADE='Upgrade';a.VERIFY_ACCOUNT='Verify Account';b.VIEW='View';b.SUBMIT='Submit';b.SAVE='Save';b.CANCEL='Cancel';b.DIRTY_CANCEL='Dirty Cancel';b.CLOSE='Close';b.SUCCESS='Success';b.ERROR='Error';a.NEWSLETTER_SUBSCRIPTIONS='Newsletter Subscriptions';a.NEWSLETTER_SUBSCRIBE='Subscribe';a.NEWSLETTER_UNSUBSCRIBE='Unsubscribe';a.BUNDLE_LIGHTBOX='Purchase Bundle Lightbox';a.PUBLISH_LIGHTBOX='Publish Lightbox';a.PUBLISH='Publish';a.PAY_UNPUBLISHED='Pay Unpublished Pages';a.REPUBLISH_EXPIRED='Republish Expired';a.EXTEND='Extend';b.DEDUCT='Deduct Credits';b.CHECKOUT='Proceed to Checkout';b.VERIFY='Verify';b.CONTACT_SALES='Contact Sales';b.PICK_BASIC='Pick Basic';b.PICK_PRO_CREDITS='Pick Pro Credits';b.PICK_PRO_BUNDLE='Pick Pro Bundle';b.PICK_PRO_PAGES='Pick Pro Pages';a.CREATOR='Creator';a.CAMPAIGN_OVERVIEW='Campaign Overview Page';a.PAGE_EDITOR='Editor Page';a.CARD='Card';a.FILTER='Filter';a.SETTINGS='Settings';a.VIEW='View';a.EDIT='Edit';a.COLLABORATE='Collaborate';a.PROMOTE='Promote';a.STATS='Stats';a.TEST='Test';b.CLICK_$1='Click: {1}';b.CLICK_TAB_$1='Click Tab: {1}';a.NEW_CAMPAIGN_FORM='New Campaign Form';a.CAMPAIGN_ITEM='Campaign Item';a.CAMPAIGN_PUBLISHED_LIGHTBOX='Campaign Published Lightbox';a.INCLUDE_PAGES='Include Pages';a.CUSTOM_BUTTONS='Custom Buttons';a.ADVANCED_BUTTONS='Advanced Buttons';b.GRID_$1='Toggle Grid {1}';a.WIDGET='Widget';b.ANIMATION_$1='Animation: {1}';a.UPLOAD_PAGES='Upload Pages';b.JPG='JPG';b.PNG='PNG';b.PDF='PDF';b.ZIP='ZIP';a.MY_LAYERS='My Layers';a.OVERVIEW='Overview';a.ADROLL='Adroll';b.ADROLL_RECORD_USER='record_user';b.ADROLL_NOT_DEFINED='not defined';})(lyr.gaq.CATEGORY,lyr.gaq.ACTION);;

lyr.gaq.logError=
function(a,b,c){if(!$('html').hasClass('ie-nosupport'))if(a&&b)lyr.gaq.trackEvent('Exception',a+' — '+location.pathname,b+'#'+c);
return false;};window.onerror=lyr.logError;lyr.gaq.replaceCategoryKeys=
function(a){var b=a.split(' ');for(var c=0,d=b.length;c<d;c++){var e=lyr.gaq.CATEGORY[b[c]];if(!e){console.error('Invalid tracking category: '+b[c]);
return [];}else b[c]=e;}return b;};lyr.gaq.replaceActionKeys=
function(a){var b=lyr.gaq.ACTION[a];if(!b)console.error('Invalid tracking action: '+a);
return b;};lyr.gaq.trackEvent=
function(a,b,c,d,e){if(a instanceof Array)a=a.join(', ');else if((/^[A-Z0-9_ ]+$/g).test(a))a=lyr.gaq.replaceCategoryKeys(a).join(', ');if((/^[A-Z0-9_]+$/g).test(b))b=lyr.gaq.replaceActionKeys(b);d=(typeof d==='undefined')?null:Math.round(d);if(typeof c==='undefined')c=null;if(typeof e==='undefined')e=false;if(typeof ga!=='undefined')ga('send','event',{eventAction:b,eventCategory:a,eventLabel:c,eventValue:d,nonInteraction:e});};$(
function(){$(document).on('click.gaq','a',
function(a){if(a.currentTarget.hostname&&a.currentTarget.hostname!==window.location.hostname){lyr.gaq.trackEvent('Outbound',a.currentTarget.href,location.pathname);if(!(a.metaKey||a.ctrlKey)&&!a.target){a.preventDefault();setTimeout(
function(){location.href=a.currentTarget.href;}.bind(this),lyr.gaq.persistent.delay+10);}}});});lyr.gaq.trackLightboxEvents=
function(a,b){var c=lyr.lightbox.get(a),d=new Date();lyr.gaq.trackEvent(b,'VIEW');if(c){c.lightbox.off(lyr.event.LIGHTBOX_USER_CLOSE+'.gaq');c.lightbox.on(lyr.event.LIGHTBOX_USER_CLOSE+'.gaq',
function(){var a=(new Date()-d)/1000;lyr.gaq.trackEvent(b,'CLOSE',null,a);});}a.on(lyr.event.FORM_SUBMIT,
function(){var a=(new Date()-d)/1000;d=new Date();lyr.gaq.trackEvent(b,'SUBMIT',null,a);});a.on(lyr.event.FORM_SUCCESS,
function(){var a=(new Date()-d)/1000;lyr.gaq.trackEvent(b,'SUCCESS',null,a);});a.on(lyr.event.FORM_ERROR,lyr.event.FORM_ERRORS,
function(){lyr.gaq.trackEvent(b,'ERROR',null,0);});a.on(lyr.event.FORM_SERVER_ERROR,
function(){lyr.gaq.trackEvent(b,'ERROR',null,1);});};;

lyr.event={AUTHBOX_LOG_IN:'AUTHBOX_LOG_IN',BILLING_ADDRESS_SAVED:'BILLING_ADDRESS_SAVED',FORM_SERVER_ERROR:'FORM_SERVER_ERROR',FORM_ERROR:'FORM_ERROR',FORM_ERRORS:'FORM_ERRORS',FORM_BEFORE_SUBMIT:'FORM_BEFORE_SUBMIT',FORM_SUBMIT:'FORM_SUBMIT',FORM_SUCCESS:'FORM_SUCCESS',INSPIRE_MASONRY_REFRESH:'INSPIRE_MASONRY_REFRESH',INSPIRE_MASONRY_BUILT:'INSPIRE_MASONRY_BUILT',INLINE_UPLOAD_501:'INLINE_UPLOAD_501',INLINE_UPLOAD_ERROR:'INLINE_UPLOAD_ERROR',INLINE_UPLOAD_PICKED:'INLINE_UPLOAD_PICKED',INLINE_UPLOAD_SUCCESS:'INLINE_UPLOAD_SUCCESS',LIGHTBOX_AJAX_ERROR:'LIGHTBOX_AJAX_ERROR',LIGHTBOX_AJAX_SUCCESS:'LIGHTBOX_AJAX_SUCCESS',LIGHTBOX_CLOSE:'LIGHTBOX_CLOSE',LIGHTBOX_USER_CLOSE:'LIGHTBOX_USER_CLOSE',LIGHTBOX_OPEN:'LIGHTBOX_OPEN',LIVE:'keydown keyup paste change',WGTS_INITIALIZED:'WGTS_INITIALIZED',WGTS_INITIALIZED_INITIAL:'WGTS_INITIALIZED_INITIAL'};;

lyr.toggleLoading=
function(a,b){var c,d,e,f;a=$(a).toggleClass('is-loading',b);if(!a.length)return;e=a.find('button, .button');e.attr('disabled',b);c=e.last().parent();d=c.find(e).first();f=c.find('.loading').stop();if(e.length===1){e.toggleClass('loading',b);
return;}for(var g=0,h=e.length;g<h;g++){var i=e.eq(g);if(!i.data('loading-label'))continue;else if(!i.data('default-label'))i.data('default-label',e.eq(g).text());i.text(i.data(b?'loading-label':'default-label'));}if(!f.length){f=$('<span/>').addClass('loading').css({opacity:0});f.insertBefore(d);}if(b)f.animate({opacity:1},200);else f.animate({opacity:0},200,
function(){$(this).remove();});};lyr.DatePicker=
function(a){var b=$.extend(this.getDefaultSettings(),a.data());a.attr('readonly',true);a.css({cursor:'pointer'});a.datepicker(b).val(this.getDefaultDate(b));this.element=a;};lyr.DatePicker.prototype={getDefaultSettings:
function(){
return{firstDay:1,altFormat:$.datepicker.ATOM,dateFormat:'d M yy',showAnim:false,changeMonth:true,changeYear:true,onSelect:this.onSelect.bind(this)};},getDefaultDate:
function(a){var b;if(a.altField&&$(a.altField).val()){b=$.datepicker.parseDate(a.altFormat,$(a.altField).val());
return $.datepicker.formatDate(a.dateFormat,b);}else return null;},onSelect:
function(a){var b=this.element.data('daterange');if(b)this.setRangeLimitations(b,a);},setRangeLimitations:
function(a,b){var c=$($(this.element.data('daterange-with'))),d=(a==='start')?'minDate':'maxDate';c.datepicker('option',d,b);}};lyr.wgt.register('date',lyr.DatePicker);lyr.ValidateForm=
function(a){this.element=a;this.jqValidator=a.validate(this.getValidationSettings());this.supportDomAutocomplete();this.addRequiredValidation();this.displayServerErrors();this.bindEvents();};lyr.wgt.register('validate',lyr.ValidateForm);lyr.ValidateForm.prototype={globalRules:{},bindEvents:
function(){this.element.on(lyr.event.FORM_ERRORS,
function(a,b,c){this.showErrors(c);}.bind(this));this.element.on('submit',
function(){this.element.find('.global-error').remove();}.bind(this));},getValidationSettings:
function(){var a=this.validateSettings;
return $.extend(a,this.getDataValidateSettings(this.element.data('rules')));},getDataValidateSettings:
function(a){var b={};if(a){b=this.globalRules[a];if(!b)throw new Error('Undefined validate settings set: '+a);}return b;},validateSettings:{highlight:
function(a,b,c){var d=$(a);d=(d.hasClass('checkbox-enable-field'))?d.closest('input'):d.closest('.item');d.addClass(b).removeClass(c);},unhighlight:
function(a,b,c){var d=$(a);d=(d.hasClass('checkbox-enable-field'))?d.closest('input'):d.closest('.item');d.removeClass(b).addClass(c);},errorPlacement:
function(a,b){var c=(b.hasClass('checkbox-enable-field'))?b.parents('.checkbox-enable-field-wrap:first'):b.parents('.wrap:first'),d=c.find('.help:first');if(c.length&&d.length)a.insertBefore(d);else if(c.length)a.appendTo(c);else a.insertAfter(b);}},supportDomAutocomplete:
function(){this.element.on('DOMAutoComplete',':input',
function(){$(this).trigger('change');});},addRequiredValidation:
function(){var a=this.element.find('.item.required');for(var b=0,c=a.length;b<c;b++){var d=a.eq(b);d.find('.wrap :input:first').prop('required',true);}},displayServerErrors:
function(){var a=this.element.find('.item');for(var b=0,c=a.length;b<c;b++){var d=a.eq(b);if(d.data('errors'))this.showErrors(d.data('errors'));}},showErrors:
function(a){var b;if(a.__all__){b=$('<div>').addClass('error global-error');b.html(a.__all__);b.insertBefore(this.element.find('.item:first'));delete a.__all__;}this.jqValidator.showErrors(a);}};lyr.AutofocusInput=
function(a){var b,c,d;b=a.find('input, textarea, select');c=b.not('[autocomplete]').filter(':visible:first');d=c.val();if(c.attr('type')!=='file'){try{c.trigger('focus').addClass('autofocus');}catch(e){}try{c[0].setSelectionRange(d.length,d.length);}catch(e){}}};lyr.wgt.register('autofocus',lyr.AutofocusInput);lyr.ResendVerificationMail=
function(a){a.on('click',$.proxy(
function(){a.parent().load(a.attr('href'));a.parent().text('Resending verification email…');
return false;},this));};lyr.wgt.register('acc-resend',lyr.ResendVerificationMail);;

lyr.Tooltip=
function(a,b,c,d){var e,f,g;this.element=a;if(!a.attr('title'))a.attr('title','');e=lyr.event.LIGHTBOX_OPEN+'.'+this.name;f=this.openTooltip.bind(this);g=this.positionTooltip.bind(this);this.position=(c||'north');this.positions={north:{my:'center top',at:'center bottom'},'north-west':{my:'left top',at:'center bottom'},east:{my:'right center',at:'left center'},south:{my:'center bottom',at:'center top'},'south-east':{my:'right bottom',at:'center top'},west:{my:'left center',at:'right center'}};$(document).off(e).on(e,this.closeOtherTooltips.bind(this));this.settings={show:false,hide:false,content:b,open:f,position:{my:this.positions[this.position].my,at:this.positions[this.position].at,using:g,collision:'flipfit'},tooltipClass:'lyr-tooltip'};if(d)$.extend(this.settings,d);this.element.tooltip(this.settings);this.element.on('mouseleave',this.mouseLeave.bind(this));};lyr.Tooltip.prototype={openTooltip:
function(a,b){var c=b.tooltip;this.closeOtherTooltips();if(!this.snappy){c.on('mouseenter',this.haltTimer.bind(this));c.on('mouseleave',this.closeTooltip.bind(this));}},closeOtherTooltips:
function(){var a=$('[data-wgt$=tooltip]').not(this.element);for(var b=0,c=a.length;b<c;b++){var d=lyr.wgt.get(a[b],this.name);if(d)d.closeTooltip();}},positionTooltip:
function(a,b){var c,d;c=b.element.element;d=(this.position==='east'||this.position==='west');if(d)this.positionHorizontalTooltip(b,a);else this.positionVerticalTooltip(b,a);c.css({left:a.left,top:a.top,marginRight:20});c.addClass('pos-'+b.horizontal+'-'+b.vertical);c.toggleClass('pad',(c.height()<=20));},positionHorizontalTooltip:
function(a,b){b.top-=8;switch(a.horizontal){case 'left':b.left+=6;break;case 'right':b.left-=10;break;}},positionVerticalTooltip:
function(a,b){var c,d=24,e,f,g;c=a.target.left+(a.target.width/2);e=c-a.element.width+d;f=c-d;g=((a.element.left+a.element.width)>=$(document).width())||(e<0);switch(a.horizontal){case 'left':if(!g)b.left=e;else{a.horizontal='left';b.left=d;}break;case 'right':b.left=f-a.element.width;break;case 'center':if(g){b.left=e;a.horizontal='left';}else b.left+=4;break;}switch(a.vertical){case 'top':b.top+=6;break;case 'bottom':b.top-=24;break;}},mouseLeave:
function(a){if(this.snappy)this.closeTooltip();else{a.stopImmediatePropagation();this.hideTooltip=setTimeout(this.closeTooltip.bind(this),200);}},destroy:
function(){clearTimeout(this.hideTooltip);this.element.tooltip('destroy');this.element=$();},closeTooltip:
function(){this.element.tooltip().tooltip('close');},haltTimer:
function(){clearTimeout(this.hideTooltip);}};lyr.wgt.register('tooltip',lyr.Tooltip);;

(
function(){var a=0;$(document).on('keyup',
function(b){if(b.keyCode===67&&!$(':focus').is(':input')){if(++a===5){new Audio('http://static511.layar.com.s3.amazonaws.com/2013layar/select.mp3').play();$('*').css({fontFamily:'comic sans ms, papyrus, fantasy'});}window.setTimeout(
function(){a=0;},1000);}else a=0;});})();lyr.Captcha=
function(a){var b=$('head')[0];this.element=a;this.pubkey=a.data('pubkey');if(typeof Recaptcha==='undefined'){var c=document.createElement('script');c.src='//www.google.com/recaptcha/api/js/recaptcha_ajax.js';c.onload=this.showCaptchaImage.bind(this);b.parentNode.insertBefore(c,b);}else this.showCaptchaImage();};lyr.Captcha.prototype={showCaptchaImage:
function(){Recaptcha.create(this.pubkey,this.element[0],{theme:'white'});}};lyr.wgt.register('captcha',lyr.Captcha);lyr.ReportSaved=
function(a){this.element=a;this.buttons=a.find('.buttons:last');a.on(lyr.event.FORM_SUCCESS,this.report.bind(this));};lyr.ReportSaved.prototype={report:
function(a,b){var c,d=this.element.data('close-after-submit');this.buttons.find('.form-success').remove();c=$('<span>').addClass('form-success').css({opacity:0});c.text(b.message||'Successfully saved the form!');c.prependTo(this.buttons);c.animate({opacity:1},200);if(d)this.buttons.find('button').prop('disabled',true);window.setTimeout(
function(){c.fadeOut(200,
function(){if(d)lyr.lightbox.get(a.currentTarget).close();else c.remove();});},4000);}};lyr.wgt.register('reportsaved',lyr.ReportSaved);lyr.RestrictListHeight=
function(a){var b,c=a.height();if(c>140){a.css({height:111,overflow:'hidden'});b=$('<a href="#expand">View more…</a>');b.css({position:'relative',top:-22});b.insertAfter(a);b.on('click',
function(){a.animate({height:c});b.hide();
return false;});}};lyr.wgt.register('restrict-height',lyr.RestrictListHeight);lyr.FAQ=
function(a){var b,c,d,e;this.questions=a.find('a');for(var f=0,g=this.questions.length;f<g;f++){b=$(this.questions[f]);e=b.attr('href').substring(1);c=$('[name="'+e+'"]').next('p');c.find('strong').remove();c.hide().insertAfter(b);}this.questions.on('click',
function(){$(this).next('p').toggle();
return false;});};lyr.wgt.register('faq',lyr.FAQ);lyr.RemarketingBanner=
function(a){var b='remarketing.banner.closed';if(lyr.storage(b))a.remove();else{a.addClass('show');a.on('click',
function(c){if($(c.target).not('a')){a.addClass('animate').removeClass('show');lyr.storage(b,true);}}.bind(this));}};lyr.wgt.register('remarketing-banner',lyr.RemarketingBanner);;"use strict";lyr.adroll={};lyr.adroll.customData={LOGGED_IN:{'type':'loggedin'}};lyr.adroll.recordUser={};lyr.adroll.recordUser.segments={'BUY_NOW':{'adroll_segments':'buynow'},'BUNDLE':{'adroll_segments':'bundle'}};lyr.adroll.recordUser.trigger=
function(a,b){b.on('click',c);function c(){var c=a.adroll_segments;try{__adroll.record_user(a);lyr.gaq.trackEvent('ADROLL','ADROLL_RECORD_USER',c);}catch(d){console.warn(d,a,b);lyr.gaq.trackEvent('ADROLL','ADROLL_NOT_DEFINED',c);}}};lyr.adroll.triggers={};lyr.adroll.triggers.buyNow=
function(a){lyr.adroll.recordUser.trigger(lyr.adroll.recordUser.segments.BUY_NOW,a);};lyr.wgt.register('adroll-trigger-buy-now',lyr.adroll.triggers.buyNow);lyr.adroll.triggers.bundle=
function(a){lyr.adroll.recordUser.trigger(lyr.adroll.recordUser.segments.BUNDLE,a);};lyr.wgt.register('adroll-trigger-bundle',lyr.adroll.triggers.bundle);;

lyr.Lightbox=
function(){this.selector='.'+this.ns+'lightbox';};lyr.Lightbox.prototype={ns:'lyr-lb-',settings:{id:'',url:'',html:'',dom:'',width:750,height:'auto',addClass:'',closeButton:true,vitrage:true,vitrageOpacity:0.6,vitrageClick:'close',fadeIn:500,fadeOut:300,offsetObj:false,offsetX:3,offsetY:3,left:false,top:false,windowPadding:30,animateOnResize:true,isDraggable:false,onopen:false,onclose:false},open:
function(a){if(typeof a==='string')a={html:a};this.iSettings=$.extend({},this.settings,a);this.vitrage=$();if(this.iSettings.vitrage)this.vitrage=this._addVitrage();this.lightbox=this._addLightbox();this.makeDraggable();this.content(this._getContent(),this.iSettings.url);this.setPosition();this._addCloseTriggers();$(window).on('resize',this.setPosition.bind(this));
return this;},close:
function(){if(!this.lightbox)return;if(this.xhr)this.xhr.abort();this.lightbox.remove();this.vitrage.fadeOut(this.iSettings.fadeOut,
function(){$(this).remove();});if(this.iSettings.onclose){this.iSettings.onclose(this.lightbox);this.clearCallbacks();}$(document).trigger(lyr.event.LIGHTBOX_CLOSE,[this.lightbox]);},closeAll:
function(){for(var a=$(this.selector).length;a>0;a--)this.closeLast();},closeAllButFirst:
function(){for(var a=$(this.selector).length;a>1;a--)this.closeLast();},closeLast:
function(){
return $(this.selector).last().data('lightbox').close();},anyOpen:
function(){
return(0!==$(this.selector).length);},get:
function(a){
return $(a).closest(this.selector).data('lightbox');},content:
function(a,b){var c=$(),d;$(':focus:not(body)').blur();if(typeof a==='string')a=$($.trim(a));c=a.filter('script[src]');d=
function(){if(this.contentWrap.closest('body').length){this.contentWrap.html(a.not('script[src]'));lyr.wgt.scan(this.contentWrap);}if(!b&&this.iSettings.animateOnResize)window.setTimeout(
function(){this.lightbox.addClass('canhasanim');}.bind(this),500);}.bind(this);(function e(a){if(a===c.length)d();else lyr.loadScript(c[a].src,
function(){e(++a);});})(0);},width:
function(a){this.iSettings.width=a;this.lightbox.css({width:a});},clearCallbacks:
function(){this.iSettings.onclose=this.iSettings.onopen=false;},userClose:
function(){this.lightbox.trigger(lyr.event.LIGHTBOX_USER_CLOSE);this.close();},_addCloseTriggers:
function(){var a=this.closeButton;if(this.vitrage&&this.iSettings.vitrageClick==='close')a=a.add(this.vitrage);a.on('click',this._handleCloseClick.bind(this));},_handleCloseClick:
function(){this.userClose();
return false;},_addVitrage:
function(){var a;a=$('<div>').appendTo('body').css({opacity:0});a.addClass('vitrage '+this.ns+'vitrage');a.fadeTo(this.iSettings.fadeIn,this.iSettings.vitrageOpacity);
return a;},_addLightbox:
function(){var a,b;this.contentWrap=$('<div>').addClass(this.ns+'content');this.closeButton=$();if(this.iSettings.closeButton)this.closeButton=$('<div>').addClass(this.ns+'close').text('×');a=$('<section>').data({lightbox:this}).attr({id:this.iSettings.id}).addClass(this.ns+'lightbox').addClass(this.iSettings.addClass).append(this.closeButton,this.contentWrap).appendTo('body').css({opacity:0});
return a;},setPosition:
function(){var a,b,c,d,e,f,g,h={},i=this.iSettings||{},j=$(window).width(),k=$(window).height(),l=i.windowPadding,m=$('html').scrollTop()||$('body').scrollTop();this.lightbox.css('width','');c=(i.width==='auto')?this.lightbox.width():i.width;d=(i.height==='auto')?this.lightbox.height():i.height;if(i.offsetObj&&$(i.offsetObj).length){e=$(i.offsetObj);b=e.offset();a={width:c,height:d,left:e.width()+b.left+parseFloat(i.offsetX),top:e.height()+b.top+parseFloat(i.offsetY)};}else{h={left:(j/2)-(c/2),top:(m+(k/2))-(d/1.8)};a={width:c,height:d,left:(i.left!==false)?i.left:h.left,top:(i.top!==false)?m+i.top:h.top};}f=(a.left+a.width)-(j-10);g=(a.top+a.height)-(m+k-l);if(f>0)a.left-=f;if(g>0)a.top-=g;a.left=Math.max(l,a.left);a.top=Math.max(l,a.top);if(a.height>k)a.top=m+l;a=$.extend(a,{opacity:1,height:'auto'});this.lightbox.css(a);},_getContent:
function(){var a='',b=this.iSettings;if(b.dom&&$(b.dom).length)a=$(b.dom).clone(false).html();else if(b.url){a=$('<div>').addClass(this.ns+'loading');this.xhr=$.ajax(b.url,{success:this._ajaxSuccess.bind(this),error:this._ajaxError.bind(this)});}else if(b.html)a=b.html;
return a;},_ajaxSuccess:
function(a){if(typeof a==='string'){this.content(a);this.setPosition();}else if($.isPlainObject(a)){var b=(a.error)?lyr.event.LIGHTBOX_AJAX_ERROR:lyr.event.LIGHTBOX_AJAX_SUCCESS;$(document).trigger(b,[a,this]);}this.xhr=null;},_ajaxError:
function(a,b){this.clearCallbacks();this.close();this.xhr=null;$.ajaxSettings.error(a,b);},makeDraggable:
function(){if($.ui&&this.iSettings.isDraggable)this.lightbox.draggable({containment:'body',handle:'h1',cursor:'move',start:this.dragStart.bind(this),stop:this.dragEnd.bind(this)});},dragStart:
function(){if(this.lightbox.hasClass('ui-draggable'))this.lightbox.removeClass('canhasanim');},dragEnd:
function(){if(this.lightbox.hasClass('ui-draggable'))this.lightbox.addClass('canhasanim');}};lyr.lightbox=new lyr.Lightbox();lyr.LightboxYoutube=
function(a){this.element=a;this.embedCode=this.element.data('embed');a.on('click',
function(){if('ontouchstart' in document.documentElement)return this.open(this.embedCode,'100%','mobile-video-container');else return this.open(this.embedCode,this.element.data('width')||960);}.bind(this));};lyr.LightboxYoutube.prototype={open:
function(a,b,c){lyr.lightbox.open({html:a,width:b,windowPadding:0,top:80,addClass:'no-padding '+c});
return false;}};lyr.wgt.register('lightbox-youtube',lyr.LightboxYoutube);lyr.LightboxImage=
function(a){this.element=a;a.on('click',
function(){var b=a.data('src'),c=a.data('width'),d=a.data('alt'),e;e=$('<img>').attr('src',b).attr('alt',d);lyr.lightbox.open({html:e,windowPadding:0,top:80,width:c,addClass:'no-padding'});
return false;}.bind(a));};lyr.wgt.register('lightbox-image',lyr.LightboxImage);