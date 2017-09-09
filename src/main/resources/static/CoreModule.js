'use strict';

var CoreModule = angular.module('CoreModule', [
    'ui.router',
    'ui.materialize',
    'CoreModule.NavModule',
    'CoreModule.HomeModule',
    'CoreModule.FooterModule',
    'CoreModule.LoginModule',
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
                        templateUrl: 'modules/home/LoginView.html',
                        controller: 'HomeController'
                    },
                    'footer': {
                        templateUrl: 'modules/footer/FooterView.html',
                        controller: 'FooterController'
                    }
                }
            })
            .state('login', {
                url: '/login',
                views: {
                    'content': {
                        templateUrl: 'modules/login/LoginView.html',
                        controller: 'LoginController'
                    }
                }
            });
    }
]);