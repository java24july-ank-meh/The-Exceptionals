angular.module('rhmsApp').controller('showComplexController', ['$scope', '$mdBottomSheet','$mdSidenav', '$mdDialog','$http', '$stateParams', '$state', function($scope, $mdBottomSheet, $mdSidenav, $mdDialog, $http, $stateParams, $state) {


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
            alert("Complex deleted.");
            $state.go('home.complexes');
        };

        var onError = function (data, status, headers, config) {
            alert('Error occured.');
        };

        $http.delete('/api/ApartmentComplexes/'+$stateParams.complexId)
        	.success(onSuccess)
        	.error(onSuccess);

    };
    

     $http.get("/api/ApartmentComplexes/"+$stateParams.complexId).then(function(response) {

         $scope.complex = response.data;
         
     });
     
     
	  $scope.showCreateApartmentForm = function(ev) {
		  
			    $mdDialog.show({
			      controller: 'createApartmentController',
			      templateUrl: '/../../Apartments/Create/create.html',
			      parent: angular.element(document.body),
			      targetEvent: ev,
			      clickOutsideToClose:true,
			      fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
			    })
			    .then(function(answer) {
			      $scope.status = 'You said the information was "' + answer + '".';
			    }, function() {
			      $scope.status = 'You cancelled the dialog.';
			    });
			  
	  };



}]);