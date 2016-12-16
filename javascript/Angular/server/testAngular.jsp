<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="${pageContext.request.contextPath }/resource/img/favicon.ico" />
<link rel="bookmark" href="${pageContext.request.contextPath }/resource/img/favicon.ico"/>
<title>Test-angular</title>
</head>
<body>
	<div ng-app="myApp" ng-controller="myCtrl">
		<h1>{{test}}</h1>
		<h1>{{g.name + ' ' + g.phoneNo}}</h1>
		<h1>{{y.name + ' ' + y.phoneNo}}</h1>
	</div>
	
	<script src="https://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>
	<script>
		var app = angular.module('myApp', []);
		app.controller('myCtrl', function($scope, $http) {
			$scope.test = 'Test';
			$http.get('${pageContext.request.contextPath }/json').success(function(response) {
				$scope.g = response.g;
				$scope.y = response.y;
			});
		});
	</script>
</body>
</html>