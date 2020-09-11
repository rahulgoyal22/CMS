/*globals $:false */
(function () {
    "use strict";
    $.get("http://localhost:8080/users/", function (data, status) {
        var users = data;
        for (var i = 0; i < users.length; i++) {
            var markup = "<tr><td>" + users[i].id + "</td><td>" + users[i].typeOfUser + "</td><td>" + users[i].nameOfUser + "</td><td>" + users[i].email + "</td></tr>";
            $("table tbody").append(markup);
        }

    });
}());