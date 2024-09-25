package Service;

import Entity.User;

public interface AuthService {

	public String register(User user);

	public boolean login(String username, String password);
}
