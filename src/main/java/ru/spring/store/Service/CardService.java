package ru.spring.store.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.spring.store.Dto.ProductDto;
import ru.spring.store.Model.Product;

import javax.persistence.Access;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
@Scope("prototype")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardService {

    private List<ProductDto> cardList = new ArrayList<>();

    @Autowired
    private ProductService productService;


    public Map<ProductDto, Long> getCardList() {
        return cardListCount();
    }


    public void addProductCard(Long id) {
        this.cardList.add(productService.findById(id));
    }

    public void delProductCard(Long id) {
            this.cardList.remove(productService.findById(id));
    }

    public int sumCardList() {
        int i = 0;
        for (ProductDto c : cardList) {
            i += c.getPrice();
        }
        return i;
    }

    private Map<ProductDto, Long> cardListCount (){
        Map<ProductDto,Long> countFrequency = cardList.stream().collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()
        ));
        return countFrequency;
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
