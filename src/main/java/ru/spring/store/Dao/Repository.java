package ru.spring.store.Dao;

import ru.spring.store.Model.Product;

public interface Repository {
    Product findById (Long id);

}
