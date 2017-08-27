package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.PetDAO;
import entities.Pet;

@RestController
public class PetController {

	@Autowired
	private PetDAO dao;

	@RequestMapping(path = "pingy", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	@RequestMapping(path = "pets", method = RequestMethod.GET)
	public List<Pet> index() {
		return dao.index();
	}

	@RequestMapping(path = "pets/{id}", method = RequestMethod.GET)
	public Pet show(@PathVariable int id) {
		return dao.show(id);
	}

	@RequestMapping(path = "pets", method = RequestMethod.POST)
	public Pet create(@RequestBody String petJson) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			Pet newPet = mapper.readValue(petJson, Pet.class);
			return dao.create(newPet);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(path = "pets/{id}", method = RequestMethod.PUT)
	public Pet update(@RequestBody String petJson, @PathVariable Integer id) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			Pet updatedPet = mapper.readValue(petJson, Pet.class);
			
			return dao.update(id, updatedPet);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@RequestMapping(path = "pets/{id}", method = RequestMethod.DELETE)
	public Boolean destroy(@PathVariable int id) {
		boolean destroyed = dao.destroy(id);
		return destroyed;
	}

}
