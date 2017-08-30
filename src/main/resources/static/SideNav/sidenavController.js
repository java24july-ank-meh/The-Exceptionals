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
            link : '.showApartment({apartmentId: rootResident.apartment})',
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
        $rootScope.rootUser = response.data;
        $rootScope.rootTest = "test two";
        $scope.isManager = $rootScope.rootUser.isManager ? "Manager" : "Resident";
        if(!$rootScope.rootUser.isManager) {
        	$http.get("/api/Residents/email/"+$rootScope.rootUser.email).then(function(response) {
                $rootScope.rootResident = response.data;
                if(!$rootScope.rootResident.apartment) {
                	//do a thing to disable clicking on apartment
                }
            });
        }
    });
    
}]);
