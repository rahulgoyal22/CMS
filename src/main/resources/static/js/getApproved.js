/*globals $:false */
(function () {
    "use strict";
    $("#getApproved").on("click",function (){
         var userId = window.localStorage.getItem("userId");
         var collectorId=$("#CollectorId").val();
         var amount=$("#amount").val();
         var date=$("#date").val();
         var hotelId=$("#hotelId").val();

      //   var url = "http://localhost:8080/user/"+userId+"/approve-transaction?collector-id="+collectorId+"&amount="+amount+"&date="+date+"&hotel-id="+hotelId;
         jQuery.ajax({
                    url: "http://localhost:8080/user/"+userId+"/approve-transaction?collector-id="+collectorId+"&amount="+amount+"&date="+date+"&hotel-id="+hotelId ,
                    type: "PUT",
                    contentType:'application/json;charset=utf-8',
                    dataType: "json",
                    success: function(result) {
                        //Write your code here
                        window.console.log(result);
                    }
                });
    });
}());