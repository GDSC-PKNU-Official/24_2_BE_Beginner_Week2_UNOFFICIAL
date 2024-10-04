package product;

import common.Category;

public class Product {
    private long id;
    private String name;
    private Category category;
    private String brand;
    private int price;
    private int stock;

    public Product(long id, String name, Category category, String brand, int price, int stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public String toString(){
        return "id: " + id + ", name: " + name + ", category: " + category + ", brand: " + brand + ", price: " + price + ", stock: " + stock;
    }
}
