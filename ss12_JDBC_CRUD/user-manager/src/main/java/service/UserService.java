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
    public User findById() {
        return repository.findById();
    }

    @Override
    public boolean deleteUser(int id) {
        return repository.deleteUser(id);
    }

    @Override
    public boolean updateUser(int id, User user) {
        return repository.updateUser(id, user);
    }
}
