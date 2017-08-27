angular.module('appModule')
	.component('petList', {
		
		templateUrl : "app/appModule/pet.component.html",
		
		controller : function(petService) { 
			var vm = this;
			
			vm.hideEditForm = true;
			
			//vm.petsAarray = [];
			
			petService.index().then(function(response) {
				vm.petsArray =response.data;
				
			})
			
			vm.costOfPets = function() {
				petService.index().then(function(response) {
					vm.petsArray  = response.data;
					vm.petsCost = vm.petsArray.length * 1270;
					return vm.petsCost;
				})
			}
			
			vm.petsCost = vm.costOfPets();
			
			
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
				petService.show(id).then(function(response) {
					vm.onePet  = response.data;
					vm.hideEditForm = false;
					
				});
			}
			
			vm.editPet = function(id,pet) {
				petService.update(id, pet).then(function(response) {
					vm.editedPet = response.data;
					console.log("editPet called");
					console.log(vm.editedPet);
				})
			}
			
			
		},
		
		controllerAs : 'vm'
		
	});