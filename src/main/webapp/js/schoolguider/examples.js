(function ($) {
    "use strict";
    $(function () {
        $.extend($.ui.slider.prototype.options, {
            animate: "fast",
            stop: function () {
                var ident = this.id || this.className;
                $(this).val($(this).slider("option","value"));
            }
        });
        $(".steps-stacking-slider")
            .slider({min: 0, max: 100, step: 1})
            .slider("pips", {
                rest: "label",
                step: 10
            })
            .slider("float");
    });
}(jQuery));