/*globals $:false */
(function () {
    "use strict";
    $("#hotelLogin").on("click",function (){
        var email=$("#email").val();
        var password=$("#password").val();
        var url = "http://localhost:8080/hotels/auth-hotel?email="+email+"&password="+password;
        $.get(url,function (data,status){
            window.console.log(data);
        });
    });
}());