package ru.spring.store.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.spring.store.Model.Product;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
@Scope("prototype")
public class CardService {

    private List<Product> cardList = new ArrayList<>();

    @Autowired
    private ProductService productService;

    public List<Product> getCardList() {
        return cardList;
    }

    public void addProductCard(Long id) {
        this.cardList.add(productService.getProduct(id));
    }

    public void delProductCard(Long id) {
            this.cardList.remove(productService.getProduct(id));
    }

    public int sumCardList() {
        int i = 0;
        for (Product c : cardList) {
            i += c.getPrice();
        }
        return i;
    }

    public void clearCard() {
        if (cardList.size() != 0) {
            cardList.clear();
        }
    }

    public int sizeList(){
        return getCardList().size();
    }
}
