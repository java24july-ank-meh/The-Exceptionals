angular.module('rhmsApp').controller('editComplexController', ['$scope', '$http', '$stateParams','$mdDialog','$state', function($scope, $http, $stateParams, $mdDialog, $state ) {


    $http.get("/api/ApartmentComplexes/"+$stateParams.complexId)
        .success(function(data) {
            $scope.complex = data;

        })
        .error(function(){
            alert("Error occured");
        });


    $scope.editComplexFormSubmit = function () {

        var onSuccess = function (data, status, headers, config) {
            alert("Complex updated.");
            $state.go('home.showComplex', { complexId: data });
        };

        var onError = function (data, status, headers, config) {
            alert('Error occured.');
        };

        
        $http.put('/api/ApartmentComplexes/'+$stateParams.complexId, $scope.complex )
        	.success(onSuccess)
        	.error(onError);

    };

    //6. create resetForm() function. This will be called on Reset button click.
    $scope.resetForm = function () {
        $scope.complex = "";
    };
}]);
