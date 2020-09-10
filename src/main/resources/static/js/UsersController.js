'use strict'
var module = angular.module('cash.management.system.controllers', []);
module.controller("UsersController", ["$scope", "UsersService",
    function($scope, UsersService) {
//        $scope.AddUserRequest = {
//            typeOfUser: null,
//            nameOfUser: null,
//            email: null,
//            password: null
//        };
      //  $scope.skills = [];
//        UsersService.getUser(1).then(function(value) {
//            console.log(value.data);
//        }, function(reason) {
//            console.log("error occured");
//        }, function(value) {
//            console.log("no callback");
//        });
           $scope.saveUser = function() {
//            $scope.AddUserRequest.skillDtos = $scope.skills.map(skill => {
//                return {
//                    skillId: null,
//                    skillName: skill
//                };
//            });
            UsersService.addUser($scope.AddUserRequest).then(function() {
                console.log("works");
                UsersService.getUsers().then(function(value) {
                    $scope.allUsers = value.data;
                }, function(reason) {
                    console.log("error occured");
                }, function(value) {
                    console.log("no callback");
                });
//                $scope.skills = [];
//                $scope.AddUserRequest = {
//                    userId: null,
//                    userName: null,
//                    skillDtos: []
//                };
            }, function(reason) {
                console.log("error occured");
            }, function(value) {
                console.log("no callback");
            });
        }
    }
]);