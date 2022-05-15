package ru.spring.store.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.spring.store.Model.Product;
import ru.spring.store.Model.Users;
import ru.spring.store.Service.UsersService;

import java.util.List;

@RestController
public class ControllerUsers {

    @Autowired
    UsersService usersService;

    @GetMapping("/users")
    public List<Users> allUsers() {
       return usersService.findAll();
    }

    @GetMapping("/users/{id}")
    public Users getProduct(@PathVariable Long id) {
        return usersService.findById(id).orElseThrow();
    }

    @PostMapping("/users")
    public void addProduct(@RequestParam String name) {
        usersService.addUsers(name);
    }

    @GetMapping("users/delete/{id}")
    public void delProduct(@PathVariable Long id) {
        usersService.delUsers(id);
    }

}
