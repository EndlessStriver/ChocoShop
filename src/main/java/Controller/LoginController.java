package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Service.AuthService;
import Service.Implement.AuthServiceImp;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AuthService authService = new AuthServiceImp();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (authService.login(username, password)) {
			System.out.println("Login success");
//			response.sendRedirect("home.jsp");
		} else {
			System.out.println("Login failed");
//			response.sendRedirect("login.jsp");
		}
		
	}

}
