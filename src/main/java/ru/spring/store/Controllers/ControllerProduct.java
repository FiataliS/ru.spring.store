package ru.spring.store.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.spring.store.Dto.ProductDto;
import ru.spring.store.Model.Product;
import ru.spring.store.Service.ProductService;


import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ControllerProduct {

    @Autowired
    ProductService productService;

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

    @PostMapping("")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @GetMapping("/users/{id}")
    public List<ProductDto> getAllProductToUsers(@PathVariable Long id) {
        return productService.getAllProductToUsers(id);
    }
}
