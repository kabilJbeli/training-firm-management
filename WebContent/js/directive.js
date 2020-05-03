AppModule.directive('allDon', function() {
    return {
        restrict: 'E',
        templateUrl: '/donManagement/partial/template.html',
        scope: {
            sectioncontent: "="
        },
        link: function($scope, scope, elem, attrs) {

        },
        controller: function($scope, $log,$http) {
            $scope.showSpinner = true;
            $scope.addingItemError=false;
            $scope.addingItemSuccess=false;

            $scope.error="";
            $scope.$watch('sectioncontent', function(newValue, oldValue, scope) {
                //Do anything with $scope.letters
                if (newValue !== 'undefined' && newValue !== undefined) {
                    $scope.content = $scope.sectioncontent[0].data;
                    $scope.showSpinner = false;
                }
            });
            
            $http.get("/donManagement/api/dons/getTypeList").then(function(rep) {
                console.log(rep.data);
                $scope.typeList = rep.data;
                $scope.selectedOption= $scope.typeList[0];
            }).catch(function (data) {
                $log.error("Data binding failed with:", data.status, data.statusText, data.data);
            }).finally(function () {
                $log.log("Finally finished data biding.");
            });;
            
            $scope.addType = function(quantity,name) {
               $scope.data = {    

                       name: name,
            		   quantite: quantity

                    };
                $http.post("/donManagement/api/dons/addType", JSON.stringify($scope.data)).then(function(response) {
                    $scope.addingItemError=false;
                    $scope.addingItemSuccess=true;
                	console.log(response);
                	  $http.get("/donManagement/api/dons/getTypeList").then(function(rep) {
                          console.log(rep.data);
                          $scope.typeList = rep.data;
                      }).catch(function (data) {
                          $log.error("Data binding failed with:", data.status, data.statusText, data.data);
                      }).finally(function () {
                          $log.log("Finally finished data biding.");
                      });;
                      
                }).catch(function (data) {
                    $log.error("Data binding failed with:", data.status, data.statusText, data.data);
                    $scope.addingItemError=true;
$scope.error = data.status;
                }).finally(function () {
                    $log.log("Finally finished data biding.");
                });;
            }
            
            $scope.addItem = function(quantity,description,type) {
            	
                $http.post("/donManagement/api/dons/add/"+type[0]+"/"+1+"/"+quantity+"/"+description).then(function(response) {
                    $scope.addingItemError=false;
                    $scope.addingItemSuccess=true;
                	  $http.get("/donManagement/api/dons/getAll").then(function(rep) {
                          console.log(rep.data);
                          $scope.content = rep.data;
                      }).catch(function (data) {
                          $log.error("Data binding failed with:", data.status, data.statusText, data.data);
                      }).finally(function () {
                          $log.log("Finally finished data biding.");
                      });

                }).catch(function (data) {
                    $log.error("Data binding failed with:", data.status, data.statusText, data.data);
                    $scope.addingItemError=true;
                    $scope.error = data.status;
                }).finally(function () {
                    $log.log("Finally finished data biding.");
                });;
            }

            $scope.deleteItem = function(id) {
                $http.delete("/donManagement/api/dons/removeDon?code=" + id).then(function(response) {
                    console.log(response);
                    $http.get("/donManagement/api/dons/getAll").then(function(rep) {
                        console.log(rep);
                        $scope.content = rep.data;
                    }).catch(function (rep) {
                        $log.error("Data binding failed with:", rep.status, rep.statusText, rep.data);
                    }).finally(function () {
                        $log.log("Finally finished data biding.");
                    });;

                }).catch(function (response) {
                    $log.error("Data binding failed with:", response.status, response.statusText, daresponseta.data);
                }).finally(function () {
                    $log.log("Finally finished data biding.");
                });;
            }

        }
    };
});

