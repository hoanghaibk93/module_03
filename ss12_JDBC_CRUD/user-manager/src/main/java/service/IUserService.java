package service;

import model.User;

import java.util.List;

public interface IUserService {
    public List<User> findAll();
    public User findById(int id);
    public void deleteUser(int id);
    public void updateUser(int id, User user);
    public void insertUser(User user);
    public User searchByCountry(String country);
    public List<User> sortByName();
}
