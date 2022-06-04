package ru.spring.store.converters;

import org.springframework.stereotype.Component;
import ru.spring.store.Dto.UserDto;
import ru.spring.store.Entities.User;

@Component
public class UserConverter {

    public User dtoToEntity(UserDto userDto) {
        return new User(userDto.getId(), userDto.getUserName());
    }

    public UserDto entityToDto(User user) {
        return new UserDto(user.getId(), user.getUsername());
    }
}
