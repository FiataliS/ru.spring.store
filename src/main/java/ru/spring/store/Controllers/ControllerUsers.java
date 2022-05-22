package ru.spring.store.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.spring.store.Model.Product;
import ru.spring.store.Model.Users;
import ru.spring.store.Service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class ControllerUsers {

    @Autowired
    UsersService usersService;

    @GetMapping()
    public List<Users> allUsers() {
        return usersService.findAll();
    }

    @GetMapping("/{id}")
    public Users getProduct(@PathVariable Long id) {
        return usersService.findById(id).orElseThrow();
    }

    @PostMapping()
    public void addProduct(@RequestParam String name) {
        usersService.addUsers(name);
    }

    @DeleteMapping("/{id}")
    public void delProduct(@PathVariable Long id) {
        usersService.delUsers(id);
    }

    @GetMapping("/products/")
    public List<Users> getAllUsersToProduct(@RequestParam(name = "id") Long id) {
        return usersService.getAllUsersToProduct(id);
    }

}
