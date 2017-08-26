package data;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Fact;

@Transactional
public class FactDAOImpl implements FactDAO{
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Fact> index() {
		String query = "SELECT * FROM fact";
		List<Fact> facts = em.createNativeQuery(query).getResultList();
		return facts;
	}

	@Override
	public Fact create(Fact fact) {
		em.persist(fact);
		em.flush();
		
		return em.find(Fact.class, fact.getId());
		
	}

	@Override
	public Fact show(int id) {
		return em.find(Fact.class, id);
	}

	@Override
	public Fact update(int id, Fact fact) {
		Fact managed = null;
		managed=em.find(Fact.class, id);
		managed.setFact(fact.getFact());
		managed.setFactUrl(fact.getFactUrl());
		
		em.flush();
		return managed;
	}

	@Override
	public Boolean destroy(int id) {
		Fact fact = em.find(Fact.class, id);
		em.remove(fact);
		return true;
	}
	

}
