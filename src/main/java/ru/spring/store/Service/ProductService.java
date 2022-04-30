package ru.spring.store.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spring.store.Dao.ProductDao;
import ru.spring.store.Model.Product;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    ProductDao productDao;


    public Product getProduct(Long id) {
        return productDao.findById(id);
    }

    public List<Product> getAllProduct() {
        return productDao.findAll();
    }

    public void addProduct(Long id, String name, int price) {
        productDao.saveOrUpdate(new Product(id, name, price));
    }

}
