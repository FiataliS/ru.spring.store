package ru.spring.store.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.spring.store.Dto.ProductDto;
import ru.spring.store.Service.CardService;

import java.util.Map;


@RestController
@RequestMapping("/api/v1/card")
@RequiredArgsConstructor
public class ControllerCard {

    private final CardService card;

    @PostMapping()
    public void addProductCard(@RequestParam Long id) {
        card.addProductCard(id);
    }

    @GetMapping("/del/{id}")
    public void cardDel(@PathVariable Long id) {
        card.delProductCard(id);
    }

    @GetMapping()
    public Map<ProductDto, Long> allCard() {
        return card.getCardList();
    }

    @GetMapping("/countCost")
    public int countCost() {
        return card.sumCardList();
    }

    @DeleteMapping("/clear")
    public void cardClear(){
        card.clearCard();
    }
}
