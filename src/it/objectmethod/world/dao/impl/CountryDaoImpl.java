package it.objectmethod.world.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.world.config.ConnectionFactory;
import it.objectmethod.world.dao.ICountryDao;
import it.objectmethod.world.domain.Country;

public class CountryDaoImpl implements ICountryDao {

	@Override
	public List<String> getAllContinent() {
		List<String> continents = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT DISTINCT Continent FROM country";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String continent = (rs.getString("continent"));
				continents.add(continent);
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
		System.out.println(continents);
		return continents;

	}

	// country
	@Override
	public List<Country> getCountryByContinent(String continent) {
		List<Country> countries = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM country WHERE country.Continent = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, continent);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Country c = new Country();
				c.setCode(rs.getString("Code"));
				c.setName(rs.getString("Name"));
				c.setPopulation(rs.getInt("Population"));
				countries.add(c);
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
		System.out.println(countries);
		return countries;

	}

	@Override
	public List<Country> getAllCountries() {
		List<Country> countries = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM country";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Country c = new Country();
				c.setCode(rs.getString("Code"));
				c.setName(rs.getString("Name"));
				c.setPopulation(rs.getInt("Population"));
				countries.add(c);
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
		System.out.println(countries);
		return countries;
	}
}
