angular.module('rhmsApp').controller('logoutController', ['$scope', '$state', '$rootScope', function($scope, $state, $rootScope){
	delete $rootScope.rootUser;
	delete $rootScope.rootResident;
	$state.go("login", {}, {reload: true});

}]);

