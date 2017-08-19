package data;


import java.util.List;

import entities.Pet;

public interface PetsDao {

	public List<Pet> index();
	public Pet show(int id);
	public Pet create(Pet pet);
	public Pet update(int id, Pet pet);
	public boolean destroy(int id);
}
