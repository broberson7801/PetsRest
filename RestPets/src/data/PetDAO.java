package data;

import java.util.List;

import entities.Pet;

public interface PetDAO {
	
	public List<Pet> index();
	public Pet create(Pet pet);
	public Pet show(int id);
	public Pet update(int pid, Pet pet);
	public Boolean destroy(int id);
}


