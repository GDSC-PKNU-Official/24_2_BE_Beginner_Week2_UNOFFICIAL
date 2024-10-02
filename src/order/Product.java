package order;

public class Product {
    private long id;
    private String name;
    private String brand;
    private int price;

    public Product(long id, String name, String brand, int price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }
}
