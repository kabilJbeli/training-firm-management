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
            $http.get("/training-firm-management/api/dons/getTypeList").then(function(rep) {
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
            $scope.updateSelectedItem = function(quantity,desc,option,affectation) {
            	$scope.dataDon.description = desc;
            	$scope.dataDon.quantity = quantity;
            	$scope.dataDon.affectation = affectation;
                $http.put("/training-firm-management/api/dons/modifyDon?typeid="+option[0],JSON.stringify($scope.dataDon)).then(function(response) {
                    console.log(response);
                    $scope.getAllDons();
                    
                }).catch(function (response) {
                    $log.error("Data binding failed with:", response.status, response.statusText, daresponseta.data);
                }).finally(function () {
                    $log.log("Finally finished data biding.");
                });;
           	
               }
            
            
         $scope.updateDon = function(code) {
            	
             $http.get("/training-firm-management/api/dons/getSpecificDon?id=" + code).then(function(response) {
                 console.log(response);
                 $scope.updatequantity = response.data.quantity;
                 $scope.updatedescription = response.data.description;
                 $scope.updateaffectation = response.data.affectation;
                 $scope.updateOption = [response.data.type.id,response.data.type.name,response.data.type.quantite];

                 $scope.dataDon = {
                		 id:response.data.id,
                		 description:$scope.updatedescription,
                		 quantity:$scope.updatequantity,
                		 affectation: response.data.affectation,
                		 type:response.data.type
                 };
                 
             }).catch(function (response) {
                 $log.error("Data binding failed with:", response.status, response.statusText, daresponseta.data);
             }).finally(function () {
                 $log.log("Finally finished data biding.");
             });;
        	
            }
            
            
            
            
            
            
            $scope.addType = function(quantity,name) {
               $scope.data = {    

                       name: name,
            		   quantite: quantity

                    };
                $http.post("/training-firm-management/api/dons/addType", JSON.stringify($scope.data)).then(function(response) {
                    $scope.addingItemError=false;
                    $scope.addingItemSuccess=true;
                	$scope.getAllType();
                      
                }).catch(function (data) {
                    $log.error("Data binding failed with:", data.status, data.statusText, data.data);
                    $scope.addingItemError=true;
                    $scope.error = data.status;
                }).finally(function () {
                    $log.log("Finally finished data biding.");
                });;
            }
            
            $scope.displayitem =  function(index){
            	console.log(index)
            	if(index === "4"){
            		return true;
            	}else{
            		return false;
            	}
            }
            $scope.addItem = function(quantity,description,type) {
            	
                $http.post("/training-firm-management/api/dons/add/"+type[0]+"/Non Affecté/"+quantity+"/"+description).then(function(response) {
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
                $http.delete("/training-firm-management/api/dons/removeDon?code=" + id).then(function(response) {
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
        }
        
    };
});
