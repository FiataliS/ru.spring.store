package ru.spring.store.Controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.spring.store.Dto.UserDto;
import ru.spring.store.Entities.User;
import ru.spring.store.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class ControllerUsers {

    private final UserService userService;

//    @GetMapping()
//    public Page<UserDto> find(@RequestParam(name = "p", defaultValue = "1") Integer page
//    ) {
//        if (page < 1) {
//            page = 1;
//        }
//        return userService.findAll(page);
//    }

    @GetMapping("/{id}")
    public User getUsers(@PathVariable Long id) {
        return userService.findById(id).orElseThrow();
    }

    @PostMapping()
    public void addUsers(@RequestParam User user) {
        userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void delUsers(@PathVariable Long id) {
        userService.delUser(id);
    }

    @GetMapping("/products/")
    public List<User> getAllUsersToProduct(@RequestParam(name = "id") Long id) {
        return userService.getAllUsersToProduct(id);
    }

}
