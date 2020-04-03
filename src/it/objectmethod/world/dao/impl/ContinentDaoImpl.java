package it.objectmethod.world.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.world.config.ConnectionFactory;
import it.objectmethod.world.dao.IContinentDao;

public class ContinentDaoImpl implements IContinentDao {

	@Override
	public List<String> getAllContinent() {
		List<String> continents = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT DISTINCT Continent FROM Country";
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
	public List<String> getCountryByContinent(String continent) {
		List<String> countries = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM Country WHERE country.Continent = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, continent);
			rs = stmt.executeQuery();
			while (rs.next()) {
				// attributi vari
				countries.add(rs.getString("Continent"));
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
