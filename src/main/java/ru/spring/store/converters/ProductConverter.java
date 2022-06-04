package ru.spring.store.converters;

import org.springframework.stereotype.Component;
import ru.spring.store.Dto.ProductDto;
import ru.spring.store.Entities.Product;

@Component
public class ProductConverter {
    public Product dtoToEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getName(), productDto.getPrice());
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice());
    }
}
