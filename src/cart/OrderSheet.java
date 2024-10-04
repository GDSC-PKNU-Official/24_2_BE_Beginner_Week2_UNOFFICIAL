package cart;

import product.Product;

import java.util.List;
import java.util.Map;

/**
 * 고객이 성공적으로 주문했을 때 고객이 가지고 있는 주문서입니다.
 */
public class OrderSheet {
    private final long totalAmount;
    private final List<Map<Product, Integer>> orderedProductHashMap;

    public OrderSheet(List<Map<Product, Integer>> orderedProductHashMap, long totalAmount) {
        this.orderedProductHashMap = orderedProductHashMap;
        this.totalAmount = totalAmount;
    }

    // 우선 Cart 클래스의 cart 정보와 total 값을 출력하도록 했습니다.
    public void showSheet(){
        for(Map<Product, Integer> productInfo : orderedProductHashMap) {
            for(Map.Entry<Product, Integer> product : productInfo.entrySet()) {
                System.out.println(product.getKey().getName() + ": " + product.getValue());
            }
        }
        System.out.println("Total Amount: " + totalAmount);
    }
}
