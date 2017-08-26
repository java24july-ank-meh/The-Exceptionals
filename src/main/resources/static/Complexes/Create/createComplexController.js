angular.module('rhmsApp').controller('createComplexController', ['$scope', '$http', '$mdDialog','$state', function($scope, $http, $mdDialog, $state) {


    $scope.newComplexFormSubmit = function () {

        var onSuccess = function (data, status, headers, config) {
            
        	alert("Created Successfully" );
            $state.go('home.showComplex', { complexId: data});
            
        };

        var onError = function (data, status, headers, config) {
            alert('Error occured.');
        }

        $http.post('/api/ApartmentComplexes/create', $scope.complex )
            .success(onSuccess)
            .error(onError);

    };

    //6. create resetForm() function. This will be called on Reset button click.
    $scope.resetForm = function () {
        $scope.complex = "";
    };
}]);
