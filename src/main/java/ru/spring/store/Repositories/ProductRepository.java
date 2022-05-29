package ru.spring.store.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ru.spring.store.Model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query(value = "SELECT u.id, u.name, u.price, u.country from Product as u INNER JOIN purchases p ON (p.product_id = u.id) where p.user_id = :id", nativeQuery = true)
    List<Product> getAllProductToUsers(Long id);
}
