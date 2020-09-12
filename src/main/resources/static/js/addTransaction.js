/*globals $:false */
(function () {
    "use strict";

    $("#addTransaction").on("click",function (){

        var mydata = {
            transaction: $("#typeOfTransaction").val(),
            amount: $("#amount").val()
        }
        var hotelId = window.localStorage.getItem("hotelId");
        jQuery.ajax({
            url:"http://localhost:8080/hotel/"+hotelId+"/transaction" ,
            type: "POST",
            data:JSON.stringify(mydata),
            contentType:'application/json;charset=utf-8',
            dataType: "json",
            success: function(result) {
                //Write your code here
                window.console.log(result);
                window.location.replace("http://localhost:8080/hotel.html")
            }
        });
    });
}());