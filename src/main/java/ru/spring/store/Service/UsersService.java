package ru.spring.store.Service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.spring.store.Dto.UserDto;
import ru.spring.store.Model.Product;
import ru.spring.store.Model.Users;
import ru.spring.store.Repositories.UsersRepository;
import ru.spring.store.converters.UserConverter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final UserConverter userConverter;


    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }

    public Page<UserDto> findAll(Integer p) {
        return usersRepository.findAll(PageRequest.of(p-1,40)).map(userConverter::entityToDto);
    }


    public void addUsers(Users users) {
        usersRepository.save(users);
    }

    public void delUsers(Long id) {
        usersRepository.deleteById(id);
    }

    public List<Users> getAllUsersToProduct(Long Id) {
        System.out.printf(usersRepository.getAllUsersToProduct(Id).toString());
        return usersRepository.getAllUsersToProduct(Id);
    }
}
