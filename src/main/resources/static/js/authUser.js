/*globals $:false */
(function () {
    "use strict";
    $("#userLogin").on("click",function (){
        var email=$("#email").val();
        var password=$("#password").val();
        var url = "http://localhost:8080/users/auth-user?email-id="+email+"&password="+password;
        $.get(url,function (data,status){
            window.console.log(data);
        });
    });
}());