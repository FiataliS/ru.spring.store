package ru.spring.store.Repository;

import ru.spring.store.Model.Product;

public interface Repository {
    Product findById (Long id);
}
