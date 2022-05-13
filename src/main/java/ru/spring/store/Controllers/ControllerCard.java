package ru.spring.store.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.spring.store.Model.Product;
import ru.spring.store.Service.CardService;

import java.util.List;


@RestController
public class ControllerCard {

    @Autowired
    CardService card;

    @PostMapping("/card")
    public void addProductCard(@RequestParam Long id) {
        card.addProductCard(id);
    }

    @GetMapping("/card/del/{id}")
    public void cardDel(@PathVariable Long id) {
        card.delProductCard(id);
    }

    @GetMapping("/card")
    public List<Product> allCard() {
        return card.getCardList();
    }

    @GetMapping("/card/countCost")
    public int countCost() {
        return card.sumCardList();
    }

    @GetMapping("/card/clear")
    public void cardClear(){
        card.clearCard();
    }
}
