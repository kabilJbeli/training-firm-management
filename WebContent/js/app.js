var AppModule = angular.module('app', []).constant("API_URL", "/api")
        .config(['API_URL', function (API_URL) { }]);