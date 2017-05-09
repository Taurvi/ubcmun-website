'use strict';
var NavModule = angular.module('CoreModule.NavModule', []);
NavModule.controller('NavController', ['$document', function($document){

    angular.element($document).ready(function () {
        $(".button-collapse").sideNav();
    });

    // I mean surely something will go here... Maybe?
}]);