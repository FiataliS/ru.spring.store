package ru.spring.store.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.spring.store.Dao.ProductDao;
import ru.spring.store.Dao.UsersDao;
import ru.spring.store.Model.Product;
import ru.spring.store.Model.Users;
import ru.spring.store.SessionFactoryUtils;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    UsersDao usersDao;

    @Autowired
    public UsersService(SessionFactoryUtils sessionFactoryUtils) {
        usersDao = new UsersDao(sessionFactoryUtils);
    }

    public Users getUsers(Long id) {
        return usersDao.findById(id);
    }

    public List<Users> getAllUsers() {
        return usersDao.findAll();
    }

    public void addUsers(String name) {
        usersDao.saveOrUpdate(new Users(name));
    }

    public List<Product> getAllProductToUsers(Long usersId) {
        return usersDao.getAllProductToUsers(usersId);
    }
}
