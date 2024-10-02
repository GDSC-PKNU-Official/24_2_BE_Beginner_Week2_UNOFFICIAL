package payment;

public interface PaymentStrategy {
    // 추후 Customer 자체를 넘겨 줄 생각
    void pay(int amonut);
}
