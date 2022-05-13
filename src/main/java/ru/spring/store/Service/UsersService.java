package ru.spring.store.Service;


import org.springframework.stereotype.Service;
import ru.spring.store.Model.Users;
import ru.spring.store.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private UsersRepository usersRepository;

    public Optional<Users> getUsers(Long id) {
        return usersRepository.findById(id);
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public void addUsers(String name) {
        usersRepository.save(new Users(name));
    }

//    public List<Product> getAllProductToUsers(Long usersId) {
//        return usersRepository.getAllProductToUsers(usersId);
//    }
}
