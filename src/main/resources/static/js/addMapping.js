/*globals $:false */

(function() {
    "use strict";
     $("#addMapping").on("click",function () {
         var mydata ={}
            mydata["collectorId"] = $("#collectorId").val();
            mydata["approverId"] = $("#approverId").val();

         jQuery.ajax({
             url:"http://localhost:8080/mapping" ,
             type: "POST",
             data:JSON.stringify(mydata),
             contentType:'application/json;charset=utf-8',
             dataType: "json",
             success: function(result) {
                 //Write your code here
                 window.console.log(result);
             }
         });
     });
}());