var AppModule = angular.module('app', ['ngCookies', 'ngSanitize', 'angular.vertilize', 'ngAnimate']).constant("API_URL", "/api")
        .config(['API_URL', function (API_URL) { }]);