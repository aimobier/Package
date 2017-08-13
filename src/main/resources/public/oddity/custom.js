Dropzone.options.dropzoneForm = {
    paramName: "file", // The name that will be used to transfer the file
    maxFilesize: 2, // MB
    addRemoveLinks:true,
    acceptedFiles:"image/jpeg,image/png,image/gif",



    dictDefaultMessage: "<i class=\"fa fa-upload\" style=\"font-size: 100px;color: #e5e5e5 \"></i>",
    dictFallbackMessage:"不支持你的浏览器",
    dictFileTooBig:" 文件太大 ({{filesize}}MiB). 提交最大的文件为: {{maxFilesize}}MiB.",
    dictInvalidFileType:"文件类型不支持，只能上传图片",
    dictResponseError:"服务器没有反应 {{statusCode}}",
    dictMaxFilesExceeded:"你最多上传{{maxFiles}}个文件"
};



function setFromStepFunction() {

    $("#wizard").steps();
    $("#form").steps({
        bodyTag: "fieldset",
        onStepChanging: function (event, currentIndex, newIndex)
        {

            // // Always allow going backward even if the current step contains invalid fields!
            if (currentIndex > newIndex)
            {
                return true;
            }


            var form = $(this);

            // // Clean up if user went backward before
            if (currentIndex < newIndex)
            {
                // To remove error styles
                $(".body:eq(" + newIndex + ") label.error", form).remove();
                $(".body:eq(" + newIndex + ") .error", form).removeClass("error");

                form.validate().settings.ignore = ":disabled,:hidden";
            }
            //
            // // Disable validation on fields that are disabled or hidden.
            // form.validate().settings.ignore = ":disabled,:hidden";
            //
            // // Start validation; Prevent going forward if false
            return form.valid();
        },
        onStepChanged: function (event, currentIndex, priorIndex)
        {
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
        },
        onFinishing: function (event, currentIndex)
        {
            var form = $(this);

            // Disable validation on fields that are disabled.
            // At this point it's recommended to do an overall check (mean ignoring only disabled fields)
            form.validate().settings.ignore = ":disabled";

            // Start validation; Prevent form submission if false
            return form.valid();
        },
        onFinished: function (event, currentIndex)
        {
            var form = $(this);

            // Submit form input
            form.submit();
        }
    }).validate({
        errorPlacement: function (error, element)
        {
            element.before(error);
        },
        rules: {
            // displayname: "required",
            // bundleidentifier: "required",
            // version: "required",
            // build: "required",
        },
        messages: {
            displayname: "应用名称不可为空",
            bundleidentifier: "应用唯一标示不可为空",
            version: "应用版本不可为空",
            build: "应用build版本不可为空",
        }
    });
}




function flotConfigFunction() {

    var sparklineCharts = function(){
        $("#sparkline1").sparkline([34, 43, 43, 35, 44, 32, 44, 52], {
            type: 'line',
            width: '100%',
            height: '50',
            lineColor: '#1ab394',
            fillColor: "transparent"
        });

        $("#sparkline2").sparkline([32, 11, 25, 37, 41, 32, 34, 42], {
            type: 'line',
            width: '100%',
            height: '50',
            lineColor: '#1ab394',
            fillColor: "transparent"
        });

        $("#sparkline3").sparkline([34, 22, 24, 41, 10, 18, 16,8], {
            type: 'line',
            width: '100%',
            height: '50',
            lineColor: '#1C84C6',
            fillColor: "transparent"
        });
    };

    var sparkResize;

    $(window).resize(function(e) {
        clearTimeout(sparkResize);
        sparkResize = setTimeout(sparklineCharts, 500);
    });

    sparklineCharts();




    var data1 = [
        [0,4],[1,8],[2,5],[3,10],[4,4],[5,16],[6,5],[7,11],[8,6],[9,11],[10,20],[11,10],[12,13],[13,4],[14,7],[15,8],[16,12]
    ];
    var data2 = [
        [0,0],[1,2],[2,7],[3,4],[4,11],[5,4],[6,2],[7,5],[8,11],[9,5],[10,4],[11,1],[12,5],[13,2],[14,5],[15,2],[16,0]
    ];
    $("#flot-dashboard5-chart").length && $.plot($("#flot-dashboard5-chart"), [
            data1,  data2
        ],
        {
            series: {
                lines: {
                    show: false,
                    fill: true
                },
                splines: {
                    show: true,
                    tension: 0.4,
                    lineWidth: 1,
                    fill: 0.4
                },
                points: {
                    radius: 0,
                    show: true
                },
                shadowSize: 2
            },
            grid: {
                hoverable: true,
                clickable: true,

                borderWidth: 2,
                color: 'transparent'
            },
            colors: ["#1ab394", "#1C84C6"],
            xaxis:{
            },
            yaxis: {
            },
            tooltip: false
        }
    );
}


function conifgureColorPicker() {

    $('.demo1').colorpicker();


    var elem = document.querySelector('.js-switch');
    var switchery = new Switchery(elem, { color: '#1AB394' });


    var elem = document.querySelector('.js-switch1');
    var switchery = new Switchery(elem, { color: '#1AB394' });
}