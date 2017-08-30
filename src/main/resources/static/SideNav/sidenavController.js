angular.module('rhmsApp').controller('sidenavController', ['$scope', '$mdBottomSheet','$mdSidenav', '$mdDialog', '$http', function($scope, $mdBottomSheet, $mdSidenav, $mdDialog, $http){
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
            link : 'showApartment({apartmentId: resident.apartment})',
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
    
    $http.get("/api/sidenav").then(function(response) {
        $scope.userinfo = response.data;
        $scope.isManager = $scope.userinfo.isManager ? "Manager" : "Resident";
        if(!$scope.userinfo.isManager) {
        	console.log($scope.userinfo);
        	$http.get("/api/Residents/email/"+$scope.userinfo.email).then(function(response) {
                $scope.resident = response.data;
                console.log($scope.resident);
                if(!$scope.resident.apartment) {
                	$scope.userinfo.unnassigned = true;
                }
            });
        }
    });
    
}]);
