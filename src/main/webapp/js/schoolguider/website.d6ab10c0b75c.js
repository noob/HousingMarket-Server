/* MINIFIED */
'use strict';

lyr.modal=angular.module('lyr.modal',[]);lyr.modal.factory('modalProvider',['$rootScope','$compile','$timeout',
function(){var a=arguments;
return{open:
function(b){var c;c=new lyr.modal.Modal(b);c.inject.apply(c,a);c.construct();
return c;}};}]);lyr.modal.Modal=
function(a){this.options=$.extend({},this.defaults,a);};lyr.modal.Modal.prototype={defaults:{addClass:'',appendTo:'body',width:'auto',height:'auto',position:'center',shift:{left:0,top:0},vitrageClose:true,vitrage:true,closeButton:true,show:true,template:null,templateUrl:null,controller:null,scope:null},inject:
function(a,b,c){this.$rootScope=a;this.$compile=b;this.$timeout=c;},construct:
function(){this.element=$('<dialog open>');this.element.addClass('modal modal-constructing');this.element.addClass(this.options.addClass);this.element.attr('ng-show','modal.show');this.element.attr('ng-class','{transparent: modal.transparent}');if(this.options.vitrage){this.vitrage=$('<del>');this.vitrage.addClass('modal-vitrage');if(this.options.vitrageClose)this.vitrage.attr('ng-click','modal.close()');}else this.vitrage=$();this.defineScope();this.addController();this.addContent();this.addCloseButton();this.vitrage.appendTo(this.options.appendTo);this.element.appendTo(this.options.appendTo);this.$compile(this.vitrage)(this.$scope);this.$compile(this.element)(this.$scope);this.$timeout(
function(){this.vitrage.addClass('modal-vitrage-show');this.element.removeClass('modal-constructing');this.position();}.bind(this));},destruct:
function(){this.$scope.modal=null;this.element.remove();this.vitrage.addClass('modal-vitrage-hide');this.$timeout(
function(){this.vitrage.remove();}.bind(this),1000);},defineScope:
function(){var a={show:this.options.show,position:this.position.bind(this),destruct:this.destruct.bind(this),close:this.destruct.bind(this)};this.$scope=this.options.scope||this.$rootScope.$new(true);this.$scope.modal=angular.extend(a,this.$scope.modal||{});this.$scope.$watch('modal.loading',this.position.bind(this));},addCloseButton:
function(){if(this.options.closeButton){this.closeButton=$('<a>').addClass('modal-close').html('&times;');this.closeButton.attr('ng-click','modal.close()');this.closeButton.attr('ng-if','!modal.confirmClose');this.closeButton.appendTo(this.element);}},getPositionFn:
function(a){if(typeof a==='function')return a;else if(a==='center')return function(a,b,c){
return{left:'50%',top:'40%',marginLeft:a*-0.5+c.left,marginTop:b*-0.4+c.top};}.bind(this);else if(typeof a==='string'||a instanceof jQuery)return function(b,c,d){var e=$(a).assert(),f=e.offset();
return{left:f.left+e.width()+d.left,top:f.top+e.height()+d.top};};else if(typeof a==='object')return function(){
return a;};},position:
function(){var a,b=this.getPositionFn(this.options.position);this.element.css({position:'absolute',width:this.options.width,height:this.options.height});a=b(this.element.width(),this.element.height(),this.options.shift);this.element.css(a);},addController:
function(){if(this.options.controller)this.element.attr('ng-controller',this.options.controller);},addContent:
function(){this.content=$('<div>').addClass('modal-content');if(this.options.template)this.content.html(this.options.template);else if(this.options.templateUrl){this.$scope.modal.loading=true;this.content.attr('ng-class','{loading: modal.loading}');this.content.attr('ng-include',JSON.stringify(this.options.templateUrl));this.content.attr('onload','modal.loading=false');}this.element.append(this.content);}};;

lyr.websiteApp=angular.module('lyr.website',['lyr.modal']);;

lyr.websiteApp.controller('pricing',['$scope','$location','modalProvider',
function(a,b,c){var d=a.pricing={premium_month:true};function e(a){var b=a.toUpperCase().replace(/[^A-Z]/g,'');for(var c=0,e=d.currencies.length;c<e;c++)if(d.currencies[c].key===b)return d.currencies[c];}a.$watch('pricing.currencies',
function(){d.selected=(e(b.path())||e(d.user_detect));b.path(d.selected.key);});a.openBundlesModal=
function(b){c.open({templateUrl:b,scope:a,addClass:'pricing-bundles-modal'});};}]);;

lyr.websiteApp.directive('lyrAddsearchLoad',[
function(){
return function(a,b,c){var d=location.hash.match(/addsearch=(.*)/);if(d){a.addsearch.showForm=true;a.addsearch.modelValue=d[1];}};}]);;

lyr.websiteApp.directive('lyrDocumentClick',['$document',
function(a){
return function(b,c,d){a.on('click',
function(a){if(0===$(a.target).closest(d.lyrDocumentClickExclude).length){b.$eval(d.lyrDocumentClick);b.$apply();}});};}]);;

lyr.Fader=
function(a){this.element=a;this.navigation=this.element.find('.fader-nav');this.navigationItemTpl=this.navigation.find('li');this.articles=this.element.find('article');this.activeIndex=0;this.isBusy=false;this.fadeSpeed=200;this.createNavigation();this.setBackgroundHeight();this.setupActiveItems();this.bindEvents();};lyr.Fader.prototype={createNavigation:
function(){var a,b,c;for(var d=0,e=this.articles.length;d<e;d++){b=$(this.articles[d]);a=b.find('h3').html();c=this.navigationItemTpl.clone();c.find('a').html(a);this.navigation.append(c);}this.navigationItemTpl.remove();},setBackgroundHeight:
function(){var a=40,b=120,c=0,d;for(var e=0,f=this.articles.length;e<f;e++){d=$(this.articles[e]).outerHeight();c=(d>c)?d:c;}this.element.css('height',(c+b+a)+'px');},setupActiveItems:
function(){this.articles.eq(0).show();this.navigation.find('li').eq(0).addClass('selected');},bindEvents:
function(){this.navigation.on('click','a',
function(a){a.preventDefault();var b=$(a.currentTarget).parent('li').index();this.fadeTo(b);}.bind(this));},fadeTo:
function(a){if(a===this.activeIndex||this.isBusy)return;this.isBusy=true;this.navigation.find('.selected').removeClass('selected');this.navigation.find('li').eq(a).addClass('selected');this.articles.eq(this.activeIndex).fadeOut(this.fadeSpeed,
function(){this.articles.eq(a).fadeIn(this.fadeSpeed,
function(){this.activeIndex=a;this.isBusy=false;}.bind(this));}.bind(this));}};lyr.wgt.register('fader',lyr.Fader);;

lyr.Msnry=
function(a){this.element=a;this.reorderTiles();this.doMasonry();this.kickTheTiles();$(document).on(lyr.event.INSPIRE_MASONRY_REFRESH,this.doMasonry.bind(this));};lyr.Msnry.prototype={reorderTiles:
function(){var a=this.element.find('.temporary-tile'),b=[];this.buildTheNewWall(a,b);a.remove();this.attachTheNewWall(b);},buildTheNewWall:
function(a,b){var c=0,d=[];for(var e=0,f=a.length;e<f;e++){var g=$(a[e]);if(c%2===0){if(d.length>0){b.push(d.pop());c+=2;}b.push(g);if(!g.hasClass('s'))c++;c++;}else if(!g.hasClass('s'))d.push(g);else{b.push(g);c++;}}if(d.length>0)for(var h=0,i=d.length;h<i;h++)b.push(d.pop());},attachTheNewWall:
function(a){for(var b=0,c=a.length;b<c;b++){$(a[b]).removeClass('temporary-tile').addClass('tile');this.element.append(a[b]);}this.element.find('.tile').show();},doMasonry:
function(){this.element.masonry();},kickTheTiles:
function(){$(document).trigger(lyr.event.INSPIRE_MASONRY_BUILT);}};lyr.wgt.register('msnry',lyr.Msnry);lyr.MsnryFilter=
function(a){var b=window.location.hash.substring(1);this.selector=a.find('select');this.selector.on('change',this.selectorChanged.bind(this));$(document).on(lyr.event.INSPIRE_MASONRY_BUILT,this.updateSelector.bind(this,[b]));};lyr.MsnryFilter.prototype={selectorChanged:
function(){var a=this.selector.children().filter(':selected').attr('value');if(a!=='All')this.showTilesTaggedWith(a);else $('.tile').show();this.refreshMasonry();},updateSelector:
function(a){if(a){this.selector.find('[value="'+a+'"]').prop('selected',true);this.selectorChanged();}},showTilesTaggedWith:
function(a){$('.tile').hide().filter('.'+a).show();},refreshMasonry:
function(){$(document).trigger(lyr.event.INSPIRE_MASONRY_REFRESH);}};lyr.wgt.register('msnry-filter',lyr.MsnryFilter);lyr.TagFilter=
function(a){var b=a.data('tag-context'),c=a.find('.tile'),d,e;if(!c.length)c=a.find('.temporary-tile');for(var f=0,g=c.length;f<g;f++){e=$(c[f]);d=e.data('tile').tags.split(' ');if(b&&d.length>0&&d[0]===b&&d[1])e.find('.tag-hidden').html(d[1]);}c.find('.tag-hidden').removeClass('tag-hidden').addClass('tag');};lyr.wgt.register('tag-filter',lyr.TagFilter);;

lyr.NewsletterSubscriptionForm=
function(a){this.element=a;this.isUser=a.data('is-user');this.userData=a.data('user-data');this.initialData=a.data('initial-data');this.subscription=lyr.lightbox.get(a).iSettings.subscription;this.inputTextFields=a.find('input[type="text"]');this.submitButton=a.find('button[type="submit"]');this.newsletterOptions=a.find('input[type="checkbox"]');this.initialCheckedNewsletterOptions=null;this.newsletterOptions.on('click',this.updateSubmitButtonText.bind(this));this.submitButton.on('click',this.tryAndSubmit.bind(this));this.element.on(lyr.event.FORM_SUCCESS,this.sayThanks.bind(this));this.doInitialCheck();this.doUserCheck();this.updateSubmitButtonText();lyr.gaq.trackLightboxEvents(this.element,'NEWSLETTER_SUBSCRIPTIONS CATEGORY.NEWSLETTER_SUBSCRIBE');};lyr.NewsletterSubscriptionForm.prototype={tryAndSubmit:
function(){if(!this.getCheckedNewsletterOptions().not('.already-subscribed').length){this.element.valid();
return false;}},doInitialCheck:
function(){var a;if(this.subscription){a=this.newsletterOptions.filter('[value="'+this.subscription+'"]');a.prop('checked',true);}for(var b=0,c=this.newsletterOptions.length;b<c;b++){a=$(this.newsletterOptions[b]);if(this.initialData[a.prop('value')])a.prop('checked',true);}this.initialCheckedNewsletterOptions=this.newsletterOptions.filter(':checked');},doUserCheck:
function(){if(this.isUser)for(var a=0,b=this.newsletterOptions.length;a<b;a++){var c=$(this.newsletterOptions[a]);if(this.userData[c.prop('value')])c.prop('checked',true).prop('disabled',true).addClass('already-subscribed').removeProp('name').parents('label').addClass('already-subscribed').append(' (already subscribed)');}},getCheckedNewsletterOptions:
function(){
return this.newsletterOptions.filter(':checked');},updateSubmitButtonText:
function(){var a=this.getCheckedNewsletterOptions().not('.already-subscribed'),b=a.length,c;if(!b)c='Subscribe to our Newsletters';else if(b===1)c='Subscribe to our '+this.extractSubscriptionName($(a[b-1]));else if(this.isUser)c='Subscribe to '+b+' more Newsletters';else c='Subscribe to '+b+' Newsletters';this.submitButton.text(c);},extractSubscriptionName:
function(a){var b=a.parent().text().trim().replace('Layar ','');
return b;},sayThanks:
function(){lyr.alert('Thanks for signing up','You\'ll be hearing from us.',{ok:
function(){lyr.lightbox.closeAll();}});}};lyr.wgt.register('newsletter-subscription-form',lyr.NewsletterSubscriptionForm);;

lyr.QRCodeGenerator=
function(a){var b=a.data('codify'),c=a.data('size'),d;d={text:b,width:c,height:c};a.qrcode(d);};lyr.wgt.register('qr-code-generator',lyr.QRCodeGenerator);;

lyr.ProfileForm=
function(a){var b='.item-name-';this.choice={industry:'industry',studentVal:'student_individual',otherVal:'other',nonStudentFields:$(lyr.format.sprintf('{1}job_title, {1}company, {1}industry_other_writein',b)),otherFields:$(lyr.format.sprintf('{1}industry_other_writein',b))};this.choice.wrapper=a.find(b+this.choice.industry);this.choice.field=this.choice.wrapper.find('select');this.choice.field.on('change keyup',this.industryChoiceFieldChanged.bind(this));this.choice.nonStudentFields.find('.optional').remove();this.industryChoiceFieldChanged();};lyr.ProfileForm.prototype={industryChoiceFieldChanged:
function(){var a=this.choice.field.val();if(a===this.choice.studentVal)this.choice.nonStudentFields.hide();else this.choice.nonStudentFields.removeClass('hide').show();if(a===this.choice.otherVal)this.choice.otherFields.removeClass('hide').show();else this.choice.otherFields.hide();}};lyr.wgt.register('profile-form',lyr.ProfileForm);;

lyr.PromotionCarousel=
function(a){this.element=a;this.index=0;this.images=a.find('.ref-image');this.imageWrapper=a.find('.img-wrapper');this.constrainWrapper=a.data('constrain-wrapper');this.context=a.data('context');this.controls={enabled:true,prev:a.find('.prev'),next:a.find('.next')};this.counters={images:this.images.length,imagesLoaded:0};this.handleEvents();this.parseImages();this.updateControls();};lyr.PromotionCarousel.prototype={handleEvents:
function(){this.controls.prev.on('click',this.prev.bind(this));this.controls.next.on('click',this.next.bind(this));$('body').on('keydown',
function(a){if(a.keyCode===37)this.prev();if(a.keyCode===39)this.next();}.bind(this));},parseImages:
function(){var a;if(!this.context)for(var b=0,c=this.counters.images;b<c;b++){a=new Image();a.onload=this._anImageHasLoaded.bind(this);a.src=$(this.images[b]).prop('src');}else if(this.context=='creator')this._allImagesHaveLoaded();},_anImageHasLoaded:
function(){this.counters.imagesLoaded++;if(this.counters.images===this.counters.imagesLoaded)this._allImagesHaveLoaded();},_allImagesHaveLoaded:
function(){var a,b=640;for(var c=0,d=this.counters.images;c<d;c++){a=$(this.images[c]);a.addClass((a.height()>a.width())?'portrait':'landscape');if(!this.constrainWrapper)b=(a.height()>b)?a.height():b;}this._exposeImages(b);},_exposeImages:
function(a){this.imageWrapper.css('height',a+40);this.images.filter(':first').fadeIn();},next:
function(){if(!this.controls.next.hasClass('disabled')&&this.controls.enabled)this.slide(1);
return false;},prev:
function(){if(!this.controls.prev.hasClass('disabled')&&this.controls.enabled)this.slide(-1);
return false;},updateControls:
function(){var a=this.counters.images;if(a){this.controls.prev.toggle(a>1).toggleClass('disabled',this.index-1<0);this.controls.next.toggle(a>1).toggleClass('disabled',this.index+1>=a);}this.controls.enabled=true;},slide:
function(a){var b=this.images,c=this.index;this.controls.enabled=false;if(b[c+a])$(b[c]).fadeOut('fast',
function(){var d=$(b[c+a]);this.index=c+a;this.updateControls();d.fadeIn('fast');}.bind(this));}};lyr.wgt.register('promotion-carousel',lyr.PromotionCarousel);;

lyr.wgt.inpirationLightboxTrigger=
function(a){this.element=a;this.tile=a.closest('.tile');this.data=this.tile.data('tile');this.renderURL=this.tile.data('render-url');a.on('click',this.openLightbox.bind(this));$(document).on(lyr.event.LIGHTBOX_CLOSE,this.lightboxClosed.bind(this));};lyr.wgt.inpirationLightboxTrigger.prototype={openLightbox:
function(a,b){$.ajax({url:this.renderURL,success:this.displayInspirationItem.bind(this)});if(!b)if(window.history.pushState)window.history.pushState({},document.title+' | '+this.data.name,'#'+this.data.slug);
return false;},displayInspirationItem:
function(a){lyr.lightbox.open({html:a,top:100,width:920,addClass:'inspiration'});},lightboxClosed:
function(){var a;if(location.hash&&window.history.replaceState){a=location.protocol+"//"+location.host+location.pathname;window.history.replaceState({},document.title,a);}}};lyr.wgt.register('inspiration-lightbox-trigger',lyr.wgt.inpirationLightboxTrigger);lyr.InspirationLightboxAutoTrigger=
function(a){var b=location.hash.replace('#',''),c=lyr.wgt.get('#tile-'+b+' .trigger','inspiration-lightbox-trigger');if(c)c.openLightbox({},true);};lyr.wgt.register('inspiration-lightbox-auto-trigger',lyr.InspirationLightboxAutoTrigger);;

lyr.Transactions=
function(a){var b=a.find('.transaction');this.downloads=b.find('.download');this.downloads.on('click',this._downloadInvoice.bind(this));$(document).on(lyr.event.BILLING_ADDRESS_SAVED,this.billingAddressSaved.bind(this));if(location.hash){var c=location.hash.replace('#','');location.replace('#');this.getButton(c).click();}};lyr.Transactions.prototype={_downloadInvoice:
function(a){var b=$(a.target),c=b.data('invoice-url'),d=b.data('has-been-downloaded'),e=b.data('form-url');this.downloadInvoice(c,d,e);
return false;},getButton:
function(a){
return this.downloads.filter('#'+a);},downloadInvoice:
function(a,b,c){if(!b){var d=new lyr.Lightbox();d.open({url:c,width:600});}else location.href=a;},billingAddressSaved:
function(a,b){var c=this.getButton(b);c.data('has-been-downloaded',true);location.href=c.data('invoice-url');}};lyr.wgt.register('transactions',lyr.Transactions);lyr.BillingAddressForm=
function(a){var b=a.find('button');this.element=a;this.panels={initial:a.find('.initial'),actions:a.find('.actions').hide()};this.buttons={preview:b.filter('.preview'),edit:b.filter('.edit'),submit:b.filter('.submit')};this.fields=a.find('.item input, .item textarea');this.tpl=$('#tpl-billing-address').html();this.previewArea=a.find('.billing-address');this.panels.actions.hide();this.buttons.preview.on('click',this.showPreview.bind(this));this.buttons.edit.on('click',this.togglePanels.bind(this));this.element.on(lyr.event.FORM_SUCCESS,this.downloadInvoice.bind(this));};lyr.BillingAddressForm.prototype={togglePanels:
function(){this.panels.initial.toggle();this.panels.actions.toggle();lyr.lightbox.get(this.element).setPosition();},showPreview:
function(){var a={};if(this.element.valid()){for(var b=0,c=this.fields.length;b<c;b++){var d=$(this.fields[b]);a[d.prop('name')]=d.val();}this.previewArea.html(Mustache.render(this.tpl,a));this.togglePanels();}},downloadInvoice:
function(){lyr.lightbox.get(this.element).close();$(document).trigger(lyr.event.BILLING_ADDRESS_SAVED,this.element.data('invoice-id'));}};lyr.wgt.register('billing-address-form',lyr.BillingAddressForm);;

lyr.CampaignPromotion=
function(a){this.element=a;this.promotionData=a.data('promotion');this.promotionTpl=$('#mustache-promotion').html();this.setTemplate();lyr.wgt.scan($('[data-wgt="promotion-carousel"]'));};lyr.CampaignPromotion.prototype={setTemplate:
function(){var a;a=new RegExp(/(<([^>]+)>)/ig);this.promotionData.description=this.promotionData.description.replace(a,'');a=new RegExp('\n','g');this.promotionData.description=this.promotionData.description.replace(a,'<br/>');this.promotionData.description=linkify(this.promotionData.description);this.element.html(Mustache.render(this.promotionTpl,this.promotionData));}};lyr.wgt.register('campaign-promotion',lyr.CampaignPromotion);