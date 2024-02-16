package web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Dao.UserDao;
import web.model.User;

import javax.validation.Valid;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDAO) {
        this.userDao = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userDao.findById(id).get();
    }

    @Override
    public void addUser(@Valid User user) {
        userDao.save(user);
    }

    @Override
    public void removeUser(int id) {
        userDao.deleteById(id);
    }

    @Override
    public void updateUser(@Valid User user) {
        userDao.save(user);
    }
}
