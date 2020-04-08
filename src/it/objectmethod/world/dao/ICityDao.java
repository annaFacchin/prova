package it.objectmethod.world.dao;

import java.util.List;

import it.objectmethod.world.domain.City;

public interface ICityDao {

	public List<City> getCityByCountry(String countryCode);

	public List<City> searchCities(String name, String countryCode);

	public City addOrEditCity(int newId, String name, String countryCode, int population);

}
