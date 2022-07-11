package web.dao;

import org.springframework.stereotype.Component;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Component
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void add(User user) {
        manager.persist(user);
    }

    @Override
    public void delete(User user) {
        manager.remove(manager.contains(user)?user:manager.merge(user));
    }

    @Override
    public void update(User user) {
        manager.merge(user);
    }

    @Override
    public List<User> listUsers() {
        List<User> list = manager.createQuery("select u from User as u").getResultList();
        return list;
    }

    @Override
    public User getUserById(int id) {
        return manager.find(User.class,id);
    }
}
