/*globals $:false */
(function () {
    "use strict";
    $.get("http://localhost:8080/hotels/", function (data, status) {
        var hotel = data;
        for (var i = 0; i < hotel.length; i++) {
            var markup = "<tr><td>" + hotel[i].id + "</td><td>" + hotel[i].managerId + "</td><td>" + hotel[i].emailAddress + "</td><td>" + hotel[i].balance + "</td></tr>";
            $("table tbody").append(markup);
        }

    });
}());