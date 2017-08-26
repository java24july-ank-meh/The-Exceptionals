angular.module('rhmsApp').controller('residentsController', function ($scope, $filter, NgTableParams, $http) {
	
	$http.get("/api/residents").then(function(response) {
        $scope.userinfo = response.data;
        $scope.usersTable = new NgTableParams({}, { dataset: $scope.userinfo});
    });

	
	
});
