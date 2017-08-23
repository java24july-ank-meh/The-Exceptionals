angular.module('rhmsApp').controller('residentsController', ['$scope', '$mdBottomSheet','$mdSidenav', '$mdDialog', 'NgTableParams', function($scope, $mdBottomSheet, $mdSidenav, $mdDialog, NgTableParams) {

	var self = this;
	var data = [{name: "Moroni", age: 50} /*,*/];
	self.tableParams = new NgTableParams({}, { dataset: data});
}]);
