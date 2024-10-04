package cart;

import cart.exception.CartLimitExcessException;
import product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static product.ProductDao.productList;

public class Cart {

    // 카트에 최대 50개의 항목만 담을 수 있음
    private static final int MAX_NUM = 50;

    // 장바구니 안의 상품 총액
    private long totalAmount = 0;

    // 장바구니 안의 상품 항목 개수
    private int cartNum = 0;

    private List<Map<Product, Integer>> cart = new ArrayList<>();

    // 상품의 유효성 검사
    private Product checkValidation(long productId, int quantity) {

        for(Product product : productList) {
            // 상품의 존재여부 검사
            // 고객이 입력한 productId가 productList에 없다면, false 반환
            if (product.getId() == productId) {
                // 재고여부 검사
                // 고객이 입력한 quantity(재고)가 해당 상품의 재고보다 많다면, false 반환
                if (quantity > product.getStock()) {
                    System.out.println("해당 상품의 재고가 부족합니다.");
                    return null;
                }
                // 유효한 상품이라면 Product 객체 반환
                return product;
            }
        }
        System.out.println("해당 상품이 존재하지 않습니다.");
        return null;
    }


    // id와 stock의 유효성 검사는 아직 구현 X -> 저장되어 있는 Product 객체로서 유효한지 확인?
    // 상품 정보를 cart에 저장
    public void addProduct(long productId, int quantity) throws CartLimitExcessException{
        // 장바구니에 저장된 항목 개수가 50개 이상이라면, 저장 불가
        if (cartNum >= MAX_NUM) {
            throw new CartLimitExcessException(cartNum);
        } else {
            // 상품유무, 재고유무의 유효성 검사
            // productId로 Product 객체 찾기
            Product productById = checkValidation(productId, quantity);

            // 유효한 상품이 아니라면, 끝
            if (productById == null)
                return;

            // 이미 cart에 추가하고자 하는 상품이 존재하면 true
            boolean productExistence = false;

            // 이미 cart에 있는 상품이라면, 개수만 수정
            for(Map<Product, Integer> product : cart) {
                if (product.containsKey(productById)) {
                    product.put(productById, product.get(productById) + quantity);
                    productExistence = true;
                    break;
                }
            }

            if (!productExistence) {
                Map<Product, Integer> newProduct = new HashMap<>();
                newProduct.put(productById, quantity);
                cart.add(newProduct);
            }
            System.out.println("장바구니에 상품이 담겼습니다.");

            cartNum += quantity;
        }
    }

    // 삭제할 상품 장바구니에 없으면 X, 있으면 삭제
    public void deleteProduct(long productId, int discardQuantity) {
        for(Map<Product, Integer> cartItem : cart) {
            for (Map.Entry<Product, Integer> productQuantityMap : cartItem.entrySet()) {
                // 삭제할 상품을 찾고 삭제 수량이 현재 수량과 많거나 같으면 해당 항목을 제거
                if(productId == productQuantityMap.getKey().getId()) {
                    if (productQuantityMap.getValue() <= discardQuantity) {
                        cartNum -= productQuantityMap.getValue();
                        String discardProductName = productQuantityMap.getKey().getName();
                        cart.remove(productQuantityMap);
                        System.out.println("상품: " + discardProductName + " 을 제거했습니다.");
                    } else {
                        // 수량 줄이기
                        productQuantityMap.setValue(productQuantityMap.getValue() - discardQuantity);
                        cartNum -= discardQuantity;
                        System.out.println("상품: " + productQuantityMap.getKey().getName() + " 을 " + discardQuantity + "개 제거했습니다.");
                    }
                } else {
                    System.out.println("장바구니에서 상품 ID: " + productId + " 에 해당하는 상품을 찾지 못 했습니다.");
                }
            }
        }
    }

    // 장바구니 항목들의 총액 계산
    private void calculateTotalAmount() {
        for(Map<Product, Integer> cartItem : cart) {
            for(Map.Entry<Product, Integer> productQuantityEntry : cartItem.entrySet()) {
                totalAmount += productQuantityEntry.getKey().getPrice() * productQuantityEntry.getValue();
            }
        }
    }

    public void showCart(){
        if(!cart.isEmpty()){
            for (Map<Product, Integer> cartItem : cart){
                for(Map.Entry<Product, Integer> productMap : cartItem.entrySet()){
                    System.out.println("상품 ID: " + productMap.getKey().getId());
                    System.out.println("상품명: " + productMap.getKey().getName());
                    System.out.println("상품 가격: " + productMap.getKey().getPrice() + " 원");
                    System.out.println("주문 수량: " + productMap.getValue());
                    System.out.println("결제할 금액: " + totalAmount + " 원");
                }
            }
        } else {
            System.out.println("장바구니에 상품을 담지 않았습니다.");
        }
    }

    public OrderSheet makeOrder(){
        return new OrderSheet(cart, totalAmount);
    }
}
