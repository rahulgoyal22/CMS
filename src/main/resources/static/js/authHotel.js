/*globals $:false */
(function () {
    "use strict";
    $("#hotelLogin").on("click",function (){
        var email=$("#email").val();
        var password=$("#password").val();
        if(email.length<1){
            window.console.log(email);
            window.alert("Enter user email");
            return;
        }
        if(password.length<1){
            window.console.log(password);
            window.alert("Enter user password");
            return;
        }
        var url = "http://localhost:8080/hotels/auth-hotel?email="+email+"&password="+password;
        $.get(url,function (data,status){
            window.console.log(data);
            window.localStorage.setItem("hotelId", data.id);
            window.location.replace("http://localhost:8080/hotel.html");
        });
    });
}());