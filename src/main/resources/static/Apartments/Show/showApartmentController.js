angular.module('rhmsApp').controller('showApartmentController', ['$scope', '$mdBottomSheet','$http', '$mdDialog','$stateParams','$state', function($scope, $mdBottomSheet,$http, $mdDialog, $stateParams, $state ) {


     $http.get("/api/Apartments/"+$stateParams.apartmentId).then(function(response) {
         $scope.apartment = response.data;
         

         $http.get("/api/ApartmentComplexes/"+$scope.apartment.complexId).then(function(response) {
        	 $scope.complex = response.data;
         });
     });
     
	  $scope.showConfirm = function(deleteApartment) {

		    var confirm = $mdDialog.confirm()
		          .title('Do you really want to delete the Apartment?')
		          .targetEvent(event)
		          .ok('Delete')
		          .cancel('Cancel');

		    $mdDialog.show(confirm).then(function() {
		      $scope.deleteApartment();
		    });
		  };

  $scope.deleteApartment = function () {

      var onSuccess = function (data, status, headers, config) {
          alert("Apartment deleted.");
          $state.go('home.showComplex', { complexId: $scope.apartment.complexId});
      };

      var onError = function (data, status, headers, config) {
          alert('Error occured.');
      };

      $http.delete('/api/Apartments/'+$stateParams.apartmentId)
      	.success(onSuccess)
      	.error(onSuccess);

  };
  
  $scope.showEditApartmentForm = function(ev) {
	  
	    $mdDialog.show({
	      controller: 'editApartmentController',
	      templateUrl: '/../../Apartments/Edit/edit.html',
	      parent: angular.element(document.body),
	      targetEvent: ev,
	      clickOutsideToClose:true,
	      fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
	    });
};

  

}]);