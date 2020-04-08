package it.objectmethod.world.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.world.dao.ICountryDao;
import it.objectmethod.world.dao.impl.CountryDaoImpl;
import it.objectmethod.world.domain.Country;

@WebServlet("/CountryList")
public class CountryListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5607384205625933962L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Country> countries = null;
		ICountryDao countryDao = new CountryDaoImpl();
		HttpSession session = req.getSession();

		String continentName = req.getParameter("chosenContinent");
		if (continentName != null) {
			session.setAttribute("continent-session", continentName);
		} else {
			continentName = (String) session.getAttribute("continent-session");
		}

		try {
			countries = countryDao.getCountryByContinent(continentName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		req.setAttribute("countryList", countries);
		req.getRequestDispatcher("pages/countryList.jsp").forward(req, resp);
	}
}
