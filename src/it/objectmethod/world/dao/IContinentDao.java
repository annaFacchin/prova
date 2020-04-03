package it.objectmethod.world.dao;

import java.util.List;

public interface IContinentDao {

	public List<String> getAllContinent();

	public List<String> getCountryByContinent(String continentName);

}
