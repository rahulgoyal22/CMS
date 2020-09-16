/*globals $:false */

(function () {
    "use strict";
    $("#adduser").on("click", function () {
        if ($("#exampleFirstName").val().length < 1) {
            window.alert("Enter Name");
            return;
        }
        if ($("#exampleTypeOfUser").val().length < 1) {
            window.alert("Enter Type");
            return;
        }
        if ($("#exampleInputEmail").val().length < 1) {
            window.alert("Enter Email");
            return;
        }
        if ($("#exampleInputPassword").val().length < 8 || $("#exampleInputPassword").val().length > 14) {
            window.alert("Password size must be between 8 and 14 ");
            return;
        }
        if ($("#exampleRepeatPassword").val().length < 1) {
            window.alert("Enter Password Again");
            return;
        }
        if ($("#exampleRepeatPassword").val() != $("#exampleInputPassword").val()) {
            window.alert("Repeat Password  doesn't match!");
            return;
        }
        var mydata = {
            typeOfUser: $("#exampleTypeOfUser").val(),
            nameOfUser: $("#exampleFirstName").val(),
            email: $("#exampleInputEmail").val(),
            password: $("#exampleInputPassword").val(),
        }

        jQuery.ajax({
            url: "http://localhost:8080/users/",
            type: "POST",
            data: JSON.stringify(mydata),
            contentType: 'application/json;charset=utf-8',
            dataType: "json",
            success: function (result) {
                //Write your code here
                if(result.status=="Failure")
                {
                    return ;
                }
                window.console.log(result);
                window.alert("Added User");
                window.location.replace("http://localhost:8080/userLogin.html");
            }
        });
    });
}());