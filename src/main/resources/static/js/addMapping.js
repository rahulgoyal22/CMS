/*globals $:false */
(function () {
    "use strict";
    $("#addmapping").on("click", function () {
        if ($("#exampleCollectorId").val().length < 1) {
            window.alert("Enter collector Id");
            return;
        }
        if ($("#exampleApproverId").val().length < 1) {
            window.alert("Enter Approver Id");
            return;
        }
        var collectorId = $("#exampleCollectorId").val();
        var approverId = $("#exampleApproverId").val();
        var url = "http://localhost:8080/mapping?collector-id=" + collectorId + "&approver-id=" + approverId;
        $.post(url, function (data, status) {
            window.console.log(data);
            window.alert("Mapping added");
            window.location.replace("http://localhost:8080/home");
        });
    });
}());
