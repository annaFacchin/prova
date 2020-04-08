package it.objectmethod.world.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.world.dao.ICityDao;
import it.objectmethod.world.dao.impl.CityDaoImpl;
import it.objectmethod.world.domain.City;

@WebServlet("/CityList")

public class CityListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1197549601994273124L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<City> cities = null;
		ICityDao cityDao = new CityDaoImpl();
		String countryCode = req.getParameter("country");

		try {
			cities = cityDao.getCityByCountry(countryCode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		req.setAttribute("cityList", cities);
		req.getRequestDispatcher("pages/cityList.jsp").forward(req, resp);
	}

}
