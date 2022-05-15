package ru.spring.store.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import ru.spring.store.Model.Product;
import ru.spring.store.Model.Users;

import javax.persistence.NamedNativeQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {


    List<Product> findAllByPriceBetween(Integer min,Integer max);

    @Query(value = "SELECT u.id, u.name, u.price from Product as u INNER JOIN purchases p ON (p.product_id = u.id) where p.user_id = :id", nativeQuery = true)
    List getAllProductToUsers(Long id);
}
