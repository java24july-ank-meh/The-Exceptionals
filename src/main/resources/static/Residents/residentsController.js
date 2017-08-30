angular.module('rhmsApp').controller('residentsController', ['$scope', '$mdBottomSheet','$http', '$mdDialog','$stateParams','$state' ,'$mdToast', '$filter', 'NgTableParams', function($scope, $mdBottomSheet,$http, $mdDialog, $stateParams, $state, $mdToast, $filter, NgTableParams) {

	$http.get("/api/ApartmentComplexes").then(function(response) {
		$scope.complexes = [];
		$scope.residentData = [];
		response.data.forEach(function(complex) {
			$scope.complexes.push({id: complex.name, title: complex.name})
			if(complex.apartments){
				complex.apartments.forEach(function(apartment) {
					
					if(apartment.residents){ 
						apartment.residents.forEach(function(resident) {
							resident.apartmentNumber = apartment.apartmentNumber;
							resident.complexName = complex.name;
							$scope.residentData.push(resident);
							
						});
					} else {
						$scope.residentData.push({"firstName":"No resident","apartment":apartment.apartmentNumber.toString(),"complexName":complex.name});
					}
				});
			} else {
				$scope.residentData.push({"apartment":"No Apartment","complexName":complex.name});
			}
		});
		console.log($scope.complexes)
		$scope.residentsTable = new NgTableParams({}, { dataset: $scope.residentData});	
		console.log($scope.residentData);
		//$scope.complexes = response.data;
	});
	//$scope.complexes = $scope.names = [{id: "", title: ""}, {id: 'Moroni', title: 'loloooollo'}, {id: 'Enos', title: 'Enos'}, {id: 'Nephi', title: 'Nephi'}];
	
	$scope.showCreateResidentForm = function(ev) {
		  
		  $mdDialog.show({
			  controller: 'createResidentController',
			  templateUrl: '/../../Residents/Create/createResident.html',
			  parent: angular.element(document.body),
			  targetEvent: ev,
			  clickOutsideToClose:true,
			  fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
		  });
			  
	  };
	
}]);
