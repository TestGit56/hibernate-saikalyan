package com.donors.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.donors.dao.Address;
import com.donors.dao.Donor;
import com.donors.service.DonorService;
import com.donors.service.ServicesException;

@WebServlet(urlPatterns = { "/search", "/editPage", "/update", "/save", "/registerPage" })
public class FrontController extends HttpServlet {

	DonorService donorService = new DonorService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String path = request.getServletPath();

		if (path.endsWith("registerPage")) {
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		} else if (path.endsWith("editPage")) {
			String loginId = request.getParameter("loginId");
			try {
				Donor donor = donorService.getDonorByID(loginId);
				request.setAttribute("donor", donor);
				request.getRequestDispatcher("/edit.jsp").forward(request, response);
			} catch (ServicesException exp) {
				request.setAttribute("expInfo", exp.toString());
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}

		} else if (path.endsWith("update")) {
			String loginId = request.getParameter("loginId");
			String bloodGroup = request.getParameter("bloodGroup");
			String donorId = request.getParameter("donorId");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			Long mbno = Long.valueOf(request.getParameter("mbno"));

			Address address = new Address(donorId, state, city);
			Donor donor = new Donor(loginId, bloodGroup, mbno, address);

			try {

				donorService.update(donor);

				HttpSession session = request.getSession();
				session.setAttribute("donorName", donor.getLoginId());
				request.getRequestDispatcher("/welcome.jsp").forward(request, response);

			} catch (ServicesException exp) {
				request.setAttribute("expInfo", exp.toString());
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}

		} else if (path.endsWith("save")) {
			String loginId = request.getParameter("loginId");
			String bloodGroup = request.getParameter("bloodGroup");
			String donorId = request.getParameter("donorId");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String password = request.getParameter("password");
			Long mbno = Long.valueOf(request.getParameter("mbno"));
			String cfmpassword = request.getParameter("cfmpassword");

			Address address = new Address(donorId, state, city);
			Donor donor = new Donor(loginId, bloodGroup, mbno, password, address);

			try {
				if (!password.equals(cfmpassword)) {
					request.setAttribute("donor", donor);
					request.setAttribute("passwordMismath", " Passwords are un-equal");
					request.getRequestDispatcher("/register.jsp").forward(request, response);
				} else {
					Donor d = donorService.getDonorByID(loginId);
					if (d != null) {
						request.setAttribute("donor", donor);
						request.setAttribute("idExists", " LoginID already exists");
						request.getRequestDispatcher("/register.jsp").forward(request, response);
					} else {
						donorService.save(donor);
						HttpSession session = request.getSession();
						session.setAttribute("donorId", donor.getLoginId());
						request.getRequestDispatcher("/welcome.jsp").forward(request, response);
					}
				}
			} catch (ServicesException exp) {
				request.setAttribute("expInfo", exp.toString());
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}

		} else if (path.endsWith("search")) {
			String city = request.getParameter("city");
			try {
				List<Donor> donorList = donorService.search(city);

				if (donorList != null && donorList.size() > 0) {
					request.setAttribute("donorList", donorList);
					request.getRequestDispatcher("/welcome.jsp").forward(request, response);
				} else {
					request.setAttribute("nodatafound", "No Donors Exist for a given city");
					request.getRequestDispatcher("/welcome.jsp").forward(request, response);
				}
			} catch (ServicesException exp) {
				request.setAttribute("expInfo", exp.toString());
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}

		} else if (path.endsWith("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("./login.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
