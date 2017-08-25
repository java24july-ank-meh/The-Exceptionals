angular.module('rhmsApp').controller('editComplexController', ['$scope', '$http', '$stateParams','$mdDialog', function($scope, $http, $stateParams, $mdDialog ) {

    $http.get("/HousingOnlineManagementSystem/api/ApartmentComplexes/"+$stateParams.complexId)
        .success(function(data) {
            $scope.complex = data;
        })
        .error(function(){
            alert("Error occured");
        });


    $scope.newComplexFormSubmit = function () {

        var onSuccess = function (data, status, headers, config) {
            alert('Complex saved successfully.');
        };

        var onError = function (data, status, headers, config) {
            alert('Error occured.');
        };

        $http.post('/RevatureHousingManagementSystem/ApartmentComplexes/'+$scope.complex.id, { complex:$scope.complex })
            .success(onSuccess)
            .error(onError);

    };

    //6. create resetForm() function. This will be called on Reset button click.
    $scope.resetForm = function () {
        $scope.complex = "";
    };
}]);
