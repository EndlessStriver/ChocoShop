package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AuthService;
import service.implement.AuthServiceImp;

import java.io.IOException;

import dao.UserDao;
import dao.implement.UserDaoImp;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AuthService authService;
	private UserDao userDao = new UserDaoImp();
	
	public LoginController() {
		super();
		authService = new AuthServiceImp(userDao);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("public/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			if (authService.login(username, password)) {
				System.out.println("Login success");
//				response.sendRedirect("home.jsp");
			} else {
				System.out.println("Login failed");
//				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
