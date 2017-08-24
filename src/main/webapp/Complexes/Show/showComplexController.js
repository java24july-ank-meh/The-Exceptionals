angular.module('rhmsApp').controller('showComplexController', ['$scope', '$mdBottomSheet','$http','$mdSidenav', '$mdDialog', function($scope, $mdBottomSheet, $mdSidenav, $mdDialog, $http) {

       $scope.complex =
        {
            id: 4,
            name : "Apartment Complex Name",
            phone: "9563133128",
            email: "mail@mail.com",
            address: "474 Elden St, Herndon, VA 20170",
            website: "www.site.com"
        };
    $scope.complex.apartments = [
        {
            id: 1,
            number : "408A",
            capacity: 6,
            occupancy: 6,
        },
        {
            id: 2,
            number : "100",
            capacity: 6,
            occupancy: 3,
        },
        {
            id: 3,
            number : "200",
            capacity: 5,
            occupancy: 4,
        },
        {
            id: 4,
            number : "300A",
            capacity: 6,
            occupancy: 4,
        },
        {
            id: 5,
            number : "108",
            capacity: 4,
            occupancy: 3,
        },

    ];

    // $http.get("/HousingOnlineManagementSystem/api/ApartmentComplexes/").then(function(response) {
    //     $scope.complexes = response.data;
    // });

}]);