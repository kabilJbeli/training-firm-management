AppModule.controller('appCTRL', ['$http', '$scope', '$q', '$log', '$cookies', 'appFactory', '$window', function ($http, $scope, $q, $log, $cookies, appFactory, $window) {
        $log.log("Data biding start");
        $q.all([
        	appFactory.request
        ]).then(function (data) {

            $scope.sectioncontent = data;
      
        }).catch(function (data) {
            $scope.showData = false;
            $log.error("Data binding failed with:", data.status, data.statusText, data.data);
        }).finally(function () {
            $log.log("Finally finished data biding.");
        });
    }]);