package payment;

import java.time.LocalDateTime;

public class CreditCardPay implements PaymentStrategy {
    private static int accumulatedAmount = 0;
    private LocalDateTime paymentDate = LocalDateTime.now();

    @Override
    public void pay(int amount) {
        accumulatedAmount += amount;

        // if (shouldPay())
        // Customer의 account 감소

        // Customer의 account가 충분치 않다면 account까지 모두
        // 지불 후 남은 금액은 다음으로 이월 (+ 이자)
    }

    private boolean shouldPay() {
        return paymentDate.isEqual(LocalDateTime.now());
    }
}
