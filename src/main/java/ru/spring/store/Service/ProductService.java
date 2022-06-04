package ru.spring.store.Service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.store.Dto.ProductDto;
import ru.spring.store.Entities.Product;
import ru.spring.store.Repositories.ProductRepository;
import ru.spring.store.Repositories.specification.ProductSpecification;
import ru.spring.store.converters.ProductConverter;
import ru.spring.store.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

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

        return productRepository.findAll(spec, PageRequest.of(p - 1, 5)).map(productConverter::entityToDto);
    }

    public ProductDto findById(Long id) {
        return productRepository.findById(id).map(productConverter::entityToDto).orElseThrow(() -> new ResourceNotFoundException("Product " + id + " не наеден"));
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void delProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public Product update(ProductDto productDto) {
        Product product = productRepository.findById(productDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Невозможно обновить продукта, не надйен в базе, id: " + productDto.getId()));
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        return product;
    }

    public List<ProductDto> getAllProductToUsers(Long Id) {
        return productRepository.getAllProductToUsers(Id).stream().map(productConverter::entityToDto).toList();
    }

}
