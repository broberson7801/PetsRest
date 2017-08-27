angular.module('appModule')
	.component('petList', {
		
		templateUrl : "app/appModule/pet.component.html",
		
		controller : function(petService) { 
			var vm = this;
			
			petService.index().then(function(response) {
				vm.petsArray = []
				vm.petsArray.push(response.data);
				console.log(vm.petsArray);
				
			})
			
			
			vm.createPet = function(pet) {
				petService.create(pet).then(function(response) {
					vm.pets = response.data;
				
				})
			
			};
			
			vm.destroyPet = function(id) {
				petService.destroy(id);
			}
			
			vm.onePet = {};
			
			vm.showPet = function(id) {
				vm.pet = petService.show(id);
				console.log("showPet called");
				console.log(vm.pet);
			}
			
		},
		
		controllerAs : 'vm'
		
	});