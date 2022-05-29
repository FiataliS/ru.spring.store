package ru.spring.store.Controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.spring.store.Dto.ProductDto;
import ru.spring.store.Dto.UserDto;
import ru.spring.store.Model.Product;
import ru.spring.store.Model.Users;
import ru.spring.store.Service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class ControllerUsers {

    private final UsersService usersService;

    @GetMapping()
    public Page<UserDto> find(@RequestParam(name = "p", defaultValue = "1") Integer page
    ) {
        if (page < 1) {
            page = 1;
        }
        return usersService.findAll(page);
    }

    @GetMapping("/{id}")
    public Users getUsers(@PathVariable Long id) {
        return usersService.findById(id).orElseThrow();
    }

    @PostMapping()
    public void addUsers(@RequestParam Users user) {
        usersService.addUsers(user);
    }

    @DeleteMapping("/{id}")
    public void delUsers(@PathVariable Long id) {
        usersService.delUsers(id);
    }

    @GetMapping("/products/")
    public List<Users> getAllUsersToProduct(@RequestParam(name = "id") Long id) {
        return usersService.getAllUsersToProduct(id);
    }

}
