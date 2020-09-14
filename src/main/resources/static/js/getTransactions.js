/*globals $:false */
(function () {
    "use strict";
    $("#balance").on("click", function () {
        var hotelId = window.localStorage.getItem("hotelId");
        var url = "http://localhost:8080/hotels/" + hotelId;
        $.get(url, function (data, status) {
            var hotel = data;
            $("#currentBalance").append(hotel.balance);
        });
    });

    $("#getTransaction").on("click", function () {
        var hotelId = window.localStorage.getItem("hotelId");
        var startDate = $("#start-date").val();
        var endDate = $("#end-date").val();
        var url = "http://localhost:8080/hotel/" + hotelId + "/daily-transaction?start-date=" + startDate + "&end-date=" + endDate;
        $.get(url, function (data, status) {
            var transactions = data;
            for (var i = 0; i < transactions.length; i++) {
                var markup = "<tr><td>" + transactions[i].transaction + "</td><td>" + transactions[i].amount + "</td></tr>";
                $("table tbody").append(markup);
            }
            window.console.log(data);
        });
    });

}());