package ru.spring.store.Repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.spring.store.Entities.User;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query(value = "SELECT u.id, u.name from Users as u INNER JOIN purchases as p ON (p.user_id = u.id) where p.product_id = :id", nativeQuery = true)
    List<User> getAllUsersToProduct(Long id);

}
