angular.module('rhmsApp').controller('showApartmentController', ['$scope', '$mdBottomSheet','$http', '$mdDialog','$stateParams','$state' ,'$mdToast', function($scope, $mdBottomSheet,$http, $mdDialog, $stateParams, $state, $mdToast ) {

	$scope.error = false;
	
     $http.get("/api/Apartments/"+$stateParams.apartmentId).then(function(response) {
         $scope.apartment = response.data;
         
         if($scope.apartment === ''){

        	 $mdToast.show($mdToast.simple().textContent("Apartment not found").position('top right'));
        	 $scope.error = true;
         }
         else
        	$http.get("/api/ApartmentComplexes/"+$scope.apartment.complexId).then(function(response) {
        	 $scope.complex = response.data;
         });
         
     },function (response){
    	   $mdToast.show($mdToast.simple().textContent(response));
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
    	  $mdToast.show($mdToast.simple().textContent("Apartment Deleted").position('top right'));
          $state.go('home.showComplex', { complexId: $scope.apartment.complexId});
      };

      var onError = function (data, status, headers, config) {
    	  $mdToast.show($mdToast.simple().textContent(data));
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