angular.module('rhmsApp').controller('createResidentController', ['$scope', '$http', '$mdDialog', function($scope, $http, $mdDialog) {


    $scope.newResidentFormSubmit = function (email) {

        var onSuccess = function (response) {
            alert(response.data.status);
        };

        var onError = function (response) {
            alert('Error occured.');
        }

        $http({
        	method: 'POST',
        	url:'/HousingOnlineManagementSystem/api/residents/create',
        	data:'email='+email,
        	headers:{'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(onSuccess,onError);

    };

    //6. create resetForm() function. This will be called on Reset button click.
    $scope.resetForm = function () {
        $scope.complex = "";
    };
}]);
