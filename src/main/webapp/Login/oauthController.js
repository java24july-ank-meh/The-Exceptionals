angular.module('rhmsApp').controller('oauthController', ['$scope', '$http', '$location', function($scope, $http, $location){
	var paramValue = $location.search().code; 
	
	$http.get("/HousingOnlineManagementSystem/api/login/oauth",{params: {code : paramValue}}).then(function(response) {
		//$scope.user = response.data;
/*		console.log(response.data);*/
		$location.path("/home/dashboard");
    });
}]);