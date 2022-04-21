package ru.spring.store.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spring.store.Model.Product;
import ru.spring.store.Service.CardService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class ProductInMemoryRepository implements Repository {

    public void addProductList(Product product) {
        this.productList.add(product);
    }

    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    @PostConstruct
    public void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product(1l, "Гала", 10),
                new Product(2l, "Черный принц", 13),
                new Product(3l, "Карамелька", 23),
                new Product(4l, "Спартан", 50),
                new Product(4l, "Фуджи", 47),
                new Product(4l, "Ренет Симиренко", 5),
                new Product(4l, "Хоней Крисп", 73)
        ));
    }

    @Override
    public Product findById(Long id) {
        return productList.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(RuntimeException::new);
    }

}
