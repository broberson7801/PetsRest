package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Pet;

@Transactional
public class PetsDaoImpl implements PetsDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Pet> index() {
		String query = "SELECT * FROM pets";
		@SuppressWarnings("unchecked")
		List<Pet> pets = em.createNativeQuery(query).getResultList();
		return pets;
	}

	@Override
	public Pet show(int id) {
		return em.find(Pet.class, id);
	}

	@Override
	public Pet create(Pet pet) {
		em.persist(pet);
		em.flush();
		
		return em.find(Pet.class, pet.getId());
	}

	@Override
	public Pet update(int id, Pet pet) {
		Pet newPet = null;
		
		newPet=em.find(Pet.class, id);
		newPet.setName(pet.getName());
		newPet.setType(pet.getType());
		
		em.flush();
		return newPet;
	}

	@Override
	public boolean destroy(int id) {
		Pet pet = em.find(Pet.class, id);
		em.remove(pet);
		
		return true;
	}

	
}
