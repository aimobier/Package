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
            privacyurl:{ url:true },
            supporturl:{ url:true },
            marketing:{ url:true },

            swemail:{ email: true },
            appleid: { email: true },
            loginname: { email: true },

            promotional:{ maxlength : 170 },
            keywords:{ maxlength : 100 },
            appname:{ maxlength : 50 },
            subtitle:{ maxlength : 30 },
            subtitle:{ maxlength : 30 }
        },
        // messages: {
        //     appleid: {
        //         required: "不可为空",
        //         email: "不符合邮箱定义"
        //     },
        //     displayname: "不可为空"
        // }
    });
}




jQuery.extend(jQuery.validator.messages, {
    required: "不可为空.",
    remote: "Please fix this field.",
    email: "邮箱格式不正确",
    url: "URL格式不正确.",
    date: "Please enter a valid date.",
    dateISO: "Please enter a valid date (ISO).",
    number: "Please enter a valid number.",
    digits: "Please enter only digits.",
    creditcard: "Please enter a valid credit card number.",
    equalTo: "Please enter the same value again.",
    accept: "Please enter a value with a valid extension.",
    maxlength: jQuery.validator.format("输入的值不可超过 {0} 字节."),
    minlength: jQuery.validator.format("输入的值不可小雨 {0} 字节."),
    rangelength: jQuery.validator.format("输入的字数要在 {0} 和 {1} 之间."),
    range: jQuery.validator.format("Please enter a value between {0} and {1}."),
    max: jQuery.validator.format("Please enter a value less than or equal to {0}."),
    min: jQuery.validator.format("Please enter a value greater than or equal to {0}.")
});
