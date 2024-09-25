package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Entity.User;
import Entity.Enum.Role;
import Service.AuthService;
import Service.Implement.AuthServiceImp;
import Util.MethodUtil;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public RegisterController() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AuthService authService = new AuthServiceImp();
		
		String username = request.getParameter("username");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		
		User user = new User();
		user.setUserName(username);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);
		user.setGender(Boolean.parseBoolean(gender));
		user.setPassword(password);
		user.setBirthday(MethodUtil.ConvertStringToLocalDate(birthday));
		user.setRole(Role.USER);
		
		String errorMessage =  authService.register(user);
		
		if (errorMessage != null) {
			System.out.println(errorMessage);
			System.out.println("Register failed");
//			request.setAttribute("errorMessage", errorMessage);
//			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else {
			System.out.println("Register success");
//			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
