/*globals $:false */

(function () {
    "use strict";
    $("#addhotel").on("click", function () {
        if ($("#hotelName").val().length < 1) {
            window.alert("Enter Hotel Name");
            return;
        }
        if ($("#collectorEmail").val().length < 1) {
            window.alert("Enter Collector Email");
            return;
        }
        if ($("#Email").val().length < 1) {
            window.alert("Enter Hotel Email");
            return;
        }
        if ($("#Password").val().length < 8 || $("#Password").val().length > 14) {
            window.alert("Password size must be between 8 and 14");
            return;
        }
        if ($("#exampleRepeatPassword").val().length <1) {
            window.alert("Enter Repeat Password ");
            return;
        }
        if ($("#exampleRepeatPassword").val() != $("#Password").val()) {
            window.alert("Repeat Password  doesn't match!");
            return;
        }
        var mydata = {
            hotelName: $("#hotelName").val(),
            collectorEmail: $("#collectorEmail").val(),
            emailAddress: $("#Email").val(),
            password: $("#Password").val(),
            balance: 0
        }

        jQuery.ajax({
            url: "http://localhost:8080/hotels/",
            type: "POST",
            data: JSON.stringify(mydata),
            contentType: 'application/json;charset=utf-8',
            dataType: "json",
            success: function (result) {
                //Write your code here
                window.console.log(result);
                if(result.status=="Failure")
                {
                    // window.alert(result.message);
                    return;
                }
                window.alert("Hotel Added");
                window.location.replace("http://localhost:8080/hotelLogin.html");
            }
        });
    });
}());