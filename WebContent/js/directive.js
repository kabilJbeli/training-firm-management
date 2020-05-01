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
        		    $scope.showSpinner = false;
        		    $scope.content = $scope.sectioncontent[0].data;  
        		}
        	});
        
  
        }
    };
});


