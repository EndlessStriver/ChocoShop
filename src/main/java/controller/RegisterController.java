package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AuthService;
import service.implement.AuthServiceImp;
import util.MethodUtil;

import java.io.IOException;

import dao.UserDao;
import dao.implement.UserDaoImp;
import entity.User;
import entity.enumtype.Role;

@WebServlet(urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDao userDAO = new UserDaoImp();
	private AuthService authService;

	public RegisterController() {
		super();
		authService = new AuthServiceImp(userDAO);
	}

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("public/SignUp.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

		try {
			authService.register(user);
			System.out.println("Register success");
//			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("Register failed");
			System.out.println(e.getMessage());
//			request.setAttribute("errorMessage", errorMessage);
//			request.getRequestDispatcher("register.jsp").forward(request, response);
		}

	}

}
