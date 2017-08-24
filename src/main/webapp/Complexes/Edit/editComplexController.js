angular.module('rhmsApp').controller('editComplexController', ['$scope', '$http', '$stateParams','$mdDialog', function($scope, $http, $stateParams, $mdDialog ) {

   $scope.complex= {
        id: $stateParams.complexId,
        name : "Apartment Complex Name4",
        phone: "9563133128",
        email: "mail@mail.com",
        address: "474 Elden St, Herndon, VA 20170",
        website: "www.site.com"
    };

    $http.get("/HousingOnlineManagementSystem/api/ApartmentComplexes/"+$stateParams.complexId).then(function(response) {
        $scope.complex = response.data;
    });


    $scope.newComplexFormSubmit = function () {

        var onSuccess = function (data, status, headers, config) {
            alert('Complex saved successfully.');
        };

        var onError = function (data, status, headers, config) {
            alert('Error occured.');
        }

        $http.post('/RevatureHousingManagementSystem/ApartmentComplexes/create', { complex:$scope.complex })
            .success(onSuccess)
            .error(onError);

    };

    //6. create resetForm() function. This will be called on Reset button click.
    $scope.resetForm = function () {
        $scope.complex = "";
    };
}]);
