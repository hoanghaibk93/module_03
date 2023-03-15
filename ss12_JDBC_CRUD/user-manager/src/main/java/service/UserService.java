package service;

import model.User;
import repository.IUserRepository;
import repository.UserRepository;

import java.util.List;

public class UserService implements IUserService {
    private IUserRepository repository = new UserRepository();

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void deleteUser(int id) {
         repository.deleteUser(id);
    }

    @Override
    public void updateUser(int id, User user) {
        repository.updateUser(id, user);
    }

    @Override
    public void insertUser(User user) {
        repository.insertUser(user);
    }

    @Override
    public List<User>  searchByCountry(String country) {
        return repository.searchByCountry(country);
    }

    @Override
    public List<User> sortByName() {
        return repository.sortByName();
    }

    @Override
    public List<User>  findAllMethod() {
        return repository.findAllMethod();
    }

    @Override
    public void updateUserMethod(User user) {
        repository.updateUserMethod(user);

    }

}
