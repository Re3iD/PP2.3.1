package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.entity.User;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class UserSeviseImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }
    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }
    @Transactional
    @Override
    public void update(User user) {
        userDao.update(user);
    }
    @Transactional
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
    @Transactional

    @Override
    public User getUserById(int i) {
        return userDao.getUserById(i);
    }
}
