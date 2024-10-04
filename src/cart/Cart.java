package cart;

import cart.exception.CartLimitExcessException;
import product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    // 카트에 최대 50개의 항목만 담을 수 있음
    private static int MAX_NUM = 50;

    // 장바구니 안의 상품 총액
    private long total;

    // 장바구니 안의 상품 항목 개수
    private int cartNum = 0;

    List<Map<Product, Integer>> cart = new ArrayList<>();

    // CartDTO 객체 생성
    CartDTO cartInfo = new CartDTO();


    // id와 stock의 유효성 검사는 아직 구현 X -> 저장되어 있는 Product 객체로서 유효한지 확인?
    // 상품 정보를 cart에 저장
    public void addProduct(Product productId, int quantity) throws CartLimitExcessException{
        // 장바구니에 저장된 항목 개수가 50개 이상이라면, 저장 불가
        if(cartNum >= MAX_NUM) {
            throw new CartLimitExcessException(cartNum);
        } else {
            // 이미 cart에 있는 상품이라면, 개수만 수정
            for (Map<Product, Integer> product : cart) {
                if (product.containsKey(productId)) {
                    product.put(productId, product.get(productId) + quantity);
                } else {  // cart에 없는 상품이라면, cart에 추가
                    Map<Product, Integer> newProduct = new HashMap<>();
                    newProduct.put(productId, quantity);
                    cart.add(newProduct);
                }
                System.out.println("장바구니에 상품이 담겼습니다.");

                cartNum += quantity;
            }
        }
    }

    // 삭제할 상품 장바구니에 없으면 X, 있으면 삭제
    public void deleteProduct(Product productId, int quantity) {

        for (Map<Product, Integer> product : cart) {
            if (product.containsKey(productId)) {
                // 삭제하고자 하는 수량이 현재 장바구니에 들어있는 수량보다 많거나 같으면, 해당 항목 전부 삭제
                if (product.get(productId) <= quantity) {
                    cart.remove(product);
                    System.out.println("장바구니에서 해당 상품을 제거하였습니다.");
                } else {
                    product.put(productId, product.get(productId) - quantity);
                    System.out.println("장바구니에서 해당 상품을 " + quantity + "개 제거하였습니다.");
                }
                // deleteCheck = true;
            } else {
                // 삭제하고자 하는 상품이 cart에 없다면,
                System.out.println("장바구니에서 " + productId + " 상품을 찾을 수 없습니다.");
            }
        }
    }

    // 장바구니 항목들의 총액 계산
    public void getTotal(List<Map<Product, Integer>> cart, Long quantity) {
        total = 0;

        for(Map<Product, Integer> productInfo : cart) {
            for(Map.Entry<Product, Integer> product : productInfo.entrySet()) {
                total += product.getKey().getPrice() * product.getValue();
            }
        }
    }

    public OrderSheet makeOrder(){
        return new OrderSheet(cart, total);
    }
}
