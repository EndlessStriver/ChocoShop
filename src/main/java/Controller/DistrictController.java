package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/district")
public class DistrictController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public DistrictController() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String districtName = req.getParameter("districtName");
		System.out.println(districtName);
	}
	
	
	
	
}
