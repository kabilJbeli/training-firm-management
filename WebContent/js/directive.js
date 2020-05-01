AppModule.directive('allDon', function () {
    return {
        restrict: 'E',
        templateUrl: '/donManagement/partial/template.html',
        scope: {       
        	sectioncontent: "="
        },
        link: function ($scope, scope, elem, attrs) {
        
        },
        controller: function ($scope) {
		    $scope.showSpinner = true;

        	$scope.$watch('sectioncontent', function (newValue, oldValue, scope) {
        	    //Do anything with $scope.letters
        		if(newValue !== 'undefined' && newValue !== undefined){
        		    $scope.content = $scope.sectioncontent[0].data;  
        		    $scope.showSpinner = false;
        		}
        	});
        
  
        }
    };
});

AppModule.directive('removeDon', function () {
    return {
        restrict: 'E',
        templateUrl: '/donManagement/partial/remove.html',
        scope: {       
        	id: "="
        },
        link: function ($scope, scope, elem, attrs) {
        
        },
        controller: function ($scope,$http) {
$scope.deleteItem = function(){
$http.delete("http://localhost:8080/donManagement/api/dons/removeDon?code="+$scope.id).then(function(response){
	console.log(response);

	
});
        	}
        	console.log($scope.id);
        
  
        }
    };
});

