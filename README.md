# PetsRest

This is a basic API that allows you to enter a pet name, a pet type, and that's it. You can see all pets entered, you can add a pet via POSTMAN or URL, you can delete a pet and edit a pet. Again, that's it.

//the below will show all pets
http://13.59.188.136:8080/PetsRest/api/pets/

//the below will show one pet
http://13.59.188.136:8080/PetsRest/api/pets/2

An example of a JSON object to pass via POSTMAN "PUT" method:
{
	"name": "koala",
	"type": "a koala. Ooooo"
}
