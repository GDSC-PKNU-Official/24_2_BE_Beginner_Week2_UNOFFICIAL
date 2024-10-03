package cart;

import java.util.HashMap;

/**
 * 고객이 성공적으로 주문했을 때 고객이 가지고 있는 주문서입니다.
 */
public class OrderSheet {
    private final long totalAmount;
    private final HashMap<String, Integer> orderedProductHashMap;

    public OrderSheet(HashMap<String, Integer> orderedProductHashMap, long totalAmount) {
        this.orderedProductHashMap = orderedProductHashMap;
        this.totalAmount = totalAmount;
    }

    // 우선 Cart 클래스의 cart 정보와 total 값을 출력하도록 했습니다.
    public void showSheet(){
        orderedProductHashMap.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("Total Amount: " + totalAmount);
    }
}
