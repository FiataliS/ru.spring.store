package ru.spring.store.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spring.store.Model.Product;
import ru.spring.store.Model.Users;
import ru.spring.store.Repositories.ProductRepository;
import ru.spring.store.Repositories.UsersRepository;

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

    public void addProduct(Product product) {
        productRepository.save(new Product(product.getName(), product.getPrice()));
    }

    public void delProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> minMaxProduct(Integer min, Integer max) {
        return productRepository.findAllByPriceBetween(min,max);
    }


//    public int minPrice(){
//        return findAll().stream().min(Math::min).get();
//    }

    public List<Product> getAllProductToUsers(Long Id) {
        return productRepository.getAllProductToUsers(Id);
    }

}
