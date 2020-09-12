/*globals $:false */

(function() {
    "use strict";
    $("#addhotel").on("click",function () {
        var mydata ={managerId:$("#hotelName").val(),
            collectorEmail:$("#collectorEmail").val(),
            emailAddress:$("#Email").val(),
            password:$("#Password").val(),
            balance:0}

        jQuery.ajax({
            url:"http://localhost:8080/hotels/" ,
            type: "POST",
            data:JSON.stringify(mydata),
            contentType:'application/json;charset=utf-8',
            dataType: "json",
            success: function(result) {
                //Write your code here
                window.console.log(result);
            }
        });
    });
}());