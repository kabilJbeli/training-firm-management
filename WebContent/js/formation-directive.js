AppModule.directive('allFormation', function() {
    return {
        restrict: 'E',
        templateUrl: '/training-firm-management/partial/templateFormation.html',
        scope: {
      },
        link: function($scope, scope, elem, attrs) {

        },
        controller: function($scope, $log,$http) {
            $scope.showSpinner = true;
            $scope.addingItemError=false;
            $scope.addingItemSuccess=false;

            $scope.error="";

  
     $scope.getAllMatiere = function(){            	
                $http.get("/training-firm-management/api/dons/getAllMatiere").then(function(rep) {
                    $scope.matiereContent = rep.data;
                    $scope.showSpinner=false;
                }).catch(function (data) {
                    $log.error("Data binding failed with:", data.status, data.statusText, data.data);
                }).finally(function () {
                    $log.log("Finally finished data biding.");
                });
            }
       $scope.getAllMatiere();
            $scope.getAllFormation = function(){            	
                $http.get("/training-firm-management/api/dons/getAllformations").then(function(rep) {
                    $scope.content = rep.data;
                    $scope.showSpinner=false;
                }).catch(function (data) {
                    $log.error("Data binding failed with:", data.status, data.statusText, data.data);
                }).finally(function () {
                    $log.log("Finally finished data biding.");
                });
            }
             $scope.getAllFormation();
            
            
                   $scope.addItem = function(name,theme,matiere) {
            	
                $http.post("/training-firm-management/api/dons/add/formation/"+name+"/"+theme+"/"+matiere).then(function(response) {
                	if(response.data !== ""){
                    $scope.addingItemError=false;
                    $scope.addingItemSuccess=true;
                    $scope.getAllFormation();
                	}else{
                        $scope.addingItemtoTypeError=true;
                	}
                }).catch(function (data) {
                    $log.error("Data binding failed with:", data.status, data.statusText, data.data);
                    $scope.addingItemError=true;
                    $scope.error = data.status;
                }).finally(function () {
                    $log.log("Finally finished data biding.");
                });;
            }
            
            
                  $scope.deleteItem = function(id) {
                $http.delete("/training-firm-management/api/dons/removeFormation?code=" + id).then(function(response) {
                    console.log(response);
                    $scope.getAllFormation();

                }).catch(function (response) {
                    $log.error("Data binding failed with:", response.status, response.statusText, daresponseta.data);
                }).finally(function () {
                    $log.log("Finally finished data biding.");
                });;
            }
    
    
    
    
       $scope.updateSelectedItem = function(name,theme,matiere) {
       console.log(name);
            	$scope.dataFormation.name = name;
                $http.put("/training-firm-management/api/dons/modifyFormation?id="+$scope.dataFormation.id+"&name="+name+"&theme="+theme+"&matiere="+matiere).then(function(response) {
                    console.log(response);
                    $scope.getAllFormation();
                    
                }).catch(function (response) {
                    $log.error("Data binding failed with:", response.status, response.statusText, daresponseta.data);
                }).finally(function () {
                    $log.log("Finally finished data biding.");
                });;
           	
               }
    
     $scope.dataFormation={};
     
    $scope.updateDon = function(code) {
            	
             $http.get("/training-firm-management/api/dons/getSpecificFormation?id=" + code).then(function(response) {
                 $scope.name = response.data.name;

                 $scope.dataFormation = {
                		 id:response.data.id,
                		 name:$scope.name
                 };
                 
             }).catch(function (response) {
                 $log.error("Data binding failed with:", response.status, response.statusText, daresponseta.data);
             }).finally(function () {
                 $log.log("Finally finished data biding.");
             });;
        	
            }
      
        }
    };
});

