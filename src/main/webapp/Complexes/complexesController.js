angular.module('rhmsApp').controller('complexesController', ['$scope', '$mdBottomSheet','$http','$mdSidenav', '$mdDialog', function($scope, $mdBottomSheet, $mdSidenav, $mdDialog, $http) {

    /*$scope.complexes = [
        {
            id: 1,
            name : "Apartment Complex Name",
            phone: "9563133128",
            email: "mail@mail.com",
            address: "474 Elden St, Herndon, VA 20170",
            website: "www.site.com"
        },
        {
            id: 2,
            name : "Apartment Complex Name",
            phone: "9563133128",
            email: "mail@mail.com",
            address: "474 Elden St, Herndon, VA 20170",
            website: "www.site.com"
        },
        {
            id: 3,
            name : "Apartment Complex Name",
            phone: "9563133128",
            email: "mail@mail.com",
            address: "474 Elden St, Herndon, VA 20170",
            website: "www.site.com"
        },
        {
            id: 4,
            name : "Apartment Complex Name",
            phone: "9563133128",
            email: "mail@mail.com",
            address: "474 Elden St, Herndon, VA 20170",
            website: "www.site.com"
        },
        {
            id: 6,
            name : "Apartment Complex Name",
            phone: "9563133128",
            email: "mail@mail.com",
            address: "474 Elden St, Herndon, VA 20170",
            website: "www.site.com"
        },
        {
            id: 5,
            name : "Apartment Complex Name",
            phone: "9563133128",
            email: "mail@mail.com",
            address: "474 Elden St, Herndon, VA 20170",
            website: "www.site.com"
        }
    ];*/

     $http.get("/HousingOnlineManagementSystem/api/ApartmentComplexes/").then(function(response) {
         $scope.complexes = response.data;
     });

}]);