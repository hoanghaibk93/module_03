package repository;

import model.User;

import java.util.List;

public interface IUserRepository {
    public List<User> findAll();
    public User findById();
    public boolean deleteUser(int id);
    public boolean updateUser(int id, User user);
}
