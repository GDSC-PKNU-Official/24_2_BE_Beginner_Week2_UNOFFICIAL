package order;

import common.Category;

public class Product {
    private long id;
    private String name;
    private Category category;
    private String brand;
    private double price;
    private final int stock;

    public Product(long id, String name, Category category, String brand, double price, int stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
    }
}
