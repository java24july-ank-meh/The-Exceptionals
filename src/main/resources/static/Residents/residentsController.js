angular.module('rhmsApp').controller('residentsController', function ($scope, $filter, NgTableParams, $http) {
	
	
	/*$scope.residentsTable = new NgTableParams({}, { getData: function(response) {
		return $http.get("/api/Residents").then(function(response) {
			console.log(response.data)
	        return response.data;        
	    });
	}});*/
	
	$http.get("/api/Residents").then(function(response) {
		$scope.residentsTable = new NgTableParams({}, { dataset: response.data});      
    });
	$http.get("/api/ApartmentComplexes").then(function(response) {
		$scope.complexes = [];
		response.data.forEach(function(element) {
			$scope.complexes.push({id: element.name, title: element.name})
		});
		console.log($scope.complexes);
		//$scope.complexes = response.data;
	});
	//$scope.complexes = $scope.names = [{id: "", title: ""}, {id: 'Moroni', title: 'loloooollo'}, {id: 'Enos', title: 'Enos'}, {id: 'Nephi', title: 'Nephi'}];
	
	
});
