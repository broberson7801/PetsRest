angular.module('appModule')
.factory('factService', function($http) {
  var service = {};

  var BASE_URL = 'http://localhost:8080/RestPets/';

  service.index = function() {
    return $http({
      method : 'GET',
      url : BASE_URL + 'api/facts'
    })
  };

  service.show = function(id) {
    return $http({
      method : 'GET',
      url : `${BASE_URL}/${id}`
    })
  }

  service.create = function(pet) {
    return $http({
      method : 'POST',
      url : BASE_URL,
      headers : {
        'Content-Type' : 'application/json'
      },
      data : fact
    })
  };

  service.update = function(id, pet) {
    return $http({
      method : 'PUT',
      url : `${BASE_URL}/${id}`,
      headers : {
        'Content-Type' : 'application/json'
      },
      data : fact
    })
  };

  service.destroy = function(id) {
    return $http({
      method : 'DELETE',
      url : `${BASE_URL}/${id}`
    })
  };

  return service;
})