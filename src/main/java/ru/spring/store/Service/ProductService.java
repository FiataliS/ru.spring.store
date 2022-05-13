package ru.spring.store.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spring.store.Dao.ProductDao;
import ru.spring.store.Model.Product;
import ru.spring.store.Model.Users;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;



    public Product getProduct(Long id) {
        return productDao.findById(id);
    }

    public List<Product> getAllProduct() {
        return productDao.findAll();
    }

    public void addProduct(String name, int price) {
        productDao.saveOrUpdate(new Product(name, price));
    }

    public List<Users> getAllUsersToProduct(Long productId) {
        return productDao.getAllUsersToProduct(productId);
    }

}
