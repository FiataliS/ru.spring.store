package ru.spring.store.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spring.store.Model.Product;
import ru.spring.store.Repository.ProductInMemoryRepository;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    private ProductInMemoryRepository productInMemoryRepository;

    public Product getProduct(Long id) {
        return productInMemoryRepository.findById(id);
    }

    public List<Product> getAllProduct() {
        return productInMemoryRepository.getProductList();
    }

    public void addProduct(Long id, String name, int cost) {
        productInMemoryRepository.addProductList(new Product(id, name, cost));
    }

}
