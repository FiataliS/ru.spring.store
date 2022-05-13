package ru.spring.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.spring.store.Model.Users;

public interface UsersRepository extends JpaRepository <Users, Long> {


}
