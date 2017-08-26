package data;

import java.util.List;

import entities.Fact;

public interface FactDAO {

	public List<Fact> index();
	public Fact create(Fact fact);
	public Fact show(int id);
	public Fact update(int id, Fact fact);
	public Boolean destroy(int id);
}
