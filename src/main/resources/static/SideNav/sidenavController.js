angular.module('rhmsApp').controller('sidenavController', ['$scope', '$mdBottomSheet','$mdSidenav', '$mdDialog', '$http', '$rootScope', function($scope, $mdBottomSheet, $mdSidenav, $mdDialog, $http, $rootScope){
    $scope.toggleSidenav = function(menuId) {
        $mdSidenav(menuId).toggle();
    };
    $scope.menu = [
        {
            link : '.dashboard',
            title: 'Dashboard',
            icon: 'dashboard'
        },
        {
            link : '.complexes',
            title: 'Complexes',
            icon: 'business'
        },
        {
            link : '.residents',
            title: 'Residents',
            icon: 'group'
        }
    ];
    $scope.residentMenu = [
		{
            link : '.dashboard',
            title: 'Dashboard',
            icon: 'dashboard'
        },
        {
            link : '.showApartment({apartmentId: resident.apartment})',
            title: 'Apartment',
            icon: 'business'
        },
        {
            link : 'home.resources()',
            title: 'Resources',
            icon: 'bookmark'
        }
    ];
    $scope.admin = [
        {
            link : '',
            title: 'Trash',
            icon: 'delete'
        },
        {
            link : '',
            title: 'Settings',
            icon: 'settings'
        }
    ];
    $scope.residentApartment = 'Apartment';
    $http.get("/api/sidenav").then(function(response) {
        $scope.rootUser = response.data;
        $rootScope.rootTest = "test";
        $scope.isManager = $scope.rootUser.isManager ? "Manager" : "Resident";
        if(!$scope.rootUser.isManager) {
        	$http.get("/api/Residents/email/"+$scope.rootUser.email).then(function(response) {
                $scope.rootResident = response.data;
                if(!$scope.rootResident.apartment) {
                	//do a thing to disable clicking on apartment
                }
            });
        }
    });
    
}]);
