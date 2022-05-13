package ru.spring.store.Dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spring.store.Model.Product;
import ru.spring.store.Model.Users;

import java.util.List;

@Component
public class UsersDao {

    @Autowired
    SessionFactoryUtils sessionFactoryUtils;

    public UsersDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    public Users findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Users users = session.get(Users.class, id);
            session.getTransaction().commit();
            return users;
        }
    }

    public List<Users> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Users> users = session.createQuery("select u from Users u").getResultList();
            session.getTransaction().commit();
            return users;
        }
    }

    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.createQuery("DELETE Users u WHERE u.id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    public Users saveOrUpdate(Users users) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(users);
            session.getTransaction().commit();
            return users;
        }
    }

    public List<Product> getAllProductToUsers (Long userId){
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Users users = session.get(Users.class, userId);
            List<Product> productList = users.getProductList();
            session.getTransaction().commit();
            return productList;
        }
    }

}
