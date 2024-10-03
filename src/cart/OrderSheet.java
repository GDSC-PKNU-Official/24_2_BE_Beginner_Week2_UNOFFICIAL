package cart;

import java.util.HashMap;

/**
 * 고객이 성공적으로 주문했을 때 고객이 가지고 있는 주문서입니다.
 */
public class OrderSheet {
    private long totalAmount;
    private HashMap<String, Integer> orderedProductHashMap;

    public OrderSheet(HashMap<String, Integer> orderedProductHashMap, long totalAmount) {
        this.orderedProductHashMap = orderedProductHashMap;
        this.totalAmount = totalAmount;
    }

    public void showSheet(){
        // Product 매핑 후 필요한 정보만 보여줌
    }
}
