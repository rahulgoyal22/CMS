/*globals $:false */

(function() {
    "use strict";
     $("#adduser").on("click",function () {
         var mydata ={typeOfUser:$("#exampleTypeOfUser").val(),
             nameOfUser:$("#exampleFirstName").val(),
             email:$("#exampleInputEmail").val(),
             password:$("#exampleInputPassword").val(),
         }

         jQuery.ajax({
             url:"http://localhost:8080/users/" ,
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