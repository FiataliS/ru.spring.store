package ru.spring.store.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spring.store.Model.Product;
import ru.spring.store.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService  {


    private ProductRepository productRepository;

    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public void addProduct(String name, int price) {
        productRepository.save(new Product(name, price));
    }

//    public List<Users> getAllUsersToProduct(Long productId) {
//        return productRepository.getAllUsersToProduct(productId);
//    }

}
