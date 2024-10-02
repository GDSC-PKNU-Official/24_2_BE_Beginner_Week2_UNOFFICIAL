package common.exception;

/**
 * InsufficientBalanceException
 * 고객의 잔액이 부족할 경우 발생합니다.
 * 고객의 잔액과 지불할 금액을 알려줍니다.
 */
public class InsufficientBalanceException extends Exception {
    private int account;
    private int amountToPay;

    public InsufficientBalanceException() {}
    public InsufficientBalanceException(int account, int amountToPay) {
        super("잔액이 부족합니다. 현재 고객님의 잔액은 " + account + "원이며, 지불할 금액은 " + amountToPay + "입니다.");
        this.account = account;
        this.amountToPay = amountToPay;
    }
}
