package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String fact;

	@Column(name = "fact_url")
	private String factUrl;

	public String getFact() {
		return fact;
	}

	public void setFact(String fact) {
		this.fact = fact;
	}

	public String getFactUrl() {
		return factUrl;
	}

	public void setFactUrl(String factUrl) {
		this.factUrl = factUrl;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Fact [id=" + id + ", fact=" + fact + ", factUrl=" + factUrl + "]";
	}

}
