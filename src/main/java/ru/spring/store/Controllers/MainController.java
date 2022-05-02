package ru.spring.store.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spring.store.Dao.ProductDao;
import ru.spring.store.Model.Product;
import ru.spring.store.Service.CardService;
import ru.spring.store.Service.ProductService;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    ProductService productService;

    @Autowired
    CardService card;

    @GetMapping("/product/all")
    public List<Product> allProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/card/add")
    public void addProductCard(@RequestParam Long productId) {
        card.addProductCard(productId);
    }

    @GetMapping("/card/del")
    public void cardDel(@RequestParam Long productId) {
        card.delProductCard(productId);
    }

    @GetMapping("/card/all")
    public List<Product> allCard() {
        return card.getCardList();
    }

    @GetMapping("/card/countCost")
    public int countCost() {
        return card.sumCardList();
    }

    @GetMapping("/product/add")
    public void addProduct(@RequestParam String name, @RequestParam int price) {
        System.out.println(name + " " + price);
        productService.addProduct(name, price);

    }

}
