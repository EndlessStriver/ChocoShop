package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Dao.UserDao;
import Dao.Implement.UserDaoImp;
import Service.AuthService;
import Service.Implement.AuthServiceImp;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDaoImp();
	private AuthService authService;

	public LoginController() {
		super();
		authService = new AuthServiceImp(userDao);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
