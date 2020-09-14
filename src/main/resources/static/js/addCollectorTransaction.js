/*globals $:false */
(function () {
    "use strict";

    $("#addCollectorTransaction").on("click", function () {

        var mydata = {
            id: $("#hotelId").val(),
            amount: $("#amount").val()
        }
        var userId = window.localStorage.getItem("userId");
        jQuery.ajax({
            url: "http://localhost:8080/user/" + userId + "/collector-transaction",
            type: "POST",
            data: JSON.stringify(mydata),
            contentType: 'application/json;charset=utf-8',
            dataType: "json",
            success: function (result) {
                //Write your code here
                window.console.log(result);
                window.alert("Added Collector Transaction");
                window.location.replace("http://localhost:8080/user.html")
            }
        });
    });
}());