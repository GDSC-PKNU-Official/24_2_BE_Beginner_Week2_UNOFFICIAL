package cart.exception;

public class CartLimitExcessException extends Exception{

    // 장바구니에 담긴 항목의 개수가 50개를 넘으면 발생함

    private int cartNum;

    public CartLimitExcessException() {}
    public CartLimitExcessException(int cartNum) {
        super("장바구니가 다 찼습니다. (현재 장바구니 항목: " + cartNum + ")");
        this.cartNum = cartNum;
    }
}
