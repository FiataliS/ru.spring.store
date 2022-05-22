package ru.spring.store.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.spring.store.Dto.ProductDto;
import ru.spring.store.Model.Product;
import ru.spring.store.Repositories.ProductRepository;
import ru.spring.store.Repositories.specification.ProductSpecification;
import ru.spring.store.exceptions.ResourceNotFoundExeption;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Page<ProductDto> find(Integer p, Integer minPrice, Integer maxPrice, String name) {
        Specification<Product> spec = Specification.where(null);

        if (minPrice != null) {
            spec = spec.and(ProductSpecification.greaterThanOrEqualTo(minPrice));
        }

        if (maxPrice != null) {
            spec = spec.and(ProductSpecification.lessThanOrEqualTo(maxPrice));
        }
        if (name != null) {
            spec = spec.and(ProductSpecification.nameLike(name));
        }

        return productRepository.findAll(spec, PageRequest.of(p - 1, 5)).map(ProductDto::new);
    }

    public ProductDto findById(Long id) {
        return productRepository.findById(id).map(ProductDto::new).orElseThrow(()-> new ResourceNotFoundExeption("Product " + id + " не наеден"));
    }


    public void addProduct(Product product) {
        productRepository.save(new Product(product.getName(), product.getPrice()));
    }

    public void delProduct(Long id) {
        productRepository.deleteById(id);
    }


    public List<ProductDto> getAllProductToUsers(Long Id) {
        return productRepository.getAllProductToUsers(Id).stream().map(ProductDto::new).toList();
    }

}
