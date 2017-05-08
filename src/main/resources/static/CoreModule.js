'use strict';

var CoreModule = angular.module('CoreModule', [
    'ui.router',
    'CoreModule.NavModule',
    'CoreModule.HomeModule',
    'CoreModule.FooterModule',
]);

CoreModule.config([
    '$stateProvider',
    '$urlRouterProvider',
    '$locationProvider',
    '$httpProvider',
    function($stateProvider, $urlRouterProvider, $locationProvider) {
        $locationProvider.html5Mode(true);
        $urlRouterProvider.otherwise('/');
        $stateProvider
            .state('main', {
                url: '/',
                views: {
                    'nav': {
                        templateUrl: 'modules/nav/NavView.html',
                        controller: 'NavController'
                    },
                    'content': {
                        templateUrl: 'modules/home/HomeView.html',
                        controller: 'HomeController'
                    },
                    'footer': {
                        templateUrl: 'modules/footer/FooterView.html',
                        controller: 'FooterController'
                    }
                }
            });
    }
]);