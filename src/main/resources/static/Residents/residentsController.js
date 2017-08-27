angular.module('rhmsApp').controller('residentsController', function ($scope, $filter, NgTableParams, $http) {
	
	
	$scope.residentsTable = new NgTableParams({}, { getData: function(response) {
		return $http.get("/api/Residents").then(function(response) {
	        return response.data;        
	    });
	}});
	
});
