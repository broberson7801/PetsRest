angular.module('appModule')
.factory('petService', function($http) {
  var service = {};

  var BASE_URL = 'http://localhost:8080/RestPets/api/';

  service.index = function() {
    return $http({
      method : 'GET',
      url : BASE_URL + 'pets'
    })
  };

  service.show = function(id) {
    return $http({
      method : 'GET',
      url : `${BASE_URL}pets/${id}`
    })
  }

  service.create = function(pet) {
    return $http({
      method : 'POST',
      url : BASE_URL + 'pets',
      headers : {
        'Content-Type' : 'application/json'
      },
      data : pet
    })
  };

  service.update = function(id, pet) {
    return $http({
      method : 'PUT',
      url : `${BASE_URL}pets/${id}`,
      headers : {
        'Content-Type' : 'application/json'
      },
      data : pet
    })
  };

  service.destroy = function(id) {
    return $http({
      method : 'DELETE',
      url : `${BASE_URL}pets/${id}`
    })
  };

  return service;
})