AppModule.directive('allDon', function() {
    return {
        restrict: 'E',
        templateUrl: '/training-firm-management/partial/template.html',
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
            $scope.getAllDons = function(){            	
                $http.get("/training-firm-management/api/dons/getAll").then(function(rep) {
                    console.log(rep.data);
                    $scope.content = rep.data;
                }).catch(function (data) {
                    $log.error("Data binding failed with:", data.status, data.statusText, data.data);
                }).finally(function () {
                    $log.log("Finally finished data biding.");
                });
            }
            
            $scope.getAllType = function(){ 
            $http.get("/training-firm-management/api/dons/getAllPostes").then(function(rep) {
                console.log(rep.data);
                $scope.typeList = rep.data;
                $scope.selectedOption= $scope.typeList[0];
            }).catch(function (data) {
                $log.error("Data binding failed with:", data.status, data.statusText, data.data);
            }).finally(function () {
                $log.log("Finally finished data biding.");
            });
            }
            
            $scope.getAllType();
            $scope.updatedescription;
            $scope.updatequantity;
            $scope.updateOption;
            $scope.updateaffectation;
            $scope.updateSelectedItem = function(name,lastname,honoraire,poste) {
            	$scope.dataDon.nom = name;
            	$scope.dataDon.prenom = lastname;
            	$scope.dataDon.honoraireparheure = honoraire;
	$scope.dataDon.poste = poste;
                $http.put("/training-firm-management/api/dons/modifyEmployee?typeid="+$scope.dataDon.id,JSON.stringify($scope.dataDon)).then(function(response) {
                    $scope.getAllDons();
                    
                }).catch(function (response) {
                    $log.error("Data binding failed with:", response.status, response.statusText, daresponseta.data);
                }).finally(function () {
                    $log.log("Finally finished data biding.");
                });;
           	
               }
            
            
         $scope.updateDon = function(code) {
            	
             $http.get("/training-firm-management/api/dons/getSpecificEmployee?id=" + code).then(function(response) {
                 $scope.name = response.data.nom;
                 $scope.lastname = response.data.prenom;
                 $scope.updateaffectation = response.data.honoraireparheure;

                 $scope.dataDon = {
                		 id:response.data.id,
                		 nom:$scope.name,
                		 prenom:$scope.lastname,
                		 honoraireparheure: response.data.honoraireparheure,
                		 poste:response.data.poste
                 };
                 
             }).catch(function (response) {
                 $log.error("Data binding failed with:", response.status, response.statusText, daresponseta.data);
             }).finally(function () {
                 $log.log("Finally finished data biding.");
             });;
        	
            }
            
            

          
            $scope.addItem = function(name,lastname,honoraire,post) {
            	
                $http.post("/training-firm-management/api/dons/add/"+name+"/"+lastname+"/"+honoraire+"/"+post).then(function(response) {
                	if(response.data !== ""){
                    $scope.addingItemError=false;
                    $scope.addingItemSuccess=true;
                    $scope.getAllDons();
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
                $http.delete("/training-firm-management/api/dons/removeEmployee?code=" + id).then(function(response) {
                    console.log(response);
                    $scope.getAllDons();

                }).catch(function (response) {
                    $log.error("Data binding failed with:", response.status, response.statusText, daresponseta.data);
                }).finally(function () {
                    $log.log("Finally finished data biding.");
                });;
            }

            $scope.deleteType = function(id) {
                $http.delete("/training-firm-management/api/dons/removeType?code=" + id).then(function(response) {
                    console.log(response);
                    $scope.getAllType();
                    $scope.removeTypeResponse= response.data;

                }).catch(function (response) {
                    $log.error("Data binding failed with:", response.status, response.statusText, daresponseta.data);
                }).finally(function () {
                    $log.log("Finally finished data biding.");
                });;
            }
        }
    };
});

AppModule.directive('findType', function() {
    return {
        restrict: 'E',
        templateUrl: '/training-firm-management/partial/type.html',
        scope: {
            sectioncontent: "="
        },
        link: function($scope, scope, elem, attrs) {

        },
        controller: function($scope, $log,$http) {
     
            $scope.error="";
            $scope.$watch('sectioncontent', function(newValue, oldValue, scope) {
                //Do anything with $scope.letters
                if (newValue !== 'undefined' && newValue !== undefined) {
                    $scope.id = $scope.sectioncontent;
                        $http.get("/training-firm-management/api/dons/findType?code=" + $scope.id).then(function(response) {
                            console.log(response);
                            $scope.data = response.data;
                        }).catch(function (response) {
                            $log.error("Data binding failed with:", response.status, response.statusText, daresponseta.data);
                        }).finally(function () {
                            $log.log("Finally finished data biding.");
                        });;
                    
                }
            });
   
         
        }
    };
});



AppModule.directive('globalApp', function() {
    return {
        restrict: 'E',
        templateUrl: '/training-firm-management/partial/globalTemplate.html',
        scope: {
            sectioncontent: "="
        },
        link: function($scope, scope, elem, attrs) {

        },
        controller: function($scope, $log,$http) {
         $scope.employees=false;
         $scope.training=false;
$scope.buttonclicked=false;
         $scope.subject=false;
        }
        
    };
});




AppModule.directive('allSubject', function() {
    return {
        restrict: 'E',
        templateUrl: '/training-firm-management/partial/subjectTemplate.html',
        scope: {
        },
        link: function($scope, scope, elem, attrs) {

        },
        controller: function($scope, $log,$http) {
            $scope.showSpinner = true;
            $scope.addingItemError=false;
            $scope.addingItemSuccess=false;

            $scope.error="";
      
            $scope.getAllFormation = function(){            	
                $http.get("/training-firm-management/api/dons/getAllMatiere").then(function(rep) {
                    $scope.content = rep.data;
                    $scope.showSpinner=false;
                }).catch(function (data) {
                    $log.error("Data binding failed with:", data.status, data.statusText, data.data);
                }).finally(function () {
                    $log.log("Finally finished data biding.");
                });
            }
             $scope.getAllFormation();
            
                   $scope.addItem = function(employee,name,theme,salle) {
            	
                $http.post("/training-firm-management/api/dons/add/matiere/"+employee+"/"+name+"/"+theme+"/"+salle).then(function(response) {
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
                $http.delete("/training-firm-management/api/dons/removeMatiere?code=" + id).then(function(response) {
                    console.log(response);
                    $scope.getAllFormation();

                }).catch(function (response) {
                    $log.error("Data binding failed with:", response.status, response.statusText, daresponseta.data);
                }).finally(function () {
                    $log.log("Finally finished data biding.");
                });;
            }
    
    
    
       $scope.updateSelectedItem = function(employee,name,theme,salle) {
       console.log(name);
            	$scope.dataFormation.name = name;
                $http.put("/training-firm-management/api/dons/modifyMatiere?id="+$scope.dataFormation.id+"&name="+name+"&theme="+theme+"&employee="+employee+"&salle="+salle).then(function(response) {
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
            	
             $http.get("/training-firm-management/api/dons/getSpecificMatiere?id=" + code).then(function(response) {
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
