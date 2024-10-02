package payment;

public class ApplePay implements PaymentStrategy{
    private int balance = 0;

    public void charge(int amount){
        // Customer의 account 가 amount 보다 크거나 같은지 확인 후
        // 유효하지 않다면 "잔액이 부족함" Exception 발생
        balance += amount;
    }
    
    @Override
    public void pay(int amount){
        if(balance >= amount){
            balance -= amount;
        }
        // "잔액이 부족함" Exception 발생
    }
}
