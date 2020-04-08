package it.objectmethod.world.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.world.config.ConnectionFactory;
import it.objectmethod.world.dao.ICityDao;
import it.objectmethod.world.domain.City;

public class CityDaoImpl implements ICityDao {

	@Override
	public List<City> getCityByCountry(String countryCode) {
		City city = null;
		List<City> cities = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM city WHERE city.countryCode = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, countryCode);
			rs = stmt.executeQuery();
			while (rs.next()) {
				city = new City();
				city.setCityId(rs.getInt("ID"));
				city.setCityName(rs.getString("Name"));
				city.setCountryCode(rs.getString("CountryCode"));
				city.setCityPopulation(rs.getInt("Population"));
				cities.add(city);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se2) {
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return cities;

	}

	@Override
	public List<City> searchCities(String name, String countryCode) {
		City city = null;
		List<City> cities = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int cityId = 0;
		int cityPopulation = 0;

		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM city" + "WHERE (name IS NULL OR name = ?)"
					+ "AND (countryCode = 'nessuna' OR countryCode = ?)";
			// String sql = "SELECT * FROM city WHERE city.name LIKE '%' + @name + '%' OR
			// city.countryCode = ?";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			stmt.setString(1, name);
			stmt.setString(2, countryCode);
			while (rs.next()) {
				city = new City();
				city.setCityId(cityId);
				city.setCityName(rs.getString("name"));
				city.setCountryCode(rs.getString("countryCode"));
				city.setCityPopulation(cityPopulation);
				cities.add(city);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se) {
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
		System.out.println(cities);
		return cities;
	}

	@Override
	public City addOrEditCity(int newId, String newName, String newCountryCode, int newPopulation) {

		City newCity = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		// ResultSet rs = null;
		// ho provato a commentare il ResultSet e sostituirlo con Int row,
		// visto che executeUpdate() ritorna un intero e mi dava errore

		try {
			conn = ConnectionFactory.getConnection();
			String sql = "INSERT INTO city (name, countryCode, population) VALUES (?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, newId);
			stmt.setString(2, newName);
			stmt.setString(3, newCountryCode);
			stmt.setInt(4, newPopulation);
			// rs = stmt.executeQuery();
			int row = stmt.executeUpdate();
			// while (rs.next()) {
			if (row == 1) {
				newCity = new City();
				newCity.setCityId(newId);
				newCity.setCityName(newName);
				newCity.setCountryCode(newCountryCode);
				newCity.setCityPopulation(newPopulation);
				if (row > 0) {
					System.out.println("City saved into database");
				}

				// }
			}
			// rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se2) {
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("created city: " + newCity);
		return newCity;
	}

}
