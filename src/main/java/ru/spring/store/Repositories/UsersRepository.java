package ru.spring.store.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.spring.store.Model.Users;

import java.util.List;

public interface UsersRepository extends JpaRepository <Users, Long> {

//    @Query(value = "SELECT u.id, u.name from Users u INNER JOIN purchases  p ON (p.user_id = u.id) where p.product_id = 1")
//    List<Users> getAllUsersToProduct(Long id);


}
