'use strict'
var demoApp = angular.module('cash.management.system', ['ui.bootstrap', 'cash.management.system.controllers',
    'cash.management.system.services'
]);
demoApp.constant("CONSTANTS", {
    getUserByIdUrl: "/users/{id}",
    getAllUsers: "/users/",
    saveUser: "/users/"
});