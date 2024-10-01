package order;

import java.time.LocalDateTime;

public class Order {
    private long id;
    private LocalDateTime orderDate;

    public Order(long id, LocalDateTime orderDate) {
        this.id = id;
        this.orderDate = orderDate;
    }
}
