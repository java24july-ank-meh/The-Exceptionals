angular.module('rhmsApp').controller('showComplexController', ['$scope', '$mdBottomSheet','$mdSidenav', '$mdDialog','$http', '$stateParams', '$state','$mdToast', function($scope, $mdBottomSheet, $mdSidenav, $mdDialog, $http, $stateParams, $state, $mdToast) {
	$scope.error = false;
	$scope.announcement  = '';
	
	  $scope.showConfirm = function(deleteComplex) {

		    var confirm = $mdDialog.confirm()
		          .title('Do you really want to delete the Apartment Complex?')
		          .targetEvent(event)
		          .ok('Delete')
		          .cancel('Cancel');

		    $mdDialog.show(confirm).then(function() {
		      $scope.deleteComplex();
		    });
		  };

    $scope.deleteComplex = function () {

        var onSuccess = function (data, status, headers, config) {
        	 $mdToast.show($mdToast.simple().textContent("Complex Deleted").position('top right'));
            $state.go('home.complexes');
        };

        var onError = function (data, status, headers, config) {
        	 $mdToast.show($mdToast.simple().textContent("An Error Occured").position('top right'));
        };

        $http.delete('/api/ApartmentComplexes/'+$stateParams.complexId)
        	.success(onSuccess)
        	.error(onSuccess);

    };
    
     $http.get("/api/ApartmentComplexes/"+$stateParams.complexId).then(function(response) {

         $scope.complex = response.data;
         
         if($scope.complex === ''){
        	 $mdToast.show($mdToast.simple().textContent("Complex Not Found").position('top right'));
        	 $scope.error = true;
         } else {
        	 
        	 /*var parsedAddress = "https://www.google.com/maps/embed/v1/directions?key=AIzaSyC9rOv9rx7A2EL0oOZGXkhuvkJYIVfkqGA&origin="+$scope.complex.address.split(' ').join('+')+"&destination=11730+Plaza+America+Drive,+Reston,+VA&avoid=tolls|highways";
        	 document.getElementById('complexMap').src = parsedAddress;*/
         }
         
     });
     
	  $scope.showCreateApartmentForm = function(ev) {
		  
		  $mdDialog.show({
			  controller: 'createApartmentController',
			  templateUrl: '/../../Apartments/Create/create.html',
			  parent: angular.element(document.body),
			  targetEvent: ev,
			  clickOutsideToClose:true,
			  fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
		  });
			  
	  };
	  
	  $scope.sendAnnouncementFormSubmit = function(event){
		  
		  var onSuccess = function (data, status, headers, config) {
	            
	        	 $mdToast.show($mdToast.simple().textContent("Message sent!").position('top right'));
	            
	        };

	        var onError = function (data, status, headers, config) {
	        	 $mdToast.show($mdToast.simple().textContent("An Error Occured").position('top right'));
	        }

	      /*  $stateParams.complexId*/
	        $http.post('/api/ApartmentComplexes/message/'+$stateParams.complexId, $scope.announcement )
	            .success(onSuccess)
	            .error(onError);

		  
	  };

}]);