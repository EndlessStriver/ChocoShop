package Service.Implement;

import java.util.Set;

import org.mindrot.jbcrypt.BCrypt;

import Dao.UserDao;
import Dao.Implement.UserDAOImpl;
import Entity.User;
import Service.AuthService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class AuthServiceImp implements AuthService {
	
	private UserDao userDao = new UserDAOImpl();
	
	public String register(User user) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
		Set<ConstraintViolation<User>> violations  = validator.validate(user);
		
		if (!violations.isEmpty()) {
            return violations.iterator().next().getMessage();
        }
		
		String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashedPassword);

		try {
	        userDao.save(user);
	        return null;
	    } catch (Exception e) {
	        return "An error occurred while registering. Please try again.";
	    }
	
	}
	
	public boolean login(String username, String password) {
		
		User user = userDao.findByUsername(username);
		
		if (user == null) return false;
		
		boolean isPasswordMatch = BCrypt.checkpw(password, user.getPassword());
		boolean isUsernameMatch = username.equals(user.getUserName());
		
		if (isPasswordMatch && isUsernameMatch)  return true;
		
		return false;
	}
}
