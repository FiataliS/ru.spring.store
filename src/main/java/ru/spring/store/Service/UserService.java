package ru.spring.store.Service;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.store.Dto.UserDto;
import ru.spring.store.Entities.Role;
import ru.spring.store.Entities.User;
import ru.spring.store.Repositories.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", username)));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

//    public Page<UserDto> findAll(Integer p) {
//        return userRepository.findAll(PageRequest.of(p-1,40)).map(userConverter::entityToDto);
//    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void delUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUsersToProduct(Long Id) {
        System.out.printf(userRepository.getAllUsersToProduct(Id).toString());
        return userRepository.getAllUsersToProduct(Id);
    }


}