package service.implement;

import org.mindrot.jbcrypt.BCrypt;

import dao.UserDao;
import entity.User;
import service.AuthService;
import util.ValidatorUtil;

public class AuthServiceImp implements AuthService {

	private UserDao userDao;
	
	public AuthServiceImp(UserDao userDao) {
		this.userDao = userDao;
	}

	public void register(User user) {

		try {
			String messageError = ValidatorUtil.validatorUser(user);

			if (messageError != null)
				throw new RuntimeException(messageError);

			String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

			user.setPassword(hashedPassword);
			userDao.createUser(user);
		} catch (Exception e) {
			throw e;
		}

	}

	public boolean login(String username, String password) {

		try {
			User user = userDao.findUserByUsername(username);

			if (user == null)
				throw new RuntimeException("User not found");

			boolean isPasswordMatch = BCrypt.checkpw(password, user.getPassword());
			boolean isUsernameMatch = username.equals(user.getUserName());

			if (isPasswordMatch && isUsernameMatch)
				return true;

			return false;
		} catch (Exception e) {
			throw e;
		}
	}
}
