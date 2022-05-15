package ru.spring.store.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spring.store.Model.Product;
import ru.spring.store.Model.Users;
import ru.spring.store.Repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll().stream().map(p -> new Product(p.getId(), p.getName(), p.getPrice())).collect(Collectors.toList());
    }

    public void addProduct(String name, int price) {
        productRepository.save(new Product(name, price));
    }

    public void delProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> minMaxProduct(Integer min, Integer max) {
        return productRepository.findAllByPriceBetween(min,max);
    }

//    public List<Users> getAllUsersToProduct(Long productId) {
//        return productRepository.getAllUsersToProduct(productId);
//    }

}
