package service;

import entity.User;

public interface AuthService {

	void register(User user);

	boolean login(String username, String password);
}
