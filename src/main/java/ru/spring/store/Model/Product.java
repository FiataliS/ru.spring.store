package ru.spring.store.Model;


public class Product {
    Long id;
    String name;
    int cost;


    public Product(long id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return name + ", цена: " + cost +'$'+ '\n';
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
