package ru.spring.store.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.spring.store.Model.Product;

import javax.persistence.Access;
import java.util.ArrayList;
import java.util.List;


@Service
@Scope("prototype")
public class CardService {

    private List<Product> cardList = new ArrayList<>();

    @Autowired
    private ProductService productService;


    public List<Product> getCardList() {
        return cardList;
    }

    public void addProductCard(Long id) {
        this.cardList.add(productService.findById(id).orElseThrow());
    }

    public void delProductCard(Long id) {
            this.cardList.remove(productService.findById(id));
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
