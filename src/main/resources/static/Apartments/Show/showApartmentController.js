angular.module('rhmsApp').controller('showApartmentController', ['$scope', '$mdBottomSheet','$http','$mdSidenav', '$mdDialog', function($scope, $mdBottomSheet, $mdSidenav, $mdDialog, $http) {

    $scope.apartment =
        {
            id: 2,
            number : "100",
            capacity: 6,
            occupancy: 3,
        };
    $scope.apartment.residents = [
        {
            id: 1,
            firstName : "John",
            lastName: "Doe",
            phone: "9563133128",
            email: "person@email.com",
        },
        {
            id: 3,
            firstName : "Jerry",
            lastName: "Jones",
            phone: "9563133128",
            email: "person2@email.com",
        },

    ];

    // $http.get("/api/ApartmentComplexes/").then(function(response) {
    //     $scope.complexes = response.data;
    // });

}]);