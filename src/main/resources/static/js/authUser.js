/*globals $:false */
(function () {
    "use strict";
    $("#userLogin").on("click",function (){
        var email=$("#email").val();
        var password=$("#password").val();
        var url = "http://localhost:8080/users/auth-user?email-id="+email+"&password="+password;
        $.get(url,function (data,status){
            window.console.log(data.id);
            window.localStorage.setItem("userId", data.id);
            window.location.replace("http://localhost:8080/user.html");
        });
    });
}());