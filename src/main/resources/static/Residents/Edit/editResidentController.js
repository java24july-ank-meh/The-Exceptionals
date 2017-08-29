angular.module('rhmsApp').controller('editResidentController', ['$scope', '$http', '$mdDialog', '$state', '$stateParams', '$mdToast', function($scope, $http, $mdDialog, $state, $stateParams, $mdToast){
	
	$http.get("api/Residents/"+$stateParams.residentId)
	.success(function(data){
		$scope.resident = data;
	})
	.error(function(){
		$mdToast.show($mdToast.simple().textContent("An Error Occured").position('top right'));
	});
	
	$scope.editResidentFormSubmit = function(){
		
		var onSuccess = function(data, status, headers, config) {
			$mdToast.show($mdToast.simple().textContent("Resident Updated").position('top right'));
			$state.reload();
			$scope.hide();
		};
		
		var onError = function(data, status, headers, config) {
			$mdToast.show($mdToast.simple().textContent("An Error Occured").position('top right'));
		};
		
		$http.put('/api/Residents/'+$stateParams.residentId, $scope.resident)
			.success(onSuccess)
			.error(onError);
		
	};
	
	$scope.hide = function() {
		$mdDialog.hide();
	};
	
	$scope.cancel = function(){
		$mdDialog.cancel();
	};
	
	$scope.resetForm = function() {
		$scope.resident = "";
	};
}]);
