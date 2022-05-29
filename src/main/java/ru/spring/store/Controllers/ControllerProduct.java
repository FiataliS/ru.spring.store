package ru.spring.store.Controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.spring.store.Dto.ProductDto;
import ru.spring.store.Model.Product;
import ru.spring.store.Service.ProductService;
import ru.spring.store.converters.ProductConverter;
import ru.spring.store.validators.ProductValidator;


import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ControllerProduct {

    private final ProductService productService;
    private final ProductValidator productValidator;
    private final ProductConverter productConverter;

    @GetMapping()
    public Page<ProductDto> find(@RequestParam(name = "p", defaultValue = "1") Integer page,
                                 @RequestParam(name = "min_price", required = false) Integer minPrice,
                                 @RequestParam(name = "max_price", required = false) Integer maxPrice,
                                 @RequestParam(name = "name", required = false) String name
    ) {
        if (page < 1) {
            page = 1;
        }
        return productService.find(page, minPrice, maxPrice, name);
    }


    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delProduct(@PathVariable Long id) {
        productService.delProduct(id);
    }

    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        Product product = productConverter.dtoToEntity(productDto);
        product = productService.addProduct(product);
        return productConverter.entityToDto(product);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        Product product = productService.update(productDto);
        return productConverter.entityToDto(product);
    }


    @GetMapping("/users/{id}")
    public List<ProductDto> getAllProductToUsers(@PathVariable Long id) {
        return productService.getAllProductToUsers(id);
    }
}
