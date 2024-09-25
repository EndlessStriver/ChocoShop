package Service;

import Entity.User;

public interface AuthService {

	void register(User user);

	boolean login(String username, String password);
}
