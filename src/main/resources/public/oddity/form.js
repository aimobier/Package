// functional sort
Object.defineProperty(Array.prototype, 'changeDesc', {
    enumerable: false,
    value: function ( key, nvalue ) {
        var isexit = false;
        for (var i in this) {
            if (this[i]["name"] == key) {
                this[i]["value"] = nvalue;
                isexit = true;
                break; //Stop this loop, we found it!
            }
        }
        if (!isexit){
            this.push({"name":key,"value":nvalue});
        }
    }
});


$("input").each(function () {

    $(this).attr("value",$(this).attr("placeholder"));
    }
);

function setFromStepFunction() {

    $("#form").steps({
        bodyTag: "fieldset",
        onStepChanging: function (event, currentIndex, newIndex) {

            if (currentIndex > newIndex) {
                return true;
            }

            var form = $(this);

            // // Clean up if user went backward before
            if (currentIndex < newIndex) {
                // To remove error styles
                $(".body:eq(" + newIndex + ") label.error", form).remove();
                $(".body:eq(" + newIndex + ") .error", form).removeClass("error");

                form.validate().settings.ignore = ":disabled,:hidden";
            }

            return form.valid();
        },
        onStepChanged: function (event, currentIndex, priorIndex) {
            // Suppress (skip) "Warning" step if the user is old enough.
            // if (currentIndex === 2 && Number($("#age").val()) >= 18)
            // {
            //     $(this).steps("next");
            // }
            //
            // // Suppress (skip) "Warning" step if the user is old enough and wants to the previous step.
            // if (currentIndex === 2 && priorIndex === 3)
            // {
            //     $(this).steps("previous");
            //

        }, onFinishing: function (event, currentIndex) {

            var form = $(this);
            form.validate().settings.ignore = ":disabled";
            return form.valid();

        }, onFinished: function (event, currentIndex) {


            $(this).submit();

            // var values = $(this).serializeArray();
            //
            // values.changeDesc("statusstyleno",$("#statusstyleno").is(':checked')  ? "1" : "0");
            // values.changeDesc("statusstyleni",$("#statusstyleni").is(':checked')  ? "1" : "0");
            //
            // $.post("/config",jQuery.param(values), function(data,status){
            //
            //     alert("Data: " + data + " Status: " + status);
            // });


        }
    }).validate({

        errorPlacement: function (error, element) {

            element.before(error);
        },
        rules: {
            displayname: "required",
            bundleidentifier: "required",
            version: "required",
            build: "required",

            umengappkey: "required",
            umessageappkey: "required",

            wechatappkey: "required",
            wechatsecret: "required",
            wechatredirecturl: "required",

            sinaappkey: "required",
            sinasecret: "required",
            sinaredirecturl: "required",

            qqappkey: "required",
            qqappsecret: "required",
            qqredirecturl: "required",

            tintcolorno: "required",
            tintcolorni: "required",

            titlecolorno: "required",
            titlecolorni: "required",

            backcolorno: "required",
            backcolorni: "required",

            bordercolorno: "required",
            bordercolorni: "required",

            icon: "required",
            launch: "required"

        },
        messages: {
            displayname: "不可为空",
            bundleidentifier: "不可为空",
            version: "不可为空",
            build: "不可为空",

            umengappkey: "不可为空",
            umessageappkey: "不可为空",

            wechatappkey: "不可为空",
            wechatsecret: "不可为空",
            wechatredirecturl: "不可为空",

            sinaappkey: "不可为空",
            sinasecret: "不可为空",
            sinaredirecturl: "不可为空",

            qqappkey: "不可为空",
            qqappsecret: "不可为空",
            qqredirecturl: "不可为空",

            tintcolorno: "不可为空",
            tintcolorni: "不可为空",

            titlecolorno: "不可为空",
            titlecolorni: "不可为空",

            backcolorno: "不可为空",
            backcolorni: "不可为空",

            bordercolorno: "不可为空",
            bordercolorni: "不可为空",

            icon: "不可为空",
            launch: "不可为空"
        }
    });
}