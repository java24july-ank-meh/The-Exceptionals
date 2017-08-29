angular.module('rhmsApp').controller('createResidentController', ['$scope', '$http', '$mdDialog','$state', '$stateParams', '$mdToast', function($scope, $http, $mdDialog, $state, $stateParams, $mdToast) {


    $http.get("/api/Residents/")
    .then(function(response) {
        $scope.residents = response.data;
    });

	
	
    $scope.createResidentFormSubmit = function () {

        var onSuccess = function (data, status, headers, config) {
        	$mdToast.show($mdToast.simple().textContent("Resident Created").position('top right'));
            $state.go('home.residents');
            $scope.hide();
            
        };

        var onError = function (data, status, headers, config) {
        	$mdToast.show($mdToast.simple().textContent("An Error Occured").position('top right'));
        }
        
        //uncomment when unnassigned apartment is created
        //$scope.resident.apartmentId = 0; //assign to the unnassigned complex

        $http.post('/api/Residents/create', $scope.resident)
            .success(onSuccess)
            .error(onError);

    };
    
    $scope.hide = function() {
        $mdDialog.hide();
      };

      $scope.cancel = function() {
        $mdDialog.cancel();
      };
      
      
 	 /*$scope.assignResident = function (residentId) {

 	      var onSuccess = function (data, status, headers, config) {
 	    	  $mdToast.show($mdToast.simple().textContent("Resident Assigned").position('top right'));
 	          $scope.hide();
 	         $state.reload();
 	      };

 	      var onError = function (data, status, headers, config) {
 	    	  $mdToast.show($mdToast.simple().textContent(data));
 	      };

 	      $http.post('/api/Apartments/'+$stateParams.apartmentId+'/Resident/'+residentId)
 	      	.success(onSuccess)
 	      	.error(onSuccess);

 	  };*/


    //6. create resetForm() function. This will be called on Reset button click.
    $scope.resetForm = function () {
        $scope.resident = "";
    };
}]);
