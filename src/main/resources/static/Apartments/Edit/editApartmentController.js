angular.module('rhmsApp').controller('editApartmentController', ['$scope', '$http', '$mdDialog','$state', '$stateParams', function($scope, $http, $mdDialog, $state, $stateParams) {

    $http.get("/api/Apartments/"+$stateParams.apartmentId)
    .success(function(data) {
        $scope.apartment = data;

    })
    .error(function(){
        alert("Error occured");
    });

	
    $scope.editApartmentFormSubmit = function () {

        var onSuccess = function (data, status, headers, config) {
        	alert("Updated Successfully" );
            $state.go('home.showComplex', { complexId: $scope.apartment.complexId});
            $scope.hide();
            
        };

        var onError = function (data, status, headers, config) {
            alert('Error occured.');
        }
        
        $http.put('/api/Apartments/'+$stateParams.apartmentId, $scope.apartment)
            .success(onSuccess)
            .error(onError);

    };
    
    $scope.hide = function() {
        $mdDialog.hide();
      };

      $scope.cancel = function() {
        $mdDialog.cancel();
      };


    //6. create resetForm() function. This will be called on Reset button click.
    $scope.resetForm = function () {
        $scope.apartment = "";
    };
}]);
