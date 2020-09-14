/*globals $:false */

(function () {
    "use strict";

    $.get("http://localhost:8080/users/"+window.localStorage.getItem("userId"),function (data, status){
        if(data.typeOfUser == "collector"){
            $("#approver").hide();
        }
        else
            $("#collector").hide();
    });
}());