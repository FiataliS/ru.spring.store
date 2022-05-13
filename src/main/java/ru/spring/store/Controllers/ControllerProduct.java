package ru.spring.store.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.spring.store.Model.Product;
import ru.spring.store.Service.ProductService;

import java.util.List;

@RestController
public class ControllerProduct {

    @Autowired
    ProductService productService;


    @GetMapping("/products")
    public List<Product> allProduct() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.findById(id).orElseThrow();
    }

    @PostMapping("/products")
    public void addProduct(@RequestParam String name, @RequestParam int price) {
        productService.addProduct(name, price);
    }

    @GetMapping("products/delete/{id}")
    public void delProduct(@PathVariable Long id) {
        productService.delProduct(id);
    }


}
