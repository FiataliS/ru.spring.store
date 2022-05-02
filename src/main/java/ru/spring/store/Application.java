package ru.spring.store;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import ru.spring.store.Dao.ProductDao;
import ru.spring.store.Dao.UsersDao;
import ru.spring.store.Service.ProductService;
import ru.spring.store.Service.UsersService;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductService product = new ProductService(sessionFactoryUtils);
            UsersService users = new UsersService(sessionFactoryUtils);

            System.out.println(users.getUsers(2l));

            System.out.println(users.getAllProductToUsers(2l));

            System.out.println(product.getAllUsersToProduct(3l));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shotdown();
        }

    }
}
