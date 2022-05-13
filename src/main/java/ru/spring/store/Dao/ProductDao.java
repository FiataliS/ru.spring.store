package ru.spring.store.Dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spring.store.Model.Product;
import ru.spring.store.Model.Users;

import java.util.List;

@Component
public class ProductDao {

    @Autowired
    SessionFactoryUtils sessionFactoryUtils;

    public ProductDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("select u from Product u").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.createQuery("DELETE Product u WHERE u.id = :id")
                                .setParameter("id", id)
                                .executeUpdate();
            session.getTransaction().commit();
        }
    }

    public void saveOrUpdate(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    public List<Users> getAllUsersToProduct (Long productId){
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, productId);
            List<Users> usersList = product.getUsersList();
            session.getTransaction().commit();
            return usersList;
        }
    }
}
