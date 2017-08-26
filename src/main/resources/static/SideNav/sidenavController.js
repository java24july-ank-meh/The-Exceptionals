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
    });
}]);
