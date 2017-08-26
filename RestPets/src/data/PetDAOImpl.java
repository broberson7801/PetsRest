package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Pet;

@Transactional
public class PetDAOImpl implements PetDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Pet> index() {
		String query = "SELECT * FROM pets";
		List<Pet> pets = em.createNativeQuery(query).getResultList();
		return pets;
	}

	@Override
	public Pet create(Pet pet) {
		em.persist(pet);
		em.flush();

		return em.find(Pet.class, pet.getId());
	}

	@Override
	public Pet show(int id) {
		return em.find(Pet.class, id);
	}

	@Override
	public Pet update(int pid, Pet pet) {

		Pet managed = em.find(Pet.class, pid);
		managed.setName(pet.getName());
		managed.setNickName(pet.getNickName());
		managed.setType(pet.getType());

		em.persist(managed);
		em.flush();

		return em.find(Pet.class, managed.getId());
	}

	@Override
	public Boolean destroy(int id) {
		Pet pet = em.find(Pet.class, id);
		em.remove(pet);
		return true;
	}

}
