package ru.spring.store.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.spring.store.Model.Product;
import ru.spring.store.Model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository <Users, Long> {


    @Query(value = "SELECT u.id, u.name from Users as u INNER JOIN purchases as p ON (p.user_id = u.id) where p.product_id = :id", nativeQuery = true)
    List getAllUsersToProduct(Long id);


}
