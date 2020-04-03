package it.objectmethod.world.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.world.dao.ICityDao;
import it.objectmethod.world.dao.impl.CityDaoImpl;

@WebServlet("/AddOrEditCity")
public class AddOrEditCityServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -279414209148829076L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ICityDao cityDaoImpl = new CityDaoImpl();
		String newIdString = req.getParameter("newId");
		Integer newId;
		if (newIdString == "") {
			newId = 0;
		} else {
			newId = Integer.valueOf(req.getParameter("newId"));
		}
		String newName = req.getParameter("newName");
		String newCountryCode = req.getParameter("newCountryCode");
		int newPopulation = Integer.valueOf(req.getParameter("newPopulation"));
		try {
			cityDaoImpl.addOrEditCity(newId, newName, newCountryCode, newPopulation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("pages/addCity.jsp").forward(req, resp);
	}
}
