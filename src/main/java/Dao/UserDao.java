package Dao;

import java.util.List;

import Entity.User;

public interface UserDao {
	User findById(Long id);
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(Long id);
    User findByUsername(String username);
}
