package ru.spring.store.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spring.store.Model.Product;
import ru.spring.store.Model.Users;
import ru.spring.store.Repositories.UsersRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }

    public List<Users> findAll() {
        return usersRepository.findAll().stream().map(p-> new Users(p.getId(),p.getName())).collect(Collectors.toList());
    }


    public void addUsers(String name) {
        usersRepository.save(new Users(name));
    }

    public void delUsers(Long id) {
        usersRepository.deleteById(id);
    }

    public List<Users> getAllUsersToProduct(Long Id) {
        System.out.printf(usersRepository.getAllUsersToProduct(Id).toString());
        return usersRepository.getAllUsersToProduct(Id);
    }
}
