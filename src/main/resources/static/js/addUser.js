(function($) {
  "use strict";

$.ajax({
    url: '/users/',
    dataType: 'json',
    type: 'post',
    contentType: 'application/json',
    data: JSON.stringify( { "collector/approver": $('#typeOfUser').val(),
     "User name": $('#nameOfUser').val()
      "Email Address": $('#email').val()
      "password": $('#password').val()} ),
    processData: false,
    success: function( data, textStatus, jQxhr ){
        $('#response pre').html( JSON.stringify( data ) );
    },
    error: function( jqXhr, textStatus, errorThrown ){
        console.log( errorThrown );
    }
});