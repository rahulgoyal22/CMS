/*globals $:false */
(function () {
    "use strict";
    $("#hotelLogin").on("click",function (){
        var email=$("#email").val();
        var password=$("#password").val();
        var url = "http://localhost:8080/hotels/auth-hotel?email="+email+"&password="+password;
        $.get(url,function (data,status){
            window.console.log(data);
            window.localStorage.setItem("hotelId", data.id);
            window.location.replace("http://localhost:8080/hotel.html");
        });
    });
}());