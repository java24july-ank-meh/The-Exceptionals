angular.module('rhmsApp').controller('showResidentController', ['$scope', '$mdBottomSheet','$mdSidenav', '$mdDialog','$http', '$stateParams', '$state', '$rootScope', function($scope, $mdBottomSheet, $mdSidenav, $mdDialog, $http, $stateParams, $state, $rootScope) {
	
	
	  $scope.showConfirm = function(deleteResident) {

		    var confirm = $mdDialog.confirm()
		          .title('Do you really want to delete the Resident?')
		          .targetEvent(event)
		          .ok('Delete')
		          .cancel('Cancel');

		    $mdDialog.show(confirm).then(function() {
		      $scope.deleteResident();
		    });
		  };

	
    $scope.deleteResident = function () {

        var onSuccess = function (data, status, headers, config) {
            alert("Resident deleted.");
            $state.go('home.residents');
        };

        var onError = function (data, status, headers, config) {
            alert('Error occured.');
        };

        $http.delete('/api/Residents/', $stateParams.residentId)
        	.success(onSuccess)
        	.error(onError);

    };
    

     $http.get("/api/Residents/"+$stateParams.residentId).then(function(response) {

         $scope.resident = response.data;
         console.log(response.data);
     });
     
     
     $scope.showEditResidentForm = function(ev){
    	
    	 $mdDialog.show({
    		 controller: 'editResidentController',
    		 templateUrl: '/../../Residents/Edit/edit.html',
    		 parent: angular.element(document.body),
    		 targetEvent: ev,
    		 clickOutsideToClose: true,
    		 fullscreen: $scope.customFullScreen
    	 });
    	 
     };

}]);