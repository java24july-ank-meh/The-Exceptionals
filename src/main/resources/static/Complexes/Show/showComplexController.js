angular.module('rhmsApp').controller('showComplexController', ['$scope', '$mdBottomSheet','$mdSidenav', '$mdDialog','$http', '$stateParams', '$state', function($scope, $mdBottomSheet, $mdSidenav, $mdDialog, $http, $stateParams, $state) {

       /*$scope.complex =
        {
            id: 4,
            name : "Apartment Complex Name",
            phone: "9563133128",
            email: "mail@mail.com",
            address: "474 Elden St, Herndon, VA 20170",
            website: "www.site.com"
        };*/
    
    //the jankiest of implementations. takes the apartment id from the url (avoids having to use sessions until we figure that out)
    //let complexid = window.location.hash.substring(17);
	
	
	  $scope.showConfirm = function(deleteComplex) {

		    var confirm = $mdDialog.confirm()
		          .title('Do you really want to delete the Apartment Complex?')
		          .targetEvent(event)
		          .ok('Delete')
		          .cancel('Cancel');

		    $mdDialog.show(confirm).then(function() {
		      $scope.deleteComplex();
		    });
		  };

	
    $scope.deleteComplex = function () {

        var onSuccess = function (data, status, headers, config) {
            alert("Complex deleted.");
            $state.go('home.complexes');
        };

        var onError = function (data, status, headers, config) {
            alert('Error occured.');
        };

        $http.delete('/api/ApartmentComplexes/'+$stateParams.complexId)
        	.success(onSuccess)
        	.error(onSuccess);

    };
    

     $http.get("/api/ApartmentComplexes/"+$stateParams.complexId).then(function(response) {

         $scope.complex = response.data;
         
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
     });

}]);