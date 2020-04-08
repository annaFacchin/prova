package it.objectmethod.world.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.world.dao.ICityDao;
import it.objectmethod.world.dao.ICountryDao;
import it.objectmethod.world.dao.impl.CityDaoImpl;
import it.objectmethod.world.dao.impl.CountryDaoImpl;
import it.objectmethod.world.domain.City;
import it.objectmethod.world.domain.Country;

@WebServlet("/SearchCities")
public class SearchCitiesServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8446288570235298998L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<City> cities = null;
		List<Country> countries = null;
		ICityDao cityDao = new CityDaoImpl();
		ICountryDao countryDao = new CountryDaoImpl();

		String name = req.getParameter("nome");
		String countryCode = req.getParameter("countryCode");

		try {
			countries = countryDao.getAllCountries();
			if (name != null && countryCode != null) {
				cities = cityDao.searchCities(name, countryCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		req.setAttribute("countryList", countries);
		req.setAttribute("cityList", cities);
		req.getRequestDispatcher("pages/cityList.jsp").forward(req, resp);
	}

}
