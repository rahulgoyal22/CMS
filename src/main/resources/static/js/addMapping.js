/*globals $:false */
(function () {
    "use strict";
    $("#addmapping").on("click",function (){
        var collectorId=$("#exampleCollectorId").val();
        var approverId=$("#exampleApproverId").val();
        var url = "http://localhost:8080/mapping?collector-id="+collectorId+"&approver-id="+approverId;
        $.post(url,function (data,status){
            window.console.log(data);
        });
    });
}());
