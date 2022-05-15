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

}
