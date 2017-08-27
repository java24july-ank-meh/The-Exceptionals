angular.module('rhmsApp').controller('showApartmentController', ['$scope', '$mdBottomSheet','$http', '$mdDialog','$stateParams', function($scope, $mdBottomSheet,$http, $mdDialog, $stateParams ) {


     $http.get("/api/Apartments/"+$stateParams.apartmentId).then(function(response) {
         $scope.apartment = response.data;
         

         $http.get("/api/ApartmentComplexes/"+$scope.apartment.complexId).then(function(response) {
        	 $scope.complex = response.data;
         });
     });

}]);