/*globals $:false */

(function () {
    "use strict";

    $("#userLogin").on("click ", function () {
        var email = $("#email").val();

        var password = $("#password").val();

        if (email.length < 1) {
            window.console.log(email);
            window.alert("Enter user email");
            return;
        }
        if (password.length < 1) {
            window.console.log(password);
            window.alert("Enter user password");
            return;
        }
        var url = "http://localhost:8080/users/auth-user?email-id=" + email + "&password=" + password;
        $.get(url, function (data, status) {

            if (data.status == "Failure") {
                window.alert(data.message);
                return;
            }
            window.console.log(data.id);
            window.localStorage.setItem("userId", data.id);
            window.location.replace("http://localhost:8080/user.html");
        });
    });
}());