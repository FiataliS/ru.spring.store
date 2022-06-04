package ru.spring.store.Repositories.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.spring.store.Entities.Product;

public class ProductSpecification {

    public static Specification<Product> greaterThanOrEqualTo(Integer price){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), price));
    }

    public static Specification<Product> lessThanOrEqualTo(Integer price){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), price));
    }

    public static Specification<Product> nameLike(String name){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), String.format("%%%s%%", name)));
    }

}
