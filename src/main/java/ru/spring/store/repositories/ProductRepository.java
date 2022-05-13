package ru.spring.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.spring.store.Model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
