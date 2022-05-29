package ru.spring.store.converters;

import org.springframework.stereotype.Component;
import ru.spring.store.Dto.UserDto;
import ru.spring.store.Model.Users;

@Component
public class UserConverter {

    public Users dtoToEntity(UserDto userDto) {
        return new Users(userDto.getId(), userDto.getName());
    }

    public UserDto entityToDto(Users users) {
        return new UserDto(users.getId(), users.getName());
    }
}
