AppModule.directive('allDon', function() {
    return {
        restrict: 'E',
        templateUrl: '/donManagement/partial/template.html',
        scope: {
            sectioncontent: "="
        },
        link: function($scope, scope, elem, attrs) {

        },
        controller: function($scope,$http) {
            $scope.showSpinner = true;

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
            });
            
            $scope.addType = function(quantity,name) {
               $scope.data = {    

                       name: name,
            		   quantite: quantity

                    };
                $http.post("/donManagement/api/dons/addType", JSON.stringify($scope.data)).then(function(response) {
                	console.log(response);
                	  $http.get("/donManagement/api/dons/getTypeList").then(function(rep) {
                          console.log(rep.data);
                          $scope.typeList = rep.data;
                      });
                      
                });
            }
            
            $scope.addItem = function() {
            	var type = {
            			
            			id:$scope.selectedOption[0],
            			name: $scope.selectedOption[1],
            			quantite:$scope.selectedOption[2]
            	}
            	
                var data = {

                        type: type,
                        description: $scope.doncol,
                        quantity: $scope.quantity,
                        doncol:'',
                        affectation:1
                    };
                $http.post("/donManagement/api/dons/add", JSON.stringify(data)).then(function(response) {
                	  $http.get("/donManagement/api/dons/getAll").then(function(rep) {
                          console.log(rep.data);
                          $scope.content = rep.data;
                      });

                });
            }

            $scope.deleteItem = function(id) {
                $http.delete("/donManagement/api/dons/removeDon?code=" + id).then(function(response) {
                    console.log(response);
                    $http.get("/donManagement/api/dons/getAll").then(function(rep) {
                        console.log(rep);
                        $scope.content = rep.data;
                    });

                });
            }

        }
    };
});

