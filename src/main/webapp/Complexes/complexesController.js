angular.module('rhmsApp').controller('complexesController', ['$scope', '$mdBottomSheet','$mdSidenav', '$mdDialog', function($scope, $mdBottomSheet, $mdSidenav, $mdDialog) {

    $scope.complexes = [
        {
            complexName : "Apartment Complex Name1",
            phone: "9563133128",
            email: "mail@mail.com",
            address: "474 Elden St, Herndon, VA 20170",
            website: "www.site.com"
        },
        {
            complexName : "Apartment Complex Name2",
            phone: "9563133128",
            email: "mail@mail.com",
            address: "474 Elden St, Herndon, VA 20170",
            website: "www.site.com"
        },
        {
            complexName : "Apartment Complex Name3",
            phone: "9563133128",
            email: "mail@mail.com",
            address: "474 Elden St, Herndon, VA 20170",
            website: "www.site.com"
        },
        {
            complexName : "Apartment Complex Name4",
            phone: "9563133128",
            email: "mail@mail.com",
            address: "474 Elden St, Herndon, VA 20170",
            website: "www.site.com"
        },
        {
            complexName : "Apartment Complex Name5",
            phone: "9563133128",
            email: "mail@mail.com",
            address: "474 Elden St, Herndon, VA 20170",
            website: "www.site.com"
        },
        {
            complexName : "Apartment Complex Name6",
            phone: "9563133128",
            email: "mail@mail.com",
            address: "474 Elden St, Herndon, VA 20170",
            website: "www.site.com"
        }
    ]

}]);