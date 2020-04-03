package it.objectmethod.world.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.world.dao.IContinentDao;
import it.objectmethod.world.dao.impl.ContinentDaoImpl;

@WebServlet("/CountryList")
public class CountryListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5607384205625933962L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> countries = new ArrayList<>();
		IContinentDao continentDao = new ContinentDaoImpl();
		String continentName = req.getParameter("continentName");

		try {
			countries = continentDao.getCountryByContinent(continentName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// set session
		HttpSession session = req.getSession();
		String output = "";
		String sessionName = (String) session.getAttribute("nome-session");
		session.setAttribute("nome-session", continentName);
		if (sessionName != null) {
			output = "Continente precedente: " + sessionName + ", nuovo continente selezionato: " + continentName;
		} else {
			output = "Continente selezionato: " + continentName;

			// output
			req.setAttribute("output", output);
			req.setAttribute("cityList", countries);
			req.getRequestDispatcher("pages/countryList.jsp").forward(req, resp);

		}

	}

}
