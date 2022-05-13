package ru.spring.store.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.spring.store.Service.UsersService;

@RestController
public class ControllerUsers {


    @Autowired
    UsersService usersService;



}
