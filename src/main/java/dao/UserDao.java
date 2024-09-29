package dao;

import java.util.List;

import entity.User;

public interface UserDao {
	User getUser(Long id);
    List<User> getUsers();
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    User findUserByUsername(String username);
}
