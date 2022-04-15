package ru.spring.store.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.spring.store.Model.Product;
import ru.spring.store.Service.CardService;
import ru.spring.store.Service.ProductService;

@Controller
public class MainController {

    @Autowired
    ProductService productService;

    //ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

    @Autowired
    CardService card;// = context.getBean(CardService.class);

    @GetMapping("/product")
    public String index(Model model) {
        model.addAttribute("product", productService.getAllProduct());
        return "product";
    }

    @GetMapping("/card")
    public String card(Model model){
        model.addAttribute("card", card.getCardList());
        return "card";
    }

    @GetMapping("/product/{id}")
    public String  addProductCard(Model model, @PathVariable Long id) {
        card.addProductCard(id);
        model.addAttribute("product", productService.getAllProduct());
        return "product";
    }

    @GetMapping("/card/{id}")
    public String  delProductCard(Model model, @PathVariable Long id) {
        card.delProductCard(id);
        model.addAttribute("card", card.getCardList());
        return "card";
    }

    @GetMapping("/card/clear")
    public String  clearCard(Model model) {
        card.clearCard();
        model.addAttribute("card", card.getCardList());
        return "card";
    }

}
