package it.objectmethod.world.dao;

import java.util.List;

import it.objectmethod.world.domain.Country;

public interface ICountryDao {

	public List<String> getAllContinent();

	public List<Country> getAllCountries();

	public List<Country> getCountryByContinent(String continentName);

}
