package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Pet;

public class PetsTest {

	Pet pets;
	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("JPAPets");
		em = emf.createEntityManager();
		pets = em.find(Pet.class, 1);

	}

	@After
	public void tearDown() {
		pets = null;
		em.close();
		emf.close();
	}

	@Test
	public void test_for_first_name() {
		
		String name = em.find(Pet.class, 1).getName();
		assertEquals("Ada", name);

	}

}
