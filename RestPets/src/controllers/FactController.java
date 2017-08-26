package controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.FactDAO;
import entities.Fact;

@RestController
public class FactController {

	@Autowired
	private FactDAO dao;

	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	@RequestMapping(path = "facts", method = RequestMethod.GET)
	public List<Fact> index() {
		return dao.index();
	}

	@RequestMapping(path = "facts/{id}", method = RequestMethod.GET)
	public Fact show(@PathVariable int id) {
		return dao.show(id);
	}

	@RequestMapping(path = "facts", method = RequestMethod.POST)
	public Fact create(@RequestBody  String factJson) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			Fact newFact = mapper.readValue(factJson, Fact.class);
			if(checkForValidUrl(newFact.getFactUrl()) == true) {
				return dao.create(newFact);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(path = "facts/{id}", method = RequestMethod.POST)
	public Fact update(@RequestBody String factJson,  @PathVariable Integer id) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			Fact updatedFact = mapper.readValue(factJson, Fact.class);
			if(checkForValidUrl(updatedFact.getFactUrl()) == true) {
				return dao.update(id, updatedFact);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(path = "facts/{id}", method = RequestMethod.DELETE)
	public Boolean destroy(@PathVariable int id) {
		boolean destroyed = dao.destroy(id);
		return destroyed;
	}

	// This method checks for a valid URL, if the URL is good(true), update/create will persist to the database
	private boolean checkForValidUrl(String url) {
		try {
			HttpsURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			int responseCode = connection.getResponseCode();
			if (responseCode >= 200 && responseCode <= 299) {
				return true;
			} else {
				return false;
			}

		} catch (MalformedURLException e) {
			return false;
		} catch (IOException e) {
			return false;
		}

	}

}
