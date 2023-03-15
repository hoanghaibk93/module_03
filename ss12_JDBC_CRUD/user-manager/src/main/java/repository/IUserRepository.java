package repository;

import model.User;

import java.util.List;

public interface IUserRepository {
    public List<User> findAll();
    public User findById(int id);
    public void deleteUser(int id);
    public void updateUser(int id, User user);
    public void insertUser(User user);
    public List<User>  searchByCountry(String country);
    public List<User> sortByName();

    List<User> findAllMethod();
    void updateUserMethod(User user);
    void deleteUserMethod(int id);
    void updateUserTransaction();
}
