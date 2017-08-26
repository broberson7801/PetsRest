package tests;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Fact;
import entities.Pet;
import entities.User;

public class EntityTest {
	
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("pets");
		em = emf.createEntityManager();
	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
	}

	@Test
	public void test_user_for_a_pet() {
		User user = em.find(User.class, 1);
		String name = user.getPets().get(0).getName();
		assertEquals("doggie", name);
	}
	
	@Test
	public void test_pet_for_a_user() {
		Pet pet = em.find(Pet.class, 4);
		String name = pet.getUser().getUserName();
		assertEquals("Conna", name);
	}
	
	@Test
	public void test_fact_for_not_null_id() {
		Interger factId = em.find(Fact.class, 2).getId();
		assertEquals("7", factId);
	}

}
