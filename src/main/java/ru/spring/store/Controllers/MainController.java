package ru.spring.store.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/add")
    @ResponseBody
    public String add (){
        return "ewrwe";
    }

}
