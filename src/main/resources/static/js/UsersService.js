'use strict'
angular.module('cash.management.system.services', []).factory('UsersService', ["$http", "CONSTANTS", function($http, CONSTANTS) {
    var service = {};
    service.getUser = function(userId) {
        var url = CONSTANTS.getUserByIdUrl + userId;
        return $http.get(url);
    }
    service.getUsers = function() {
        return $http.get(/users/);
    }
    service.addUser = function(AddUserRequest) {
        return $http.post(/users/, AddUserRequest);
    }
    return service;
}]);